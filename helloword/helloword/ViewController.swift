//
//  ViewController.swift
//  helloword
//
//  Created by Sam Henry on 8/31/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func buttonPressed(_ sender: UIButton) {
        messageTxt.text = "Hello World!"
    }
    @IBOutlet weak var messageTxt: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

