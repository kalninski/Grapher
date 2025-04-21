package statistics;

import java.util.*;
import java.util.random.*;

public class Function {
	
	public int[] xC = new int[Panel.WIDTH];
	public int[] yC = new int[Panel.WIDTH];
	public double[] yActualVal = new double[Panel.WIDTH];
	public double coeff1;
	public double coeff2;
	public boolean isVisable = true;
	String coordinatesForSVG;
	public void setAppear(boolean isVisable) {
		this.isVisable = isVisable;
	}
	
	
	public static int[] addValuesOfAnotherFunction(int[] imagesFunctA, int[] imagesFunctB) {
		int size = 1000;
		int[] result = new int[Panel.WIDTH];
		for(int y = 0; y < Panel.WIDTH; y++) {
			result[y] = (imagesFunctB[y] + imagesFunctA[y]) - Panel.HEIGHT/2;
		}
		return result;
	}
	
	public void setYValues(int[] newImages) {
		for(int x = 0; x < Panel.WIDTH; x++) {
			xC[x] = x;
		}
		yC = newImages;
		Panel.listOfFunctions.add(this);
	}
	
	public void createOutputValues() {
//		System.out.println("Function Class YValues = " + Arrays.toString(yCoordinates) + " size = " + yCoordinates.length);
		
		
	}
	
	public static double factorial(double a) {
		double result = 1;
		if(a == 0) {
			return 1;
		}
		for(int i = 1; i <= a; i++) {
			result *= i;	
		}
		return result;
	} 
	
	public Function createValues() {
		return this;
	}
	
	public static int interpolateTwoPoints(int y1, int y2) {
		int newY = 0;
		
		return newY;
	}
	
	
	public int[] multiplyArrays(int [] arr1, int[] arr2) {
		int size = arr1.length;
		for(int y = 0; y < size; y++) {
			arr1[y] = arr1[y] * arr2[y];
		}
		return arr1;
	}
	
	public int[] multiplyArrayByConstant(double constant, int[] arr) {
		int size = arr.length;
		for(int y = 0; y < size; y++) {
			double val = (double) arr[y];
			int result = (int) (val * constant);
			arr[y] = result;
		}
		
		return arr;
	}
	
	public int[] addTwoArrays(int[] arr1, int[] arr2) {
		int size = arr1.length;
		for(int y = 0; y < size; y++) {
			arr1[y] = arr1[y] + arr2[y];
		}
		return arr1;
	}
	
	public int[] subtractTwoArrays(int[] arr1, int[] arr2) {
		int size = arr1.length;
		for(int y = 0; y < size; y++) {
			arr1[y] = arr1[y] - arr2[y];
		}
		return arr1;
	}
	
	public void coordiantesForSVG() {
		StringBuilder str = new StringBuilder("M " + xC[0] + ", " + yC[0] + "  C " + xC[1] + ", " + yC[1] + " ");
		int size = xC.length;
		for(int i = 2; i < size; i++) {
			str.append(xC[i] + ",");
			str.append(yC[i] + " ");
			coordinatesForSVG = str.toString();
		}
		
	}
}
