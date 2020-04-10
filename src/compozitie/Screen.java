package compozitie;

import java.util.ArrayList;

public class Screen {
	private ArrayList<Pixel> pixels;
	private Dimensions dimensions;
	
	public Screen(int noPixels,int width,int length,int depth) {
		this.pixels = new ArrayList<Pixel>(noPixels);
		this.dimensions = new Dimensions(width,length,depth);
	}
	
	public void setPixel(int pixel,String color) {
		pixels.get(pixel).setPixel(color);
	}
	
	public void colorScreen(String color) {
		for(int i = 0;i<pixels.size();i++) {
			pixels.get(i).setPixel(color);
		}
	}
}
