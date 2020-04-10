package compozitie;

public class Microphone {
	private int maxVolume;
	private int crtVolume;
	
	public Microphone(int maxVolume) {
		this.maxVolume = maxVolume;
		crtVolume = maxVolume/4;
	}
	
	public Microphone(int maxVolume,int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}
	
	public boolean increaseVolume() {
		if(this.crtVolume + 1 <= maxVolume) {
			this.crtVolume++;
			return true;
		}
		return false;
	}
	public boolean decreaseVolume() {
		if(this.crtVolume - 1 > 0 ) {
			this.crtVolume--;
			return true;
		}
		return false;
	}
	public void muteMicrophone() {
		this.crtVolume = 0;
	}
}
