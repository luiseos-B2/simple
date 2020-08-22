//
//  HomeTabBarController.swift
//  Simple
//
//  Created by Gabriela Coelho on 21/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle

class HomeTabBarController: UITabBarController, DeeplinkScreen {
    required init() {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func screenController() -> UIViewController {
        return self
    }
    
    // MARK: Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        setup()
    }
    
    func setup() {
        let vcs = HomeTabBarController.makeTabControllers()
        viewControllers = vcs
        selectedViewController = vcs.first
        
        setupTabLayout()
    }
    
    private func setupTabLayout() {
        tabBar.isTranslucent = false
        tabBar.tintColor = AppTheme.darkBlue
        tabBar.unselectedItemTintColor = AppTheme.blue
        selectedIndex = .zero
    }
}


extension HomeTabBarController {
    static func makeTabControllers() -> [UIViewController] {
        var controllers: [UIViewController] = []
        controllers = [
             makeHomeViewController(),
             makeSearchViewController(),
             makePostViewController(),
             makeProfileViewController(),
             makeMenuViewController()
        ]
        return controllers
    }
    
    static func makeHomeViewController() -> UIViewController {
        let controller = Beagle.screen(.remote(.init(url: "/home")))
        controller.tabBarItem = UITabBarItem(
            title: "Home",
            image: UIImage(named: "home2"),
            selectedImage: nil
        )
        return controller
    }
        
    static func makeSearchViewController() -> UIViewController {
        let controller = UIViewController()
        controller.tabBarItem = UITabBarItem(
            title: "Search",
            image: UIImage(named: "search"),
            selectedImage: nil
        )
        return controller
    }
    
    static func makeMenuViewController() -> UIViewController {
        let controller = BeagleScreenViewController(.remote(.init(url: "/menu")))
        controller.tabBarItem = UITabBarItem(
            title: "Menu",
            image: UIImage(named: "menu"),
            selectedImage: nil
        )
        return controller
    }
    
    static func makeProfileViewController() -> UIViewController {
        let controller = BeagleScreenViewController(.remote(.init(url: "/profile")))
        controller.tabBarItem = UITabBarItem(
            title: "Profile",
            image: UIImage(named: "user"),
            selectedImage: nil
        )
        return controller
    }
    
    static func makePostViewController() -> UIViewController {
        let controller = BeagleScreenViewController(.remote(.init(url: "/post")))
        controller.tabBarItem = UITabBarItem(
            title: "Post",
            image: UIImage(named: "plus"),
            selectedImage: nil
        )
        return controller
    }
}
