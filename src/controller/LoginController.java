package controller;

import java.awt.image.BufferedImage;
import dao.ImageDAO;
import dao.UsuarioDAO;
import image.TratamentoImagem;
import model.UsuarioModel;

public class LoginController {

	UsuarioModel usuario;
	UsuarioDAO usuarioDAO;
	ImageDAO imageDAO;
	TratamentoImagem tratamentoImagem;

	public LoginController() {
		usuarioDAO = new UsuarioDAO();
		imageDAO = new ImageDAO();
		tratamentoImagem = new TratamentoImagem();
	}

	public boolean autenticar(String login, String pathBiometria) throws Exception {

		boolean autenticacao = false;
		BufferedImage biometria;

		try {

			usuario = usuarioDAO.consultar(login);
			
			biometria = imageDAO.loadBiometria(pathBiometria);
			
			tratamentoImagem.tratatImagem(biometria);
			
			autenticacao = tratamentoImagem.comparaImagem(biometria, usuario.getBiometria());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return autenticacao;

	}

}
