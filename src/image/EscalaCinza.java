package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class EscalaCinza {

	
	/**
	 * 
	 *metodo responsável pela transformação da imagem em escala de cinza.
	 * 
	 */
	public BufferedImage toGray(BufferedImage img) {

		BufferedImage imgTratada = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Color color;

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {

				color = new Color(img.getRGB(i, j));

				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();

				int a = color.getAlpha();

				int gray = (r + g + b) / 3;

				Color grayScale = new Color(gray, gray, gray, a);

				imgTratada.setRGB(i, j, grayScale.getRGB());

			}
		}
		
		return imgTratada;

	}

}
