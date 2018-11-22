//
//  ViewController.swift
//  iosApp
//
//  Created by Jorge Sánchez on 16/11/18.
//  Copyright © 2018 xurxodev. All rights reserved.
//

import UIKit
import multiplatformLibrary

class ViewController: UIViewController {

    @IBOutlet weak var helloLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let d2Api = D2Api.Builder()
            .url(url: "some username")
            .credentials(username: "some username", password: "some password")
            .build();
        
        helloLabel.text = d2Api.getHtmlContent()
        
        //helloLabel.text = Hello().multiplatformHello()
    }

    
}

