//
//  plants.swift
//  Rooted
//
//  Created by Sam Henry on 3/12/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import Foundation
import RealmSwift

class plants: Object{
    @objc dynamic var name = ""
    @objc dynamic var type = ""
    @objc dynamic var info = ""
    @objc dynamic var isWatered = false
}
