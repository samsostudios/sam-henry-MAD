//
//  DetailViewController.swift
//  Sam Henry Midterm
//
//  Created by Sam Henry on 3/15/18.
//  Copyright © 2018 Sam Henry. All rights reserved.
//

import UIKit
import WebKit

class DetailViewController: UIViewController, WKNavigationDelegate {
    
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var webSpinner: UIActivityIndicatorView!
    var detailItem: String?
    
    func configureView(){
        if let url = detailItem{
            if url != "null"{
                loadWebpage(url)
            }
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        webView.navigationDelegate = self
        configureView()

        // Do any additional setup after loading the view.
    }
    
    func loadWebpage(_ urlString: String){
        print("URLSTRING", urlString)
        let url = URL(string: urlString)
        let request = URLRequest(url: url!)
        webView.load(request)
    }
    
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        webSpinner.startAnimating()
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        webSpinner.stopAnimating()
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
