//
//  ViewController.swift
//  BDGT
//
//  Created by Sam Henry on 10/13/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource {
    
    var basics = [String]()
    
    
//Income section
    @IBOutlet weak var incomeLabel: UILabel!
    
    @IBOutlet weak var incomeTxtField: UITextField!
    
    @IBOutlet weak var savingsLabel: UILabel!
    
    @IBOutlet weak var totalSavings: UILabel!

//Budget Table Section
    
    @IBOutlet weak var budgetTable: UITableView!
    
    @IBOutlet weak var addCatTxtField: UITextField!
    
    @IBAction func addButtonTapped(_ sender: Any) {
            newBudgetCategory()
    }
    
    func newBudgetCategory(){
        
        if(addCatTxtField.text != ""){
            basics.append(addCatTxtField.text!)
            
            let indexPath = IndexPath(row: basics.count - 1, section: 0)
            
            budgetTable.beginUpdates()
            budgetTable.insertRows(at: [indexPath], with: .automatic)
            budgetTable.endUpdates()
            
            addCatTxtField.text = ""
            view.endEditing(true)
        }else{
            let alert = UIAlertController(title: "Warning!", message: "Please add a category label", preferredStyle: UIAlertControllerStyle.alert)
            let okAction = UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil)
            
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
    }
    
    func updateAmounts(){
//        var incomeVal:Float //Holds income input
//        
//        if incomeTxtField.text!.isEmpty{
//            incomeVal = 0.0
//        }else{
//            incomeVal = Float(incomeTxtField.text!)!
//        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }

    override func viewDidLoad() {
        incomeTxtField.delegate = self
        addCatTxtField.delegate = self
        super.viewDidLoad()
        budgetTable.tableFooterView = UIView(frame: CGRect.zero)
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section:Int) -> Int {
        return (basics.count)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "budgetCell", for: indexPath) as! ViewControllerTableViewCell
        
        cell.categoryLabel.text = basics[indexPath.row]
        
        return (cell)
    }

}

