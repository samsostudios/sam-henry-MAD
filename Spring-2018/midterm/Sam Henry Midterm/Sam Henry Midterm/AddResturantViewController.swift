//
//  AddResturantViewController.swift
//  Sam Henry Midterm
//
//  Created by Sam Henry on 3/15/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class AddResturantViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var addName: UITextField!
    @IBOutlet weak var addLink: UITextField!
    
    var name = String()
    var link = String()
    var rest = [Resturants]()
    
    override func viewDidLoad() {
        addName.delegate = self
        addLink.delegate = self
        super.viewDidLoad()
        print("rest: \(rest)")

        // Do any additional setup after loading the view.
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        addName.resignFirstResponder()
        addLink.resignFirstResponder()
        return true
    }
    func textFieldDidEndEditing(_ textField: UITextField) {
        name = addName.text!
        print(name)
        link = addLink.text!
        print(link)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
//        if segue.identifier == "doneSugue"{
//            if addName.text?.isEmpty == false{
//                let newItem = Resturants(name: name, url: link)
//                
//                
//            }
//        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
