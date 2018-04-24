//
//  DetailViewController.swift
//  Rooted
//
//  Created by Sam Henry on 3/12/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var infoLabel1: UILabel!
    
    var titleLabel : String?
    var imageType : String?
    var infoLabel : String?
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        //print(imageType)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        switch imageType{
        case "bulb"?:
            imgView.image = UIImage(named: "bulbpic")
            infoLabel1.text = infoLabel
            self.title = titleLabel
            break
        case "jelly"?:
            imgView.image = UIImage(named: "jellypic")
            infoLabel1.text = infoLabel
            self.title = titleLabel
            break
        case "aloe"?:
            imgView.image = UIImage(named: "aloepic")
            infoLabel1.text = infoLabel
            self.title = titleLabel
            break
        case "rose"?:
            imgView.image = UIImage(named: "rosepic")
            infoLabel1.text = infoLabel
            self.title = titleLabel
            break
        default:
            print("error")
            break
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
