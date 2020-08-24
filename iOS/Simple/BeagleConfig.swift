//
//  BeagleConfig.swift
//  Simple
//
//  Created by Luis Gustavo Oliveira Silva on 20/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle
import BeagleSchema

struct BeagleConfig {

    static let dependencies = BeagleDependencies()
    static func config() {
        let baseUrl: URL? = URL(string: "https://simple-hacka.herokuapp.com/")
        dependencies.urlBuilder = UrlBuilder(baseUrl: baseUrl)
        dependencies.theme = AppTheme.theme
        deeplinkManager()
        Beagle.dependencies = dependencies
    }
    
    static func deeplinkManager() {
        let deepLinkHandler = DeeplinkScreenManager.shared
        deepLinkHandler["home"] = HomeTabBarController.self
        dependencies.deepLinkHandler = deepLinkHandler
    }
}
