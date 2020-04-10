package compozitie;

public class Speaker {
	private int maxVolume;
	private int crtVolume;
	
	public Speaker(int maxVolume) {
		this.maxVolume = maxVolume;
		crtVolume = maxVolume/4;
	}
	
	public Speaker(int maxVolume,int crtVolume) {
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
	public void setSilenceMode() {
		this.crtVolume = 0;
	}
}
