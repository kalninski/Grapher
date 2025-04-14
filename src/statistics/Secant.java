package statistics;

import java.util.Arrays;

public class Secant extends Function{
	
	public Secant() {
		
	}
	
	public Secant(double coeff1,double coeff2) {
		this.coeff1 = coeff1;
		this.coeff2 = coeff2;
		createValues();
		Panel.listOfFunctions.add(this);
	}
	
	@Override
	public Function createValues() {
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
//			System.out.println("x = " + x + "  dX = " + Panel.dX);
			xC[counter] = counter;
			yActualVal[counter] = 100 * (Panel.scaler) * coeff2 * Math.pow(Math.cos((((double)x) *coeff1/ (100  * (Panel.scaler)))), -1);
			
			int outputY = Panel.HEIGHT/2 - (int) (yActualVal[counter]);
			if(outputY >= Panel.HEIGHT) {
				outputY = Panel.HEIGHT;
				System.out.println("x = " + x + "  for the output of y = " + yActualVal[counter] + " x as argument = " +  ((double)x) *coeff1/ (100  * (Panel.scaler)) + "  y coordinate = " + outputY);
			}
			if(outputY <= 0) {
				outputY = 0;
				System.out.println("x = " + x + "  for the output of y = " + yActualVal[counter] + " x as argument = " +  ((double)x) *coeff1/ (100  * (Panel.scaler)) + "  y coordinate = " + outputY);
			}
			yC[counter] = outputY;

			counter++;
		}
		System.out.println(Arrays.toString(xC));
		System.out.println(Arrays.toString(yActualVal));
		System.out.println(Arrays.toString(yC));
		return this;
	}

}
