//
//  ViewController.swift
//  Simple
//
//  Created by Gabriela Coelho on 19/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit
import Beagle
import BeagleSchema

struct MainScreen {

    func screenController() -> UIViewController {
        let urlRelativa = "/onboarding"
        return BeagleScreenViewController(.remote(.init(url: urlRelativa)))
    }
}


class Main: UIViewController {
    private lazy var previewButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("Preview", for: .normal)
        button.backgroundColor = .blue
        return button
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        view.addSubview(previewButton)
        previewButton.anchorTo(superview: view)
        setupActions()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
//        BeaglePreview.present(in: self)
    }
    
    private func setupActions() {
        previewButton.addTarget(self, action: #selector(handlePreviewButtonTap), for: .touchUpInside)
    }
    
    @objc
    private func handlePreviewButtonTap() {
        BeaglePreview.present(in: self)
    }
}
