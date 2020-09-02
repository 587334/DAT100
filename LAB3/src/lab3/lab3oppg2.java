package lab3;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class lab3oppg2 {

	public static void main(String[] args) {
		
		int nedre = parseInt(showInputDialog("Skriv inn en nedre grense:"));
		int ovre = parseInt(showInputDialog("Skriv inn en øvre grense:"));
		int i = 0;
		String oddetall = "";
		
		System.out.println("Resultat:");
		
		if (nedre % 2 == 1) {
			for (i = nedre; i <= ovre; i += 2) {
				oddetall += i + ", ";
			}
		} else {
			for (i = nedre + 1; i <= ovre; i += 2) {
				oddetall += i + ", ";
			}
		}
		
		showMessageDialog(null, "Resultat: " + oddetall);
		
	}

}
