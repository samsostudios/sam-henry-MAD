//
//  ViewController.swift
//  DaVinci
//
//  Created by Sam Henry on 9/5/17.
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

    @IBOutlet weak var image: UIImageView!
    
    @IBAction func imageChange(_ sender: UIButton) {
        if(sender.tag == 1){
            image.image = UIImage(named: "monaLisa")
        }
        if(sender.tag == 2){
            image.image = UIImage(named: "vitruvian")
        }
    }

}

