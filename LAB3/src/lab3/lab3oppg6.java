package lab3;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class lab3oppg6 {

	public static void main(String[] args) {
		
		int heltall = parseInt(showInputDialog("Skriv inn et heltall:"));
		
		if (heltall <=0) {
			do {
				heltall = parseInt(showInputDialog("Negative tall og 0 er ikke gyldig. \nTast inn på nytt:"));
			} while (heltall <= 0);
		}
		
		int x = 1;
		int n = heltall;
		
		while (n > 1) {
			x = x * n;
			n--;
		}
		
		System.out.println(heltall + " = " + x);

	}

}
