//
//  DeeplinkScreenManager.swift
//  Simple
//
//  Created by Gabriela Coelho on 22/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle

protocol DeeplinkScreen {
    init()
    func screenController() -> UIViewController
}

final class DeeplinkScreenManager: DeepLinkScreenManaging {
    
    public static let shared = DeeplinkScreenManager()
    
    private var screens: [String: DeeplinkScreen.Type] = [:]
    
    public subscript(path: String) -> DeeplinkScreen.Type? {
        get {
            return screens[path]
        }
        set {
            screens[path] = newValue
        }
    }
    
    func getNativeScreen(with path: String, data: [String: String]?) throws -> UIViewController {
        guard let screenType = self[path] else {
            throw NSError(domain: "DeeplinkScreenManager", code: 1, userInfo: nil)
        }
        return screenType.init().screenController()
    }
}
