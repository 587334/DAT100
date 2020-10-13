package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		return ystep;
	}

	public void showRouteMap(int ybase) {

		double [] xtab = new double [gpspoints.length];
		double [] ytab = new double [gpspoints.length];
		
		//Tabeller for for å oppbevare x- og y-koordinater
		int [] xPunkt = new int [gpspoints.length];
		int [] yPunkt = new int [gpspoints.length];
		
		setColor(0, 255, 0);
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			xtab[i] = gpspoints[i].getLongitude();
			ytab[i] = gpspoints[i].getLatitude();
			
			int x = 50 + (int) ((xtab[i] - GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints))) * xstep());
			int y = ybase - (int) ((ytab[i] - GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints))) * ystep());
			
			fillCircle((int) x, (int) y, 2);
			
			//Tabeller for for å oppbevare x- og y-koordinater
			xPunkt[i] = x;
			yPunkt[i] = y;
		}
		
		//Tegner strekene mellom hvert punkt
		for (int i = 0; i < gpspoints.length - 1; i++) {
				drawLine(xPunkt[i], yPunkt[i], xPunkt[i+1], yPunkt[i+1]);
		}
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		drawString("Total Time     :" + GPSUtils.formatTime(gpscomputer.totalTime()), 50, 50);
		drawString("Total distance :" + GPSUtils.formatDouble(gpscomputer.totalDistance()/1000) + " km", 50, 65);
		drawString("Total elevation:" + GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m", 50, 80);
		drawString("Max speed      :" + GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t", 50, 95);
		drawString("Average speed  :" + GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t", 50, 110);
		drawString("Energy         :" + GPSUtils.formatDouble(gpscomputer.totalKcal(80.0)) + " kcal", 50, 125);
		
	}

}
