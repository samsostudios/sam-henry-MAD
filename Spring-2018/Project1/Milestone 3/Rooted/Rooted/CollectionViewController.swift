//
//  CollectionViewController.swift
//  Rooted
//
//  Created by Sam Henry on 3/11/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit
import RealmSwift

private let reuseIdentifier = "Cell"

class CollectionViewController: UICollectionViewController {
    
    var realm : Realm!
    let sectionInsets = UIEdgeInsets(top: 25.0, left: 5.0, bottom: 25.0, right: 5.0)
    
    var plantName = [String]()
    var plantTypes = [String]()
    var plantInfo = [String]()
    var bulbInfo = "• Bulb Cactus' should be watered atleast once a week! \n• Ideal daily sunlight is 16 hours of direct sun and artifical light combined \n• Ideal tempurature gradients ranges from 45ºF to 85ºF"
    var aloeInfo = "• Aloe Vera should be watered every three weeks! \n• You should try to exposed Aloe to as much direct as possible everyday! \n• Ideal temperatures of no less than 50-60ºF in the summer and no less than 40ºF in the winter"
    var roseInfo = "• Desert Roses' shoudld be watered when the soil feels dry in the summer and every 3-4 weeks in the winter! \n• You should try to exposed Desert Roses' to as much direct as possible everyday! \n• Ideal temperatures should never drop below 70ºF for optimal growth"
    var jellyInfo = "• Jelly Bean succulents should be watered when the soil feels dry! \n• You should try to exposed Jelly beans to as much direct sunlight possible everyday! \n• The temperature should not drop below 60ºF for optimal growth"
    
    var plantsList: Results<plants>{
        get{
            return realm.objects(plants.self)
        }
    }
    
//    var allPlants = [plants]()
//    var currentPlant = [plants]()
//    var myPlants = [plants]()

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Register cell classes
        //self.collectionView!.register(UICollectionViewCell.self, forCellWithReuseIdentifier: reuseIdentifier)

        // Do any additional setup after loading the view.
        
        do{
            realm = try Realm()
        }catch let error{
            print(error.localizedDescription)
        }
        
        //print(Realm.Configuration.defaultConfiguration.fileURL)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using [segue destinationViewController].
        // Pass the selected object to the new view controller.
    }
    */

    // MARK: UICollectionViewDataSource

    override func numberOfSections(in collectionView: UICollectionView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }


    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of items
        return plantsList.count
    }

    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath) as! CollectionViewCell

        // Configure the cell
        let item = plantsList[indexPath.row]
        switch item.type {
        case "bulb":
            cell.imageView.image = UIImage(named: "bulb")
            plantName.append(item.name)
            plantTypes.append(item.type)
            plantInfo.append(bulbInfo)
            break
        case "jelly":
            cell.imageView.image = UIImage(named: "jelly")
            plantName.append(item.name)
            plantTypes.append(item.type)
            plantInfo.append(jellyInfo)
            break
        case "aloe":
            cell.imageView.image = UIImage(named: "aloe")
            plantName.append(item.name)
            plantTypes.append(item.type)
            plantInfo.append(aloeInfo)
            break
        case "rose":
            cell.imageView.image = UIImage(named: "rose")
            plantName.append(item.name)
            plantTypes.append(item.type)
            plantInfo.append(roseInfo)
        default:
            print("error")
        }
        print("[plant types: \(plantTypes)")
//        print("[plant info: \(plantInfo)")
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "showDetail"{
            let indexPath = collectionView?.indexPath(for: sender as! CollectionViewCell)
            let detailVC = segue.destination as! DetailViewController
            //print(plantTypes[(indexPath?.row)!])
            detailVC.imageType = plantTypes[(indexPath?.row)!]
            detailVC.infoLabel = plantInfo[(indexPath?.row)!]
            detailVC.titleLabel = plantName[(indexPath?.row)!]
        }
    }

    @IBAction func unwindSegue(_ segue: UIStoryboardSegue){
        if segue.identifier == "doneSegue"{
            let source = segue.source as! AddPlantViewController
            let curPlant = plants()
            curPlant.name = (source.newPlant.name)
            curPlant.type = (source.newPlant.type)
            //print("all plants: \(allPlants)")
            do{
                try self.realm.write {
                    self.realm.add(curPlant)
                    self.collectionView?.insertItems(at: [IndexPath.init(row: self.plantsList.count-1, section:0)])
                    //myPlants.append(source.newPlant)
                    print("REALM DATA ADDED")
                    //print(Realm.Configuration.defaultConfiguration.fileURL!)
                }
            }catch let error{
                print(error.localizedDescription)
            }
            collectionView?.reloadData()
            print("Success 3")
        }
    }
    
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return sectionInsets
    }
    
    // MARK: UICollectionViewDelegate

    /*
    // Uncomment this method to specify if the specified item should be highlighted during tracking
    override func collectionView(_ collectionView: UICollectionView, shouldHighlightItemAt indexPath: IndexPath) -> Bool {
        return true
    }
    */

    /*
    // Uncomment this method to specify if the specified item should be selected
    override func collectionView(_ collectionView: UICollectionView, shouldSelectItemAt indexPath: IndexPath) -> Bool {
        return true
    }
    */

    /*
    // Uncomment these methods to specify if an action menu should be displayed for the specified item, and react to actions performed on the item
    override func collectionView(_ collectionView: UICollectionView, shouldShowMenuForItemAt indexPath: IndexPath) -> Bool {
        return false
    }

    override func collectionView(_ collectionView: UICollectionView, canPerformAction action: Selector, forItemAt indexPath: IndexPath, withSender sender: Any?) -> Bool {
        return false
    }

    override func collectionView(_ collectionView: UICollectionView, performAction action: Selector, forItemAt indexPath: IndexPath, withSender sender: Any?) {
    
    }
    */

}
