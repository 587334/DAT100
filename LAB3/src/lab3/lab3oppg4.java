package lab3;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class lab3oppg4 {
	
	//Fann ut at ved trinnskatt betaler man skatten innenfor hvert enkelt trinn.
	//Denne klassen beregner KORREKT trinnskatt 

	public static void main(String[] args) {

		int bruttoinntekt = parseInt(showInputDialog("Tast inn din bruttoinntekt:"));

		double trinnskatt = 0;

		double trinn1 = (254500 - 180800) * 0.019;
		double trinn2 = (639750 - 254500) * 0.042;
		double trinn3 = (999550 - 639750) * 0.132;

		if (bruttoinntekt >= 0 && bruttoinntekt <= 180800) {
			trinnskatt = 0;
		}
		if (bruttoinntekt >= 180801 && bruttoinntekt <= 254500) {
			trinnskatt = ((bruttoinntekt - 180800) * 0.019);
		}
		if (bruttoinntekt >= 254501 && bruttoinntekt <= 639750) {
			trinnskatt = ((bruttoinntekt - 254500) * 0.042) + trinn1;
		}
		if (bruttoinntekt >= 639751 && bruttoinntekt <= 999550) {
			trinnskatt = ((bruttoinntekt - 639750) * 0.132) + trinn1 + trinn2;
		}
		if (bruttoinntekt >= 999551) {
			trinnskatt = ((bruttoinntekt - 999550) * 0.162) + trinn1 + trinn2 + trinn3;
		}

		int heltrinnskatt = (int) (trinnskatt + 0.5);

		System.out.println("Din trinnskatt er " + heltrinnskatt + " kroner");
	}

}
