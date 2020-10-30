package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		Innlegg[] innlegg = samling.getSamling();
		
		PrintWriter skriver = null;
		File file = new File(mappe + filnavn);

		try {
			skriver = new PrintWriter(file);
			skriver.write(Integer.toString(samling.getAntall()) + "\n");
			for(int i = 0; i < innlegg.length; i++) {
				if(innlegg[i] != null) {
					skriver.write(innlegg[i].toString());
				}
			}
			skriver.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}
