//
//  SecondViewController.swift
//  musicNew
//
//  Created by Sam Henry on 2/8/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBAction func findMusic(_ sender: UIButton) {
        if(UIApplication.shared.canOpenURL(URL(string: "spotify://")!)){
            UIApplication.shared.open(URL(string: "spotify://")!, options: [:], completionHandler: nil)
        }else {
            if(UIApplication.shared.canOpenURL(URL(string: "music://")!)){
                UIApplication.shared.open(URL(string: "music://")!, options: [:], completionHandler: nil)
            } else {
                UIApplication.shared.open(URL(string: "http://www.apple.com/music/")!, options: [:], completionHandler: nil)
            }
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

