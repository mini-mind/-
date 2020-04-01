import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;

public class PlayMusic {
	public static AudioClip back = loadSound(5);
	public static AudioClip eat0 = loadSound(1);
	public static AudioClip rat1 = loadSound(2);
	public static AudioClip eat2 = loadSound(3);
	public static AudioClip over = loadSound(4);
	private static boolean backFlag = true, specialFlag = true;

	public static void stop(AudioClip christmas) {
		try {
			christmas.stop();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}

	public static void setBackGroundSound(boolean b) {
		backFlag = b;
	}

	public static boolean getBackGroundSound() {
		return backFlag;
	}
	public static void setSpecialSound(boolean b) {
		specialFlag = b;
	}
	public static boolean getSpecialSound() {
		return specialFlag;
	}

	public static void play(AudioClip christmas, boolean b) {
		if ((christmas == back && !backFlag) || (christmas != back && !specialFlag))
			return;
		if (b)
			christmas.loop();
		else
			christmas.play();
	}

	public static AudioClip loadSound(int i) {
		URL url = null;
		if (i == 1) {
			try {
				url = new URL("file:" + "eat0.wav");
			} catch (MalformedURLException e) {
				;
			}
			return JApplet.newAudioClip(url);
		}
		if (i == 2) {
			try {
				url = new URL("file:" + "eat1.wav");
			} catch (MalformedURLException e) {
				;
			}
			return JApplet.newAudioClip(url);
		}
		if (i == 3) {
			try {
				url = new URL("file:" + "eat2.wav");
			} catch (MalformedURLException e) {
				;
			}
			return JApplet.newAudioClip(url);
		}
		if (i == 4) {
			try {
				url = new URL("file:" + "over.wav");
			} catch (MalformedURLException e) {
				;
			}
			return JApplet.newAudioClip(url);
		}
		if (i == 5) {
			try {
				url = new URL("file:" + "background.wav");
			} catch (MalformedURLException e) {
				;
			}
			return JApplet.newAudioClip(url);
		}
		return null;
	}
}