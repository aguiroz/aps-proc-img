package model;

import java.awt.image.BufferedImage;

public class UsuarioModel {

	private String login;
	private String nome;
	private int nivelAcesso;
	private BufferedImage biometria;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	public BufferedImage getBiometria() {
		return biometria;
	}
	public void setBiometria(BufferedImage biometria) {
		this.biometria = biometria;
	}
	
	
	
}
