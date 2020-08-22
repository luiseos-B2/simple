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
    static var blue = #colorLiteral(red: 0.2588235294, green: 0.6823529412, blue: 0.8549019608, alpha: 1)
    static var darkBlue = #colorLiteral(red: 0.1607843137, green: 0.5098039216, blue: 0.662745098, alpha: 1)
    static let theme = Beagle.AppTheme(styles: [
        "Style.Text.Bold.System.20": styleTextBoldSystem20,
        "Style.Button.White.System.Bold.16": styleButtonWhiteSystemSemibold,
        "Style.TextInput": designSystemTextInput,
        "Style.button": designSystemStylishButton,
        "Style.Text.System.Light": designSystemText,
        "Style.PasswordButton": designSystemPasswordButton,
        "Style.H1.Text": styleTextH1,
        "Style.NavigationBar": styleNavigationBar
    ])
    
    static func styleTextBoldSystem20() -> (UITextView?) -> Void {
        return {
            $0?.font = .boldSystemFont(ofSize: 20)
        }
    }
    
    static func designSystemText() -> (UITextView?) -> Void {
          return {
            $0?.font = .systemFont(ofSize: 15)
          }
      }
    
    static func styleTextH1() -> (UITextView?) -> Void {
        return {
            $0?.font = .boldSystemFont(ofSize: 30)
        }
    }
    
    static func styleButtonWhiteSystemSemibold() -> (UIButton?) -> Void {
        return BeagleStyle.button(withTitleColor: .white)
            <> {
                $0?.titleLabel |> BeagleStyle.label(withFont: .systemFont(ofSize: 16, weight: .bold))
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
        return {
            $0?.setTitleColor(blue, for: .normal)
        }
    }
    
    static func styleNavigationBar() -> (UINavigationBar?) -> Void {
        return {
            let color = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
            $0?.tintColor = color
            $0?.barTintColor = .white
            $0?.isTranslucent = false
            let navigationFont = UIFont.systemFont(ofSize: 20, weight: .bold)
            $0?.titleTextAttributes = [
                .foregroundColor: color ,
                NSAttributedString.Key.font: navigationFont
            ]
        }
    }
    
}
