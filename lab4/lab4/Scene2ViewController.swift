//
//  Scene2ViewController.swift
//  lab4
//
//  Created by Sam Henry on 10/18/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var addItemTxtField: UITextField!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneAdd" {
            let scene1ViewController = segue.destination as! ViewController
            
            if addItemTxtField.text!.isEmpty == false {
                scene1ViewController.toDo.item = addItemTxtField.text
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        addItemTxtField.delegate = self

        // Do any additional setup after loading the view.
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
