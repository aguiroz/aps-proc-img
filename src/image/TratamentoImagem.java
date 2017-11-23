package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dao.ImageDAO;

public class TratamentoImagem {

	EscalaCinza escalaCinza;
	Amostragem amostragem;
	Filtro filtro;

	public TratamentoImagem() {

		escalaCinza = new EscalaCinza();
		amostragem = new Amostragem();
		filtro = new Filtro();

	}

	/**
	 * 
	 *metodo responsável por fazer gerenciar outras classes,
	 *a sequencia é transformar a imagem em cinza, recuperar
	 *a media do histograma da imagem, depois fazer a filtragem,
	 *eliminando ruidos indesejados e transformando em uma imagem
	 *binaria.
	 * 
	 */
	public BufferedImage tratatImagem(BufferedImage img) {

		BufferedImage imgCinza;
		BufferedImage imgFiltrada;
		imgCinza = escalaCinza.toGray(img);
		int media = amostragem.getMediaHistograma(imgCinza);
		imgFiltrada = filtro.filter(imgCinza, media);

		return imgFiltrada;
	}

	
	/**
	 * 
	 *metodo responsável por fazer a comaparação entre 2
	 *imagens, o valor de cada pixel é subtraido da valor
	 *do pixel da oura imagem, caso o resultado seja
	 *diferente de 0, a comparação é interrompida e um
	 *valor falso é retornado.
	 *
	 */
	public boolean comparaImagem(BufferedImage img1, BufferedImage img2) {

		if (img1.getWidth() != img2.getWidth()) {
			return false;
		}

		if (img1.getHeight() != img2.getHeight()) {
			return false;
		}

		for (int i = 0; i < img1.getWidth(); i++) {
			for (int j = 0; j < img1.getHeight(); j++) {

				Color color1 = new Color(img1.getRGB(i, j));
				Color color2 = new Color(img2.getRGB(i, j));

				int red1 = color1.getRed();
				int green1 = color1.getGreen();
				int blue1 = color1.getBlue();

				int res1 = red1 + green1 + blue1;

				int red2 = color2.getRed();
				int green2 = color2.getGreen();
				int blue2 = color2.getBlue();

				int res2 = red2 + green2 + blue2;

				if (res2 - res1 != 0) {
					return false;
				}

			}

		}

		return true;
	}

	
	
}
