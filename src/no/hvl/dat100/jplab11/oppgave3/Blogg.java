package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg [20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg [lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for(int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] != null && innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		
		int id = finnInnlegg(innlegg);
		
		if(id != -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ledigPlass() {
		
		if (nesteledig < innleggtabell.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		
		String tekst = nesteledig + "\n";
		
		for (Innlegg element : innleggtabell) {
			tekst += element.toString();
		}
		return tekst;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] nyTabell = new Innlegg [nesteledig * 2];
		
		for (int i = 0; i < nesteledig; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		
		innleggtabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (leggTil(innlegg)) {
			return true;
		} else {
			utvid();
		
			if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
			
			} else {
			return false;
			}
		}
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int i = finnInnlegg(innlegg);
		
		if (i == -1) {
			return false;
		} else {
			innleggtabell[i] = null;
			nesteledig--;
			return true;
		}
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}