package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDAO {

	/**
	 *
	 * metodo respons�vel por carregar o arquivo da imagem
	 * para a mem�ria, recebendo por parametro o caminho da
	 * imagem
	 */
	public BufferedImage loadBiometria(String path) {
		
		File file = new File(path);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
}
