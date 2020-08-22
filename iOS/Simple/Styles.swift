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
        "styleTextBoldSystem30": styleTextBoldSystem30,
        "styleButtonWhiteSystemSemibold": styleButtonWhiteSystemSemibold,
        "Style.TextInput": designSystemTextInput,
        "Style.button": designSystemStylishButton,
        "Style.Text.Blue": designSystemBlueText,
        "Style.PasswordButton": designSystemPasswordButton,
        "Style.H1.Text": styleTextH1
    ])

    static func styleTextBoldSystem30() -> (UITextView?) -> Void {
        return {
            $0?.font = .boldSystemFont(ofSize: 20)
        }
    }
    
    static func designSystemBlueText() -> (UITextView?) -> Void {
          return {
            $0?.font = .systemFont(ofSize: 15)
            $0?.textColor = darkBlue
          }
      }
    
    static func styleTextH1() -> (UITextView?) -> Void {
        return {
            $0?.font = .boldSystemFont(ofSize: 30)
            $0?.textColor = darkBlue
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
        return {
            $0?.setTitleColor(blue, for: .normal)
        }
    }
    
}
