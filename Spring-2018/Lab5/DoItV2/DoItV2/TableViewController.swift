//
//  TableViewController.swift
//  DoItV2
//
//  Created by Sam Henry on 3/19/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit
import RealmSwift

class TableViewController: UITableViewController {
    
    var realm : Realm!
    
    var toDoList: Results<toDo>{
        get{
            return realm.objects(toDo.self)
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        
        do{
            realm = try Realm()
        }catch let error{
            print(error.localizedDescription)
        }

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        print(Realm.Configuration.defaultConfiguration.fileURL!)
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
        return toDoList.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath) as! TableViewCell
        let item = toDoList[indexPath.row]
        switch item.type {
        case "Homework":
            cell.rowImgView.image = UIImage(named: "homework")
            break
        case "Work":
            cell.rowImgView.image = UIImage(named: "work")
            break
        case "Life":
            cell.rowImgView.image = UIImage(named: "life")
            break
        case "Other":
            cell.rowImgView.image = UIImage(named: "etc")
            break
        default:
            print("error")
        }
        cell.itemLabel.text = item.name
        cell.accessoryType = item.completed ? .checkmark : .none
        
        return cell
    }
 
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let item = toDoList[indexPath.row]
        try! self.realm.write {
            item.completed = !item.completed
        }
        tableView.reloadRows(at: [indexPath], with: .automatic)
    }
    
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            let item = toDoList[indexPath.row]
            try! self.realm.write {
                self.realm.delete(item)
            }
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    
    @IBAction func unwindSegue(_ segue: UIStoryboardSegue){
        if segue.identifier == "saveSegue"{
            let source = segue.source as! AddViewController
            let curItem = toDo()
            curItem.name = (source.addedItem.name)
            curItem.completed = (source.addedItem.completed)
            curItem.type = (source.addedItem.type)
            
            do{
                try self.realm.write {
                    self.realm.add(curItem)
                    self.tableView?.insertRows(at: [IndexPath.init(row: self.toDoList.count-1, section:0)], with: .automatic)
                }
            }catch let error{
                print(error.localizedDescription)
            }
            tableView.reloadData()
        }
    }
    

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
