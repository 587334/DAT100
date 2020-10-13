package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double desimaltall [] = new double [gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			desimaltall [i] = gpspoints[i].getLatitude();
		}
		
		return desimaltall;

	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double desimaltall [] = new double [gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			desimaltall[i] = gpspoints[i].getLongitude();
		}
		
		return desimaltall;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double a, c, d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		double delLatitude = toRadians(latitude2) - toRadians(latitude1);
		double delLongitude = toRadians(longitude2) - toRadians(longitude1);
		
		a = pow(sin(delLatitude/2), 2) + cos(toRadians(latitude1)) * cos(toRadians(latitude2)) * pow(sin(delLongitude/2), 2);
		c = 2 * atan2(sqrt(a), sqrt(1 - a));
		d = R * c;
		
		return d;
		
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = (distance(gpspoint1, gpspoint2)/1000)/(secs/3600.0);
		//deler på 1000 for å få distanse i km, på 3600 for å få tiden i timer for å gjennomføre km/t
		
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;

		int hh = secs / 3600;
		int mm = secs / 60 - hh * 60;
		int ss = secs % 60;
		
		timestr = String.format("  %02d:%02d:%02d", hh, mm, ss);
		
		return timestr;
	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		str = String.format("%10.2f", d).replaceAll(",",".");
		
		return str;
		
	}
}