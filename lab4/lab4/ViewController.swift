//
//  ViewController.swift
//  lab4
//
//  Created by Sam Henry on 10/18/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var toDo = Item()
    let filename = "toDo.plist"
    
    @IBOutlet weak var doItem: UILabel!
    
    func docFilePath(_ filename: String) -> String{
        let path = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true)
        let dir = path[0] as NSString
        
        print(dir.appendingPathComponent(filename))
        return dir.appendingPathComponent(filename)
    }
    
    @IBAction func unwindSegue(_ segue: UIStoryboardSegue){
        doItem.text = toDo.item
    }

    override func viewDidLoad() {
        let filePath = docFilePath(filename)
        
        if FileManager.default.fileExists(atPath: filePath){
            let path = filePath
            
            let dataDictionary = NSDictionary(contentsOfFile: path) as! [String:String]
            
            if dataDictionary.keys.contains("item") {
                toDo.item = dataDictionary["item"]
                doItem.text = toDo.item
            }
        }
        
        let app = UIApplication.shared
        NotificationCenter.default.addObserver(self, selector: #selector(UIApplicationDelegate.applicationWillResignActive(_:)), name: NSNotification.Name(rawValue: "UIApplicationWillResignActiveNotification"), object: app)
        
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    func applicationWillResignActive(_ notifacation: Notification){
        let filePath = docFilePath(filename)
        let data = NSMutableDictionary()
        
        if toDo.item != nil{
            data.setValue(toDo.item, forKey: "item")
        }
        data.write(toFile: filePath, atomically: true)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

