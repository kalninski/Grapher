package statistics;

import java.util.*;
import java.util.random.*;

public class Cosine extends Function {
	

	
	
	public Cosine() {
	}
	
	public Cosine(double coeff1,double coeff2) {
		this.coeff1 = coeff1;
		this.coeff2 = coeff2;
		createValues();
		Panel.listOfFunctions.add(this);


	}
	
	
	
	
//	public void createArrayForCos(double coeffForAngle, double coeffOutside) {
//		int counter = 0;
//
//		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
//
//			int yCos = Panel.HEIGHT/2 - (int) (( Math.cos((((double) x)/Panel.dX) * coeffForAngle) * Panel.dX) * coeffOutside);
//			xCoordinates[counter] = counter;
//			yCoordinates[counter] = yCos;
//			System.out.println("!");
//			counter ++;
//		}
//	}
	@Override
	public Function createValues() {
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
//			System.out.println("x = " + x + "  dX = " + Panel.dX);
			xC[counter] = counter;
			yActualVal[counter] = 100  * coeff2 * Math.cos(((double)x) *coeff1/ (100  * (Panel.scaler)));
			
			yC[counter] = Panel.HEIGHT/2 - (int) ((Panel.scaler) * yActualVal[counter]);
	//		System.out.println("x = " + x + "  for the output of y = " + yActualVal[counter]);
			counter++;
		}
		return this;
	}
	
	


}
