//
//  ViewController.swift
//  notes
//
//  Created by Sam Henry on 2/18/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    var todoList = Todo()
    let kfilename = "todoData.plist"
    
    var words = [String]()
    var searchController : UISearchController!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        if let pathURL = Bundle.main.url(forResource: "todoList", withExtension: "plist"){
            let plistdecoder = PropertyListDecoder()
            do {
                let data = try Data(contentsOf: pathURL)
                todoList.todoData = try plistdecoder.decode([String: [String]].self, from: data)
                todoList.todoItems = Array(todoList.todoData.keys)
            } catch {
                print(error)
            }
        }
        
        //search results
        let resultsController = SearchResultsController() //create an instance of our SearchResultsController class
        resultsController.allwords = todoList.todoItems //set the allwords property to our words array
        searchController = UISearchController(searchResultsController: resultsController) //initialize our search controller with the resultsController when it has search results to display
        
        //search bar configuration
        searchController.searchBar.placeholder = "Search Items" //place holder text
        //searchController.searchBar.sizeToFit() //sets appropriate size for the search bar
        tableView.tableHeaderView=searchController.searchBar //install the search bar as the table header
        searchController.searchResultsUpdater = resultsController //sets the instance to update search results
        
        let app = UIApplication.shared
        
        NotificationCenter.default.addObserver(self, selector: #selector(ViewController.applicationWillResignActive(_:)), name: NSNotification.Name.UIApplicationWillResignActive, object: app)
        
        self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        //enables large titles
        navigationController?.navigationBar.prefersLargeTitles = true
    }
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return todoList.todoItems.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        cell.textLabel?.text = todoList.todoItems[indexPath.row]
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "itemSegue"{
            let detailVC = segue.destination as! DetailViewController
            let indexPath = tableView.indexPath(for: sender as! UITableViewCell)!
            
            detailVC.title = todoList.todoItems[indexPath.row]
            detailVC.todoListDetails = todoList
            detailVC.selectedItem = indexPath.row
        }
    }
    
    @objc func applicationWillResignActive(_ notification: NSNotification){
        let dirPath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        let docDir = dirPath[0]
        
        let dataFileURL = docDir.appendingPathComponent(kfilename)
        let plistEncoder = PropertyListEncoder()
        plistEncoder.outputFormat = .xml
        do{
            let data = try plistEncoder.encode(todoList.todoData)
            try data.write(to: dataFileURL)
        }catch{
            print(error)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

