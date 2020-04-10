package compozitie;
public class Smartphone {
	// Composition:
	private Screen theScreen;
	private Case theCase;
	private Speaker theSpeaker;
	private Microphone theMicrophone;



	public Smartphone(Screen theScreen, Case theCase, 
			Speaker theSpeaker, Microphone theMicrophone) {
		this.theScreen = theScreen;
		this.theCase = theCase;
		this.theSpeaker = theSpeaker;
		this.theMicrophone = theMicrophone;
	}

	public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol,int microMaxVol) {
		this.theScreen = new Screen(pixelsNo, width, length, depth);
		this.theCase = new Case();
		this.theSpeaker = new Speaker(speakerMaxVol);
		this.theMicrophone = new Microphone(microMaxVol);
	}


	public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol, 
			int speakerCrtVol, int microMaxVol, int microCrtVol) {
		this.theScreen = new Screen(pixelsNo, width, length, depth);
		this.theCase = new Case();
		this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
		this.theMicrophone = new Microphone(microMaxVol, speakerCrtVol);
	}
	
	public void pressVolumeUp() {
		this.theCase.pressVolumeUp();
		this.theSpeaker.increaseVolume();
	}
	public void pressVolumeDown() {
		this.theCase.pressVolumeDown();
		this.theSpeaker.decreaseVolume();
	}
	public void setPixel(int pixel,String color) {
		this.theScreen.setPixel(pixel, color);
	}
	public void colorScreen(String color) {
		this.theScreen.colorScreen(color);
	}
	public void increaseMicrophoneVolume() {
		this.theMicrophone.increaseVolume();
	}
	public void decreaseMicrophoneVolume() {
		this.theMicrophone.decreaseVolume();
	}
	public void muteMicrophone() {
		this.theMicrophone.muteMicrophone();
	}
	public void setSilenceMode() {
		this.theSpeaker.setSilenceMode();
	}
}

