package lab3;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class lab3oppg5 {

	public static void main(String[] args) {

		int studenter = parseInt(showInputDialog("Hvor mange studenter skal du \nlese inn poengsummer fra?"));
		int i = 0;

		for (i = 1; i <= studenter; i++) {

			int poeng = parseInt(showInputDialog("Tast inn poengsum:"));
			char karakter = ' ';

			if (poeng < 0 || poeng > 100) {
				do {
					poeng = parseInt(showInputDialog("Ugyldig poengsum! \nTast inn på nytt:"));
				} while (poeng < 0 || poeng > 100);
			}

			if (poeng <= 100 && poeng >= 90) {
				karakter = 'A';
			} else if (poeng <= 89 && poeng >= 80) {
				karakter = 'B';
			} else if (poeng <= 79 && poeng >= 60) {
				karakter = 'C';
			} else if (poeng <= 59 && poeng >= 50) {
				karakter = 'D';
			} else if (poeng <= 49 && poeng >= 40) {
				karakter = 'E';
			} else if (poeng <= 39 && poeng >= 0) {
				karakter = 'F';
			}

			showMessageDialog(null, "Med " + poeng + " poeng er karakteren " + karakter);
		}

	}

}
