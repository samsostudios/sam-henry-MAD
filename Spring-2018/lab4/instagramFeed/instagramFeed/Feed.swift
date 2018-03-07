//
//  Feed.swift
//  instagramFeed
//
//  Created by Sam Henry on 3/5/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import Foundation

struct Feed: Decodable{
    let caption: String
    let likes: Int
    let comments: Int
    let url: String
}
