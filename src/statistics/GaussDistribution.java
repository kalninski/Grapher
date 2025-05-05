package statistics;

import java.util.*;
import java.util.random.*;

public class GaussDistribution extends Function {
	
	public double deviation;
	public double mean;
	
	public GaussDistribution() {
		
	}
	
	public GaussDistribution(double deviation, double mean) {
		this.deviation = deviation;
		this.mean = mean;
		createValues();
		Panel.listOfFunctions.add(this);
	}
	
	public double gaussPDF(double x) {
		double result = 0;
		double coeff = 100 * Panel.scaler/(Math.sqrt(2 * Math.PI) * deviation);
		double exponent = (-1) * ((x - (mean * 100 * Panel.scaler)) * (x - (mean * 100 * Panel.scaler)) / (2 * deviation * deviation * 100 * 100 * Panel.scaler * Panel.scaler));
		result = coeff * Math.exp(exponent);
		return result;
	}



	
	
	@Override
	public Function createValues() {
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
			double distributionVal = Panel.HEIGHT/2 -  gaussPDF(x);

			this.xActualVal[counter] = (double) counter;
			this.yActualVal[counter] = distributionVal;
			this.xC[counter] = counter;
			this.yC[counter] = (int) distributionVal;
			
			counter++;
		}

		
		return this;
		
	}
	
}
