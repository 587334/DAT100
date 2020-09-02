package lab3;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class lab3oppg3 {

	public static void main(String[] args) {

		int x = parseInt(showInputDialog("Skriv inn tall x for uttrykket x^n:"));
		int n = parseInt(showInputDialog("Skriv inn hva x skal opphøyes i (x^n):"));

		int svar = (int) Math.pow(x, n);

		System.out.println("Svar A: " + svar);

		int i = 1;
		int tall = x;
		
		// Legger inn en if-setning for metoden uten pow, 
		// pga dersom n- verdien er null, gir det x-verdien til sluttsvar
		if (n == 0) {
			System.out.println("Svar B: 1");
		} else {
			while (i < n) {
				tall = tall * x;
				i++;
			}

			System.out.println("Svar B: " + tall);
		}

	}

}
