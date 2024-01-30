//package myplanets;

import static java.lang.System.out;
import java.lang.*;
import java.io.*;

enum PlanetType {ROCKY, GAS_GIANTS, ICE_GIANTS};

class Planet {
		
	private String designation;
	private double massKg = 0;
	private double orbitEarthYears = 0;
	private PlanetType type;
	
	public Planet(String designation, PlanetType type) {
		this.designation = designation;
		this.type = type;
	}
	
	public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
		this.designation = designation;
		this.massKg = massKg;
		this.orbitEarthYears = orbitEarthYears;
		this.type = type;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public boolean equals (Planet obj) {
		return (designation.toUpperCase().trim().equals(obj.getDesignation().toUpperCase().trim()));  // This is not sufficient, shall also check the other properties...
	}
	
	public int hashcode () {
		double MASS_KG_EARTH = 5.972e+24d;
		
		if (massKg == 0 || orbitEarthYears == 0) {
			 System.out.printf("***Warning: hash code 0 means Mass and Orbit are not configured yet.***\n");
			 return 0;
		}
		return (int) (massKg * orbitEarthYears / MASS_KG_EARTH); // May not be a perfect hash algorithm, meaning there could be collisions. 
	}
	
	public String toString () {
		return designation + ": " + hashcode() + "," + type;
	}
}


public class planets {
    public static void main(String[] args) {
		Planet planet1 = new Planet ("Earth", 5.972e+24d, 1, PlanetType.ROCKY);
		Planet planet2 = new Planet ("Jupiter", 1.898e+27d, 12, PlanetType.GAS_GIANTS);
		Planet planet3 = new Planet ("Neptune", 1024e+26d, 165, PlanetType.ICE_GIANTS);
		Planet planet4 = new Planet (" earth ", PlanetType.ROCKY);	//Add extra space and use all lower case	
		

        if (planet1.equals(planet2)) {
			System.out.printf("planet1(%s) and planet2(%s) are equal\n", planet1.getDesignation(), planet2.getDesignation());
		}
		else {
		    System.out.printf("planet1(%s) and planet2(%s) are not equal\n", planet1.getDesignation(), planet2.getDesignation());
		}	
		
        if (planet1.equals(planet4)) {
			System.out.printf("planet1(%s) and planet4(%s) are equal\n", planet1.getDesignation(), planet4.getDesignation());
		}
		else {
		    System.out.printf("planet1(%s) and planet4(%s) are not equal\n", planet1.getDesignation(), planet4.getDesignation());
		}		
		
		System.out.printf("\n");
		
		System.out.printf("%s\n", planet1.toString());
		System.out.printf("%s\n", planet2.toString());
		System.out.printf("%s\n", planet3.toString());
		System.out.printf("%s\n", planet4.toString());
	}
}