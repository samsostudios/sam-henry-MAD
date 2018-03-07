//
//  TableViewController.swift
//  instagramFeed
//
//  Created by Sam Henry on 3/5/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {
    
    var feeds = [Feed]()
    
    var testArray: [String] = ["Stuff", "Test"]

    override func viewDidLoad() {
        super.viewDidLoad()
        loadjson()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    func loadjson(){
        let urlPath = "https://api.instagram.com/v1/users/self/media/recent/?access_token=12436863.6676423.9071c83de9244460a7ae9bf2881000ea"
        guard let url = URL(string: urlPath)
            else {
                print("url error")
                return
        }
        
        let session = URLSession.shared.dataTask(with: url, completionHandler: {(data, response, error) in
            let httpResponse = response as! HTTPURLResponse
            let statusCode = httpResponse.statusCode
            guard statusCode == 200
                else {
                    print("file download error")
                    return
            }
        
            print("download complete")
            DispatchQueue.main.async {self.parsejson(data!)}
        })

        session.resume()
    }
    
    func parsejson(_ data: Data){
        print(data)
        do {
            let json = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! [String:Any]
            //get all results
            let allresults = json["data"] as! [[String:AnyObject]]
            //print(allresults)
            
            //print("test")
            for result in allresults {
                
                print("------------caption-----------------")
                print(result["caption"]!["text"]!!)
                print("-------------likes----------------")
                print(result["likes"]!["count"]!!)
                print("-------------comments----------------")
                print(result["comments"]!["count"]!!)
                print("-------------url----------------")
                print(result["link"]!)
                //check that data exists
                guard let newtitle = result["caption"]!["text"]! as? String,
                    let newslikes = result["likes"]!["count"] as? Int,
                    let newcomments = result["comments"]!["count"] as? Int,
                    let newlink = result["link"] as? String
                    else {
                        print("failed")
                        continue
                }
                
                //create new object
                let newfeed = Feed(caption: newtitle, likes: newslikes, comments: newcomments, url: newlink)
//                print("-------------newfeed----------------")
//                print(newfeed)
                
                //add object to array
                self.feeds.append(newfeed)
                
            }
            print(feeds)
        }
        catch let jsonErr{
            print(jsonErr.localizedDescription)
            return
        }
        tableView.reloadData()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        print("feed count: \(feeds.count)")
        return feeds.count
    }


    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
//        print("test")
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! TableViewCell
        let feed = feeds[indexPath.row]
        cell.titleLabel!.text =  feed.caption
        //print(feed.caption)
        cell.likesLabel!.text = String("Likes: \(feed.likes)")
        cell.commentsLabel!.text = String("Comments: \(feed.comments)")
        return cell
    }
 
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "showDetail"{
            if let indexPath = self.tableView.indexPathForSelectedRow{
                let feed = feeds[indexPath.row]
                let url =  feed.url
                print("url: \(url)")
                let controller = segue.destination as! DetailViewController
                controller.detailItem = url
                controller.navigationItem.leftBarButtonItem = self.splitViewController?.displayModeButtonItem
                controller.navigationItem.leftItemsSupplementBackButton = true
            }
        }
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
