//
//  ViewController.swift
//  BDGT
//
//  Created by Sam Henry on 10/13/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource {
    
    var categories = [(String, String, [Int])]()
    
    
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
    
    @IBOutlet weak var headerView: UIView!
    
    func newBudgetCategory(){
        
        if(addCatTxtField.text != ""){
            categories.append((addCatTxtField.text!, "",[]))
            
            let indexPath = IndexPath(row: categories.count - 1, section: 0)
            
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
    
//    func updateAmounts(){
//        var incomeVal:Float //Holds income input
//        var cellTxtAount: Float
//        var totalBudget: Float = 0.0
//        var totalSave: Float
//        
//        let myIndex = categories.count
//        
//        if incomeTxtField.text!.isEmpty{
//            incomeVal = 0.0
//        }else{
//            incomeVal = Float(incomeTxtField.text!)!
//        }
//        
//        if categories[myIndex].1 == "" {
//            cellTxtAount = 0.0
//        }else{
//            cellTxtAount = Float(categories[myIndex].1)!
//            totalBudget += cellTxtAount
//        }
//        
//        totalSave = incomeVal -  totalBudget
//        
//        let currencyFormatter = NumberFormatter()
//        currencyFormatter.numberStyle =  NumberFormatter.Style.currency
//        incomeLabel.text = currencyFormatter.string(from: NSNumber(value: incomeVal))
//        totalSavings.text = currencyFormatter.string(from: NSNumber(value: totalSave))
//    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        print(textField.tag)
        if textField.tag != -1 && textField.text != "" {
            if textField.tag != -2 && textField.text != ""{
                categories[textField.tag].1 = textField.text!
                print(categories[textField.tag])
            }
        }
//        updateAmounts()
    }
    override func viewDidLoad() {
        if headerView != nil {
            let tapGesture = UITapGestureRecognizer(target: self, action: #selector(hideKeyboard))
            self.headerView!.addGestureRecognizer(tapGesture)
        }
        
        incomeTxtField.delegate = self
        addCatTxtField.delegate = self
        
        super.viewDidLoad()
        budgetTable.tableFooterView = UIView(frame: CGRect.zero)
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    func hideKeyboard(){
        view.endEditing(true)
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        budgetTable.deselectRow(at: indexPath, animated: true)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section:Int) -> Int {
        return (categories.count)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "budgetCell", for: indexPath) as! ViewControllerTableViewCell
        
        cell.categoryLabel.text = categories[indexPath.row].0
        cell.amountTxtField.tag = indexPath.row
        cell.amountTxtField.delegate = self
        cell.tag = indexPath.row
        
        return (cell)
    }
    @IBAction func unwind(_segue: UIStoryboardSegue){
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "editCategory" {
            let budgetViewController = segue.destination as? BudgetViewController
            if let s = sender as? ViewControllerTableViewCell {
            
                budgetViewController?.listTitle = categories[s.tag].0
                budgetViewController?.initialBudget = categories[s.tag].1
                budgetViewController?.lineItems = categories[s.tag].2
            }
            
        }
       
    }
}

