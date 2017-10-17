//
//  ViewControllerTableViewCell.swift
//  BDGT
//
//  Created by Sam Henry on 10/16/17.
//  Copyright © 2017 Sam Henry. All rights reserved.
//

import UIKit

class ViewControllerTableViewCell: UITableViewCell {
    
    @IBOutlet weak var categoryLabel: UILabel!
    
    @IBOutlet weak var amountTxtField: UITextField!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
}
