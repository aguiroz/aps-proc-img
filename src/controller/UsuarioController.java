package controller;

import java.awt.image.BufferedImage;
import java.util.List;

import dao.ImageDAO;
import dao.UsuarioDAO;
import model.UsuarioModel;
import image.TratamentoImagem;

public class UsuarioController {

	UsuarioDAO usuarioDAO;
	ImageDAO imageDAO;
	TratamentoImagem tratamentoImagem;

	public UsuarioController() {
		usuarioDAO = new UsuarioDAO();
		imageDAO = new ImageDAO();
		tratamentoImagem = new TratamentoImagem();
	}

	public boolean incluir(UsuarioModel usuario, String biometria) {

		try {
			usuario.setBiometria(loadBiometria(biometria));
			usuarioDAO.insert(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean alterar(UsuarioModel usuario, String biometria) {

		try {
			usuario.setBiometria(loadBiometria(biometria));
			usuarioDAO.update(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean excluir(UsuarioModel usuario) {

		try {
			usuarioDAO.delete(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public UsuarioModel consultar(String login) {
		UsuarioModel usuario;

		try {
			usuario = usuarioDAO.consultar(login);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}

	public List<UsuarioModel> listarUsuarios() {
		List<UsuarioModel> listaUsuario;

		try {
			listaUsuario = usuarioDAO.listarUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return listaUsuario;
	}

	private BufferedImage loadBiometria(String path) {
		
		BufferedImage biometria = imageDAO.loadBiometria(path);
		if(biometria == null) {
			System.out.println("nulo");
		}
		BufferedImage biometriaTrat = tratamentoImagem.tratatImagem(biometria);

		return biometriaTrat;
	}

}
