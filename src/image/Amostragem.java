package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Amostragem {

	/**
	 * 
	 *metodo responsavel por gerar o histograma da imagem
	 *através do canal vermelho 
	 * 
	 */
	private int[] getHistograma(BufferedImage img) {

		int[] histograma = new int[256];
		Color color;

		for (int i = 0; i < img.getWidth(); i++) {

			for (int j = 0; j < img.getHeight(); j++) {

				color = new Color(img.getRGB(i, j));
				int red = color.getRed();

				histograma[red] += 1;

			}

		}

		return histograma;
	}

	
	/**
	 * 
	 *metodo responsável por calcular a média do histograma 
	 * 
	 */
	public int getMediaHistograma(BufferedImage img) {

		int[] histograma = getHistograma(img);
		int media = 0;

		for (int i = 0; i < histograma.length; i++) {

			media += histograma[i] * i;

		}

		media = (media / (img.getWidth() * img.getHeight()));

		return media;
	}

}
