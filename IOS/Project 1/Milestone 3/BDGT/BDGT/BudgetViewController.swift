//
//  BudgetViewController.swift
//  BDGT
//
//  Created by Sam Henry on 10/16/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class BudgetViewController: UIViewController {

    @IBOutlet weak var categoryLabel: UILabel!
    
    @IBOutlet weak var budgetLabel: UILabel!
    
    var lineItems = [Int]()
    
    var listTitle : String = ""
    
    var initialBudget : String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        categoryLabel?.text = listTitle
        budgetLabel?.text = initialBudget
        // Do any additional setup after loading the view.
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
