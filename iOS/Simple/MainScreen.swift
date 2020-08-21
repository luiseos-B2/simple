//
//  ViewController.swift
//  Simple
//
//  Created by Gabriela Coelho on 19/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle
import BeagleSchema

struct MainScreen {

    func screenController() -> UIViewController {
        let urlRelativa = "/onboarding"
        return BeagleScreenViewController(.remote(.init(url: urlRelativa)))
    }
}

