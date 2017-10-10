//
//  ViewController.swift
//  lab3
//
//  Created by Sam Henry on 10/9/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
 //income section
    @IBOutlet weak var amountLabel: UILabel!
    
    @IBOutlet weak var incomeTxtField: UITextField!

    @IBOutlet weak var savingsLabel: UILabel!
    
    @IBOutlet weak var savingsAmount: UILabel!
//budget section
    @IBOutlet weak var budgetLabel: UILabel!
    
    @IBOutlet weak var title1label: UITextField!
    @IBOutlet weak var title1Amount: UITextField!
    
    @IBOutlet weak var title2label: UITextField!
    @IBOutlet weak var title2Amount: UITextField!
    
    @IBOutlet weak var title3label: UITextField!
    @IBOutlet weak var title3Amount: UITextField!
    
    
//update amounts
    func updateIBamounts(){
        var incomeVal:Float //income amount
        var totalBudget:Float = 0.0
        var title1Val:Float // budget amount
        var title2Val:Float
        var title3Val:Float
        
        if incomeTxtField.text!.isEmpty{
            incomeVal =     0.0
        }else{
            incomeVal = Float(incomeTxtField.text!)!
        }
        
        if(title1Amount.text!.isEmpty){
            title1Val = 0.0
            totalBudget += title1Val
        }else{
            title1Val = Float(title1Amount.text!)!
            totalBudget += title1Val
        }
        
        if(title2Amount.text!.isEmpty){
            title2Val = 0.0
            totalBudget += title2Val
        }else{
            title2Val = Float(title2Amount.text!)!
            totalBudget += title2Val
        }
        
        if(title3Amount.text!.isEmpty){
            title3Val = 0.0
            totalBudget += title3Val
        }else{
            title3Val = Float(title3Amount.text!)!
            totalBudget += title3Val
        }
        
        var totalSave:Float = 0.0
        
        if(totalBudget <= incomeVal){
            totalSave = incomeVal - totalBudget
        }else{
            let alert = UIAlertController(title: "Warning", message: "You have exceeded your income amount for this month!", preferredStyle: UIAlertControllerStyle.alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertActionStyle.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: {action in
                self.savingsAmount.text = "0"
                self.updateIBamounts()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        
        
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle =  NumberFormatter.Style.currency
        amountLabel.text = currencyFormatter.string(from: NSNumber(value: incomeVal))
        savingsAmount.text = currencyFormatter.string(from: NSNumber(value: totalSave))
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateIBamounts()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }

    override func viewDidLoad() {
        incomeTxtField.delegate = self
        title1label.delegate = self
        title1Amount.delegate = self
        title2label.delegate = self
        title2Amount.delegate = self
        title3label.delegate = self
        title3Amount.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

