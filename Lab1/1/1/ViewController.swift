//
//  ViewController.swift
//  1
//
//  Created by Sam Henry on 9/13/17.
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

    @IBOutlet weak var imageView: UIImageView!
    
    @IBOutlet weak var imageLabel: UILabel!
    

    @IBAction func button(_ sender: UIButton) {
        if(sender.tag == 1){
            imageView.image = UIImage(named: "Spring")
            imageLabel.text = "This is one of my favorite photos taken last spring here in Boulder, CO. The spring storms made for lush green forests in Chautauqua Park."
        }
        if(sender.tag == 2){
            imageView.image = UIImage(named: "Summer")
            imageLabel.text = "This photo was taken last summer in the Glenwood Canyon near the Hanging Lakes Trail. The early morning light casted the reflections on to the still waters beneath."
        }
        if(sender.tag == 3){
            imageView.image = UIImage(named: "Fall")
            imageLabel.text = "This photo was taken last fall on Kenosha Pass. This is my favorite place to go in the Fall for the extensive forests of Apen Trees that are all bright yellow."
        }
        if(sender.tag == 4){
            imageView.image = UIImage(named: "Winter")
            imageLabel.text = "This photo was taken a few winters ago on the CU Boulder campus. The fresh morning snow glistening on the Flatirons in the bouckground made for a sight to be seen!"
        }
    }
}

