//
//  SearchBarController.swift
//  Simple
//
//  Created by Gabriela Coelho on 23/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import Beagle
import UIKit

class SearchBarController: UIViewController {
    
    let searchBar = UISearchBar(frame: CGRect(x: 0, y: 20, width: UIScreen.main.bounds.width, height: 60))
    var beagleScreenViewController = BeagleScreenViewController(.remote(.init(url: "/search/opportunity")))

    lazy var containerView: UIView = {
        let view = UIView()
        return view
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupConstraintsSearchBar()
    }
    
    func setupConstraintsSearchBar() {
        searchBar.delegate = self
        searchBar.placeholder = "Buscar"
        view.addSubview(searchBar)
        searchBar.anchor(top: view.safeAreaLayoutGuide.topAnchor, left: view.leftAnchor, right: view.rightAnchor)
    }
    
    private func setup() {
        NSObject.cancelPreviousPerformRequests(withTarget: self, selector: #selector(setupBeagleScreenViewController), object: nil)
        perform(#selector(setupBeagleScreenViewController), with: nil, afterDelay: 0.4)
    }
    
    @objc private func setupBeagleScreenViewController() {
        view.addSubview(containerView)
        containerView.addSubview(beagleScreenViewController.view)
        containerView.anchor(top: searchBar.bottomAnchor, left: view.leftAnchor, bottom: view.bottomAnchor, right: view.rightAnchor)
        beagleScreenViewController.view.anchorTo(superview: containerView)
    }
}

extension SearchBarController: UISearchBarDelegate {
    func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
        if searchText.count == 0 {
            containerView.removeFromSuperview()
        } else {
            verifyText(searchText)
            setup()
        }
    }
    
    private func verifyText(_ text: String) {
        if text == "Oportunidades" {
            beagleScreenViewController = BeagleScreenViewController(.remote(.init(url: KeyWords.opportunity)))
        } else if text == "Produtos" {
            beagleScreenViewController = BeagleScreenViewController(.remote(.init(url: KeyWords.product)))
        } else if text == "Serviço" {
            beagleScreenViewController = BeagleScreenViewController(.remote(.init(url: KeyWords.service)))
        } else if text == "Lojas" {
            beagleScreenViewController = BeagleScreenViewController(.remote(.init(url: KeyWords.store)))
        }
    }
}

struct KeyWords {
    static let opportunity = "/search/opportunity"
    static let store = "/search/store"
    static let service = "/search/service"
    static let product = "/search/product"
}
