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
        let baseUrl: URL? = URL(string: "http://localhost:8080")
        dependencies.urlBuilder = UrlBuilder(baseUrl: baseUrl)
        dependencies.theme = AppTheme.theme
        Beagle.dependencies = dependencies
    }
}
