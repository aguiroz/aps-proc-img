package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TratamentoImagem {

	EscalaCinza escalaCinza;
	Amostragem amostragem;
	Filtro filtro;

	public TratamentoImagem() {

		escalaCinza = new EscalaCinza();
		amostragem = new Amostragem();
		filtro = new Filtro();

	}

	public void tratatImagem(BufferedImage img) {

		escalaCinza.toGray(img);
		int media = amostragem.getMediaHistograma(img);
		filtro.filter(img, media);

	}

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
