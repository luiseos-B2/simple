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
    static var blue = UIColor(red: 66, green: 174, blue: 218, alpha: 0)

    static let theme = Beagle.AppTheme(styles: [
        "styleTextBoldSystem30": styleTextBoldSystem30,
        "styleButtonWhiteSystemSemibold": styleButtonWhiteSystemSemibold,
        "Style.TextInput": designSystemTextInput,
        "Style.button": designSystemStylishButton,
        "Style.PasswordButton": designSystemPasswordButton
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
    
    static func designSystemTextInput() -> (UITextField?) -> Void {
        return {
            $0?.borderStyle = .roundedRect
            $0?.font = .systemFont(ofSize: 20.0)
        }
    }
    
    static func designSystemStylishButton() -> (UIButton?) -> Void {
        return BeagleStyle.button(withTitleColor: .black)
            <> {
                $0?.setTitleColor(.white, for: .normal)
                $0?.titleLabel |> BeagleStyle.label(withFont: .systemFont(ofSize: 16, weight: .semibold))
        }
    }
    
    static func designSystemPasswordButton() -> (UIButton?) -> Void {
        return BeagleStyle.button(withTitleColor: blue)
        <> {
                $0?.setTitleColor(blue, for: .normal)
                $0?.titleLabel |> BeagleStyle.label(withFont: .systemFont(ofSize: 16))
        }
    }
    
}
