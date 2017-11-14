//
//  ViewController.swift
//  Midterm
//
//  Created by Sam Henry on 10/19/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var milageTxtField: UITextField!
    
    @IBOutlet weak var commuteLabel: UILabel!
    
    @IBOutlet weak var gasLabel: UILabel!
    
    @IBOutlet weak var calcBtn: UIButton!
    
    @IBAction func calcBtnAction(_ sender: UIButton) {
        updateLabels()
    }
    
    @IBOutlet weak var imgView: UIImageView!
    
    @IBOutlet weak var transChange: UISegmentedControl!
    
    @IBAction func transChangeSwitch(_ sender: UISegmentedControl) {
        if transChange.selectedSegmentIndex == 0{
            imgView.image = UIImage(named: "bike")
            updateLabels()
        }
        if transChange.selectedSegmentIndex == 1{
            updateLabels()
            imgView.image = UIImage(named: "car")
            
            let alert =  UIAlertController(title: "Hey There!", message: "Can we suggest carpooling? Help save the enironment!", preferredStyle: UIAlertControllerStyle.alert)
            let okayAction = UIAlertAction(title: "Okay", style: UIAlertActionStyle.default, handler: nil)
            
            alert.addAction(okayAction)
            
            present(alert, animated: true, completion: nil)
        }
        if transChange.selectedSegmentIndex == 2{
            updateLabels()
            imgView.image = UIImage(named: "bus")
        }
    }

    @IBOutlet weak var monthSwitch: UISwitch!
    
    @IBAction func switchChange(_ sender: UISwitch) {
        updateLabels()
    }
    
    func updateLabels(){
        var totMilage: Float
        var totTime: Float
        var totGas: Float
        
        if(milageTxtField.text!.isEmpty == false){
            totMilage = Float(milageTxtField.text!)!
        }else{
            totMilage = 0.0
        }
        
        let formatter = NumberFormatter()
        formatter.numberStyle = NumberFormatter.Style.decimal
        
        if monthSwitch.isOn{
            if transChange.selectedSegmentIndex == 0{
                totTime = ((totMilage / 10) * 60) * 20
                //            totGas = totMilage / 24
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = "No Gas Needed!"
            }
            
            if transChange.selectedSegmentIndex == 1{
                totTime = ((totMilage / 20) * 60) * 20
                totGas = (totMilage / 24)  * 20
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = formatter.string(from: NSNumber(value: totGas))! + " Gallons"
            }
            
            if transChange.selectedSegmentIndex == 2{
                totTime = (((totMilage / 12) * 60) + 10) * 20
                //            totGas = totMilage / 24
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = "No Gas Needed!"
            }
        }else{
            if transChange.selectedSegmentIndex == 0{
                totTime = (totMilage / 10) * 60
                //            totGas = totMilage / 24
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = "No Gas Needed!"
            }
            
            if transChange.selectedSegmentIndex == 1{
                totTime = (totMilage / 20) * 60
                totGas = totMilage / 24
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = formatter.string(from: NSNumber(value: totGas))! + " Gallons"
            }
            
            if transChange.selectedSegmentIndex == 2{
                totTime = ((totMilage / 12) * 60) + 10
                //            totGas = totMilage / 24
                
                commuteLabel.text = formatter.string(from: NSNumber(value: totTime))! + " Minutes"
                gasLabel.text = "No Gas Needed!"
            }
        }
    }
    
    @IBOutlet weak var gasAmountLabel: UILabel!
    
    @IBAction func gasAmount(_ sender: UISlider) {
        let gas = sender.value
        gasAmountLabel.text = String(format: "%0.0f", gas) + " Gallons"
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        milageTxtField.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

