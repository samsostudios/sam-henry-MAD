//
//  ViewController.swift
//  lab2
//
//  Created by Sam Henry on 9/20/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBOutlet weak var superTitle: UIStackView!
    
    @IBOutlet weak var pickLabel: UILabel!
    
    @IBOutlet weak var yearChangeSwitch: UISegmentedControl!
    
    @IBOutlet weak var imgLabel: UILabel!
    
    @IBAction func yearChange(_ sender: UISegmentedControl) {
        if(yearChangeSwitch.selectedSegmentIndex == 0 && charChangeSwitch.selectedSegmentIndex == -1){
//            imgView.isHidden = false
//            imgViewNew.isHidden = true
            imgView.image = UIImage(named: "logo")
        }
        if(yearChangeSwitch.selectedSegmentIndex == 1 && charChangeSwitch.selectedSegmentIndex == -1){
//            imgView.isHidden = true
//            imgViewNew.isHidden = false
            imgView.image = UIImage(named: "logoNew")
        }
    }

    @IBOutlet weak var imgView: UIImageView!
    
    @IBOutlet weak var charLabel: UILabel!
    
    @IBOutlet weak var charChangeSwitch: UISegmentedControl!
    
    @IBAction func charChange(_ sender: UISegmentedControl) {
        if(yearChangeSwitch.selectedSegmentIndex == 0){
            if(charChangeSwitch.selectedSegmentIndex == 0){
                charLabel.text = "Mario"
                imgView.image = UIImage(named: "mario8")
            }
            if(charChangeSwitch.selectedSegmentIndex == 1){
                charLabel.text = "luigi"
                imgView.image = UIImage(named: "luigi8")
            }
            if(charChangeSwitch.selectedSegmentIndex == 2){
                charLabel.text = "Peach"
                imgView.image = UIImage(named: "peach8")
            }
            if(charChangeSwitch.selectedSegmentIndex == 3){
                charLabel.text = "Yoshi"
                imgView.image = UIImage(named: "yoshi8")
            }
        }
        if(yearChangeSwitch.selectedSegmentIndex == 1){
            if(charChangeSwitch.selectedSegmentIndex == 0){
                charLabel.text = "Mario"
                imgView.image = UIImage(named: "mario16")
            }
            if(charChangeSwitch.selectedSegmentIndex == 1){
                charLabel.text = "Luigi"
                imgView.image = UIImage(named: "luigi16")
            }
            if(charChangeSwitch.selectedSegmentIndex == 2){
                charLabel.text = "Peach"
                imgView.image = UIImage(named: "peach16")
            }
            if(charChangeSwitch.selectedSegmentIndex == 3){
                charLabel.text = "Yoshi"
                imgView.image = UIImage(named: "yoshi16")
            }
        }
    }
    
    @IBOutlet weak var fontSwitch: UISwitch!
    
    @IBAction func fontChange(_ sender: UISwitch) {
        if(fontSwitch.isOn){
            charLabel.font = UIFont(name: "Alien Encounters", size: 25)
        }
        else{
            charLabel.font = UIFont(name: "Baskerville", size: 25)
        }
    }
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        
        
        let fontSize = sender.value
        fontSizeLabel.text = String(format: "%0.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        charLabel.font = UIFont(name: charLabel.font.fontName, size: fontSizeCGFloat)
        
    }
    

}

