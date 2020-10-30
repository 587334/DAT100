package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File file = new File(mappe + filnavn);
		Scanner leser = null;
		Blogg blogg = null;
		
		try {
			leser = new Scanner(file);
			blogg = new Blogg(Integer.parseInt(leser.nextLine()));
			while(leser.hasNextLine()) {
				String data = leser.nextLine();
				if(data.equals(BILDE)) {
					Bilde bilde = new Bilde(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(), Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine());
					blogg.leggTil(bilde);
				} else if (data.equals(TEKST)) {
					Tekst tekst = new Tekst(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(), Integer.parseInt(leser.nextLine()), leser.nextLine());
					blogg.leggTil(tekst);
				}
			}
			leser.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return blogg;
	}
}