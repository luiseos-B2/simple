//
//  AppDelegate.swift
//  Simple
//
//  Created by Gabriela Coelho on 19/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow()
        
        let rootViewController = MainScreen().screenController()
        window?.rootViewController = rootViewController
        
        window?.makeKeyAndVisible()
        return true
      }
}
