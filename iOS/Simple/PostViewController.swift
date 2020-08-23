//
//  PostViewController.swift
//  Simple
//
//  Created by Luis Gustavo Oliveira Silva on 22/08/20.
//  Copyright © 2020 simple. All rights reserved.
//

import UIKit

class PostViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = #colorLiteral(red: 0.9607843137, green: 0.9647058824, blue: 0.9725490196, alpha: 1)
        view.addSubview(imagem)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        setupView()
        self.setupImage()
        self.imagem.isHidden = true
        self.viewImage.isHidden = false
    }
    
    func setupImage() {
        EscolherImagem().selecionadorImagem(self){ imagem in
            self.imagem.image = imagem
            self.imagem.isHidden = false
            self.viewImage.isHidden = true
        }
     }
    
    private func createLabel(name: String, fonte: UIFont) -> UILabel {
        let label = UILabel()
        label.textColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        label.text = name
        label.font = fonte
        label.numberOfLines = 0
        return label
    }
    
    private func createTextField(placeholder: String) -> UITextField {
        let textField = UITextField(frame: .zero)
        textField.borderStyle = .roundedRect
        textField.font = .systemFont(ofSize: 20.0)
        textField.placeholder = placeholder
        let color = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        textField.layer.borderColor = color.cgColor
        textField.layer.borderWidth = 1
        textField.textColor = UIColor.lightGray
        textField.layer.cornerRadius = 8
        return textField
    }
    
    

    @objc func checkAction(sender : UITapGestureRecognizer) {
        self.setupImage()
    }
    
    @objc func actionButtonOportunidade () {
        buttonOportunidade.backgroundColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        buttonServico.backgroundColor = .lightGray
      }
    
    @objc func actionButtonServico () {
        buttonOportunidade.backgroundColor = .lightGray
        buttonServico.backgroundColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
    }
    
    @objc func actionCriarPost () {
   
    }
       
    private lazy var imagem: UIImageView = {
        let imagem = UIImageView()
        imagem.isHidden = true
        let gesto = UITapGestureRecognizer(target: self, action:  #selector(self.checkAction))
        imagem.addGestureRecognizer(gesto)
        imagem.isUserInteractionEnabled = true
        imagem.layer.borderColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        imagem.layer.borderWidth = 1
        imagem.layer.cornerRadius = 8
        return imagem
    }()
    
    private lazy var viewImage: UIView = {
        let viewImage = UIView()
        viewImage.backgroundColor = .white
        viewImage.layer.borderColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        viewImage.layer.borderWidth = 3
        viewImage.layer.cornerRadius = 8
        let gesto = UITapGestureRecognizer(target: self, action:  #selector(self.checkAction))
        viewImage.addGestureRecognizer(gesto)
        return viewImage
    }()
    
    private lazy var adicionarImage: UIImageView = {
        let imagem = UIImageView()
        imagem.image = UIImage(named: "AdicionarImagem")
        return imagem
    }()
    
    private lazy var titleLabel: UILabel = {
        return createLabel(name: "Criar Post", fonte: .boldSystemFont(ofSize: 30))
    }()
    
    private lazy var buttonOportunidade: UIButton = {
           let buttonOportunidade = UIButton(frame: .zero)
           buttonOportunidade.setTitle("Oportunidade", for: .normal)
           buttonOportunidade.backgroundColor = .lightGray
           buttonOportunidade.clipsToBounds = true
           buttonOportunidade.layer.cornerRadius = 10
           buttonOportunidade.addTarget(self, action: #selector(actionButtonOportunidade), for: .touchUpInside)
           return buttonOportunidade
       }()
    
    private lazy var buttonServico: UIButton = {
        let buttonServico = UIButton(frame: .zero)
        buttonServico.setTitle("Serviço", for: .normal)
        buttonServico.backgroundColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        buttonServico.clipsToBounds = true
        buttonServico.layer.cornerRadius = 10
        buttonServico.addTarget(self, action: #selector(actionButtonServico), for: .touchUpInside)
        return buttonServico
    }()
    
    private lazy var viewButtonType: UIView = {
           let viewButtonType = UIView()
           viewButtonType.backgroundColor = .clear
           return viewButtonType
       }()
    
    private lazy var textInputTitle: UITextField = {
        return createTextField(placeholder: "Título")
    }()
    
    private lazy var textViewDescription: UITextView = {
        let textView = UITextView()
        textView.font = .systemFont(ofSize: 20)
        textView.textColor = .lightGray
        textView.layer.borderWidth = 1
        textView.layer.borderColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        textView.layer.cornerRadius = 10
        textView.isUserInteractionEnabled = true
        return textView
    }()
    
    private lazy var textImputUrlWhats: UITextField = {
        return createTextField(placeholder: "URL do Whats App")
    }()
    
    private lazy var buttonCriarPost: UIButton = {
        let buttonCriarPost = UIButton(frame: .zero)
        buttonCriarPost.setTitle("Criar Post", for: .normal)
        buttonCriarPost.backgroundColor = #colorLiteral(red: 0.1333333333, green: 0.5058823529, blue: 0.6705882353, alpha: 1)
        buttonCriarPost.clipsToBounds = true
        buttonCriarPost.layer.cornerRadius = 10
        buttonCriarPost.addTarget(self, action: #selector(actionCriarPost), for: .touchUpInside)
        return buttonCriarPost
    }()
    
    func setupTextInput() {
        textInputTitle.translatesAutoresizingMaskIntoConstraints = false
        let topTextFieldSearch = textInputTitle.topAnchor.constraint(equalTo: viewButtonType.bottomAnchor, constant: 30)
        let leadingTextFieldSearch = textInputTitle.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20)
        let trailingTextFieldSearch = textInputTitle.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant:-20)
        NSLayoutConstraint.activate([topTextFieldSearch, leadingTextFieldSearch, trailingTextFieldSearch])
        
        textViewDescription.translatesAutoresizingMaskIntoConstraints = false
        let topTextImputDescricao = textViewDescription.topAnchor.constraint(equalTo: textInputTitle.bottomAnchor, constant: 15)
        let leadingTextImputDescricao = textViewDescription.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20)
        let trailingTextImputDescricao = textViewDescription.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant:-20)
        let heightTextImputDescricao = textViewDescription.heightAnchor.constraint(equalToConstant: view.frame.height / 10)

        NSLayoutConstraint.activate([topTextImputDescricao, leadingTextImputDescricao, trailingTextImputDescricao, heightTextImputDescricao])
        
        textImputUrlWhats.translatesAutoresizingMaskIntoConstraints = false
        let topTextImputUrlWhats = textImputUrlWhats.topAnchor.constraint(equalTo: textViewDescription.bottomAnchor, constant: 15)
        let leadingImputUrlWhats = textImputUrlWhats.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20)
        let trailingImputUrlWhats = textImputUrlWhats.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant:-20)
        NSLayoutConstraint.activate([topTextImputUrlWhats, leadingImputUrlWhats, trailingImputUrlWhats])
        
        buttonCriarPost.translatesAutoresizingMaskIntoConstraints = false
        let leadingCriarPost = buttonCriarPost.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20)
        let trailingCriarPost = buttonCriarPost.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant:-20)
        let bottomCriarPost = buttonCriarPost.bottomAnchor.constraint(equalTo: view.bottomAnchor, constant: -20)
        NSLayoutConstraint.activate([leadingCriarPost, trailingCriarPost, bottomCriarPost])
    }
    
    func buttonType() {
        viewButtonType.translatesAutoresizingMaskIntoConstraints = false
        let topViewButtonType = viewButtonType.topAnchor.constraint(equalTo: imagem.bottomAnchor , constant: 20)
        let centerViewButtonType = viewButtonType.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        NSLayoutConstraint.activate([topViewButtonType, centerViewButtonType])
        
        buttonServico.translatesAutoresizingMaskIntoConstraints = false
        let topButtonServico = buttonServico.topAnchor.constraint(equalTo: viewButtonType.topAnchor)
        let bottomButtonServico = buttonServico.bottomAnchor.constraint(equalTo: viewButtonType.bottomAnchor)
        let leadingButtonServico = buttonServico.leadingAnchor.constraint(equalTo: viewButtonType.leadingAnchor)
        let trailingButtonServico = buttonServico.trailingAnchor.constraint(equalTo: buttonOportunidade.leadingAnchor, constant: -20)
        let widthButtonServico = buttonServico.widthAnchor.constraint(equalToConstant: 130)
        NSLayoutConstraint.activate([topButtonServico, bottomButtonServico, leadingButtonServico, trailingButtonServico, widthButtonServico])
        
        buttonOportunidade.translatesAutoresizingMaskIntoConstraints = false
        let topButtonOportunidade = buttonOportunidade.topAnchor.constraint(equalTo: viewButtonType.topAnchor)
        let bottomButtonOportunidade = buttonOportunidade.bottomAnchor.constraint(equalTo: viewButtonType.bottomAnchor)
        let leadingButtonOportunidade = buttonOportunidade.leadingAnchor.constraint(equalTo: buttonServico.trailingAnchor , constant: 20)
        let trailingButtonOportunidade = buttonOportunidade.trailingAnchor.constraint(equalTo: viewButtonType.trailingAnchor)
        let widthButtonOportunidade = buttonOportunidade.widthAnchor.constraint(equalToConstant: 130)
        NSLayoutConstraint.activate([topButtonOportunidade, bottomButtonOportunidade, leadingButtonOportunidade, trailingButtonOportunidade, widthButtonOportunidade])
    }
    
    func constraints() {
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        let topTitleLabel = titleLabel.topAnchor.constraint(equalTo: view.topAnchor , constant: 40)
        let centerTitleLabel = titleLabel.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        NSLayoutConstraint.activate([topTitleLabel, centerTitleLabel])
        
        viewImage.translatesAutoresizingMaskIntoConstraints = false
        let topViewImage = viewImage.topAnchor.constraint(equalTo: titleLabel.bottomAnchor , constant: 20)
        let centerViewImage = viewImage.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        let widthViewImage = viewImage.widthAnchor.constraint(equalToConstant: view.frame.width / 2)
        let heighthViewImage = viewImage.heightAnchor.constraint(equalToConstant: view.frame.height / 5)
        NSLayoutConstraint.activate([topViewImage, centerViewImage, widthViewImage,heighthViewImage])
        
        adicionarImage.translatesAutoresizingMaskIntoConstraints = false
        let centerYAdicionarImage = adicionarImage.centerYAnchor.constraint(equalTo: viewImage.centerYAnchor)
        let centerXAdicionarImage = adicionarImage.centerXAnchor.constraint(equalTo: viewImage.centerXAnchor)
        let widthAdicionarImage = adicionarImage.widthAnchor.constraint(equalToConstant: 70)
        let heighthAdicionarImage = adicionarImage.heightAnchor.constraint(equalToConstant: 70)
        NSLayoutConstraint.activate([centerYAdicionarImage, centerXAdicionarImage, widthAdicionarImage, heighthAdicionarImage])
        
        imagem.translatesAutoresizingMaskIntoConstraints = false
        let topImagem = imagem.topAnchor.constraint(equalTo: titleLabel.bottomAnchor , constant: 20)
        let centerImagem = imagem.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        let widthImagem = imagem.widthAnchor.constraint(equalToConstant: view.frame.width / 2)
        let heighthImagem = imagem.heightAnchor.constraint(equalToConstant: view.frame.height / 5)
        NSLayoutConstraint.activate([topImagem, centerImagem, widthImagem,heighthImagem])
    }
    
}
// Components
extension PostViewController: ViewLayoutHelper {
    func buildViewHierarchy() {
        view.addSubview(titleLabel)
        view.addSubview(viewImage)
        viewImage.addSubview(adicionarImage)
        view.addSubview(viewButtonType)
        viewButtonType.addSubview(buttonServico)
        viewButtonType.addSubview(buttonOportunidade)
        view.addSubview(textInputTitle)
        view.addSubview(textViewDescription)
        view.addSubview(textImputUrlWhats)
        view.addSubview(buttonCriarPost)
    }
    
    func setupContraints() {
        constraints()
        buttonType()
        setupTextInput()
    }
    
    func setupAdditionalConfiguration() {
        
    }
    
    
   
    
}
