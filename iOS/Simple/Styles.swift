//
//  Styles.swift
//  Simple
//
//  Created by Luis Gustavo Oliveira Silva on 20/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle
import BeagleSchema

struct AppTheme {
    
    static let theme = Beagle.AppTheme(styles: [
        "styleTextBoldSystem30": styleTextBoldSystem30,
        "styleButtonWhiteSystemSemibold": styleButtonWhiteSystemSemibold
    ])
    
   
    
    static func styleTextBoldSystem30() -> (UITextView?) -> Void {
        return {
            $0?.font = .boldSystemFont(ofSize: 20)
        }
    }
    
    static func styleButtonWhiteSystemSemibold() -> (UIButton?) -> Void {
        return BeagleStyle.button(withTitleColor: .white)
            <> {
                $0?.titleLabel |> BeagleStyle.label(withFont: .systemFont(ofSize: 16, weight: .semibold))
        }
    }
    
}
