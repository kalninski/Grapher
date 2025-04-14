package statistics;

import java.util.*;
import java.util.random.*;

public class Sine extends Function{
	

	
	public Sine() {
		
	}
	
	public Sine(double coeff1,double coeff2) {
		this.coeff1 = coeff1;
		this.coeff2 = coeff2;
		createValues();
		Panel.listOfFunctions.add(this);
	}
	
	
	public static double sin(double x, int terms) {
		double result  = 0;
		
		for(int i = 0; i < terms; i++) {
			double sign  = (i % 2 == 0) ? 1 : -1;
			double numerator = pow(x, i * 2 + 1);
			double denominator = factorial(i * 2 + 1);
			double term = (sign *  numerator) / denominator;
			result += term;
		}
		return result;
	}
	
	public static double pow(double base, int power) {
		double result  = 1;
		for(int i = 0; i < power;  i++) {
			result *= base;
		}
		
		return result;
	}
	
	@Override
	public Function createValues() {
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
//			System.out.println("x = " + x + "  dX = " + Panel.dX);
			xC[counter] = counter;
			yActualVal[counter] = 100  * coeff2 * Math.sin(((double)x * coeff1) / (100  * (Panel.scaler)));
			
			yC[counter] = Panel.HEIGHT/2 - (int) ((Panel.scaler) * yActualVal[counter]);
//			System.out.println("SIN x = " + x + "  for the output of y = " + yActualVal[counter]);
			counter++;
		}
		return this;
		
	}
	


}
