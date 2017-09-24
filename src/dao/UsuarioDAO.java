package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.UsuarioModel;

public class UsuarioDAO {
	public void insert(UsuarioModel usuario) throws Exception {

		File file = new File("res/user/user_" + usuario.getLogin() + ".txt");

		if (!file.exists()) {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			String line = usuario.getLogin() + ";" + usuario.getNome() + ";" + usuario.getNivelAcesso();

			writer.append(line);
			saveBiometria(usuario.getLogin(), usuario.getBiometria());

			writer.close();
			fileWriter.close();
		} else {
			throw new Exception("Usuario ja exite");
		}
	}

	public void update(UsuarioModel usuario) throws Exception {

		File file = new File("res/user/user_" + usuario.getLogin() + ".txt");

		if (!file.exists()) {
			throw new Exception("Erro ao alterar Usuario!");
		}

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWriter);

		String line = usuario.getLogin() + ";" + usuario.getNome() + ";" + usuario.getNivelAcesso();

		writer.write(line);
		saveBiometria(usuario.getLogin(), usuario.getBiometria());

		writer.close();
		fileWriter.close();

	}

	public void delete(UsuarioModel usuario) throws Exception {

		File file = new File("res/user/user_" + usuario.getLogin() + ".txt");
		if (!file.delete() & deleteBiometria(usuario.getLogin())) {
			throw new Exception("Erro ao deletar usuario!");
		}

	}

	public UsuarioModel consultar(String login) throws Exception {

		File file = new File("res/user/user_" + login + ".txt");

		if (!file.exists()) {
			throw new Exception("Erro ao consultar usuario!");
		}

		UsuarioModel usuario = new UsuarioModel();

		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		String linha[] = reader.readLine().split(";");

		usuario.setLogin(linha[0]);
		usuario.setNome(linha[1]);
		usuario.setNivelAcesso(Integer.parseInt(linha[2]));
		usuario.setBiometria(loadBiometria(usuario.getLogin()));

		reader.close();
		fileReader.close();

		return usuario;
	}

	public List<UsuarioModel> listarUsuarios() throws Exception {

		File diretorio = new File("res/user");
		File users[] = diretorio.listFiles();
		List<UsuarioModel> listaUsuarios = new ArrayList<>();
		UsuarioModel usuario;

		for (File file : users) {

			if (!file.exists()) {
				throw new Exception("Erro ao consultar usuario!");
			}

			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);

			String linha[] = reader.readLine().split(";");

			usuario = new UsuarioModel();
			usuario.setLogin(linha[0]);
			usuario.setNome(linha[1]);
			usuario.setNivelAcesso(Integer.parseInt(linha[2]));
			usuario.setBiometria(loadBiometria(usuario.getLogin()));
			listaUsuarios.add(usuario);

			reader.close();
			fileReader.close();

		}
		
		return listaUsuarios;
	}

	private BufferedImage loadBiometria(String login) {

		File file = new File("res/img/" + login + ".png");
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return img;
	}

	public void saveBiometria(String login, BufferedImage img) {

		File file = new File("res/img/" + login + ".png");

		try {
			ImageIO.write(img, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean deleteBiometria(String login) {
		File file = new File("res/img/" + login + ".png");

		if (!file.delete())
			return false;

		return true;

	}
}
