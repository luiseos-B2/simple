//
//  ProtocolViewCode.swift
//  Simple
//
//  Created by Luis Gustavo Oliveira Silva on 23/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import Foundation
protocol ViewLayoutHelper {
    func buildViewHierarchy()
    func setupContraints()
    func setupAdditionalConfiguration()
    func setupView()
}

extension ViewLayoutHelper {
    func setupView() {
        buildViewHierarchy()
        setupContraints()
        setupAdditionalConfiguration()
    }
}
