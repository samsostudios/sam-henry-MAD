//
//  AddPlantViewController.swift
//  Rooted
//
//  Created by Sam Henry on 3/12/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class AddPlantViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource, UITextFieldDelegate {
    
    @IBOutlet weak var plantName: UITextField!
    @IBOutlet weak var typePicker: UIPickerView!
    
    var pname = String()
    var ptype = String()
    var newPlant = plants()
    
    let types = ["Aloe Vera", "Jelly Bean", "Dessert Rose", "Bulb Cactus"]

    override func viewDidLoad() {
        plantName.delegate = self
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        plantName.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        pname = plantName.text!
//        print("pname: \(pname)")
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }

    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return types.count
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return types[row]
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        ptype = types[row]
//        print(ptype)
    }
    
    func pickerView(_ pickerView: UIPickerView, attributedTitleForRow row: Int, forComponent component: Int) -> NSAttributedString? {
        
        return NSAttributedString(string: types[row], attributes: [NSAttributedStringKey.foregroundColor:UIColor.white])
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneSegue"{
            let newItem = plants()
            switch ptype{
            case "Aloe Vera":
                newItem.type = "aloe"
                newItem.name = pname
                break
            case "Jelly Bean":
                newItem.type = "jelly"
                newItem.name = pname
                break
            case "Dessert Rose":
                newItem.type = "rose"
                newItem.name = pname
                break
            case "Bulb Cactus":
                newItem.type = "bulb"
                newItem.name = pname
                break
            default:
                print("error")
                break
            }
            newPlant = newItem
        }
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
