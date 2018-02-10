//
//  FirstViewController.swift
//  musicNew
//
//  Created by Sam Henry on 2/8/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {
    
    @IBOutlet weak var artistPicker: UIPickerView!
    @IBOutlet weak var songLabel: UILabel!
    
    let artistComponent = 0
    let songComponent = 1
    
    var artistSongs = [String: [String]]()
    var artists = [String]()
    var songs = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        if let pathURL = Bundle.main.url(forResource: "myArtists", withExtension: "plist"){
            let plistDecoder = PropertyListDecoder() //creates property list decoder object
            do{
                let data = try Data(contentsOf: pathURL) //gathers all data
                
                //decodes the data list from above
                artistSongs = try plistDecoder.decode([String: [String]].self, from: data)
                //create an array of all artists
                artists = Array(artistSongs.keys)
                //creates array of the corresponding artists songs
                songs = artistSongs[artists[0]]! as [String]
            }
            catch{
                print(error)
            }
        }
    }
    
    //returns the number of pickers
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 2
    }
    
    //returns the number of rows in each of the pickers
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if component == artistComponent{
            return artists.count
        }else{
            return songs.count
        }
    }
    
    //sets the title for a given row in the pickers
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if component == artistComponent{
            return artists[row]
        }else{
            return songs[row]
        }
    }
    
    //changes songs when the artists change
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if component == artistComponent{
            let selectedArtist = artists[row] //get selected artist
            songs = artistSongs[selectedArtist]! //get corresponding albums
            print(songs)
            
            //reloads the song picker for the selected artist
            artistPicker.reloadComponent(songComponent)
            artistPicker.selectRow(0, inComponent: songComponent, animated: true) //reload picker to start at 0
        }
        
        let artistRow = pickerView.selectedRow(inComponent: artistComponent) //gets selected row for artist
        let songRow = pickerView.selectedRow(inComponent: songComponent) //gets selected row for song
        
        songLabel.text = "You Picked \(songs[songRow]) by \(artists[artistRow])"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

