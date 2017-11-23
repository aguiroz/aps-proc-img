package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Filtro {

	
	/**
	 * 
	 *metodo responsável por transformar a imagem em 
	 *escala de cinza em uma imagem binária. 
	 * 
	 */
	public BufferedImage filter(BufferedImage img, int tonalidadeImg) {
		
		Color color;
		BufferedImage grayImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for(int i = 0; i < img.getWidth(); i++) {
			
			for(int j = 0; j < img.getHeight(); j++) {
				
				color = new Color(img.getRGB(i, j));
				
				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
				int a = color.getAlpha();
				
				int tonalidade = (r + g + b) / 3;
				
				if(tonalidade < tonalidadeImg) {
					tonalidade = 0;
				} else {
					tonalidade = 255;
				}
				
				Color color2 = new Color(tonalidade, tonalidade, tonalidade, a);
			
				grayImg.setRGB(i, j, color2.getRGB());
				
			}
		}
		
		return grayImg;
	}

	
}
