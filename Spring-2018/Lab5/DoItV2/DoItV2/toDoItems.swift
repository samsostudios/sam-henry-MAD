//
//  toDoItem.swift
//  DoItV2
//
//  Created by Sam Henry on 3/19/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import Foundation
import RealmSwift

class toDo: Object{
    @objc dynamic var name = ""
    @objc dynamic var completed = false
    @objc dynamic var type = ""
}
