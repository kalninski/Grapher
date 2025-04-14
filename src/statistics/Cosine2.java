package statistics;

public class Cosine2 extends Function {
	
	public int[] xC = new int[Panel.WIDTH];
	public int[] yC = new int[Panel.WIDTH];
	public double[] yActualVal = new double[2*Panel.WIDTH];
	public double coeff1;
	public double coeff2;
	public boolean appear = true;
	
	public Cosine2(double a, double b) {
		this.coeff1 = a;
		this.coeff2 = b;
		createValues();
		Panel.listOfFunctions.add(this);

	}
	
	public Cosine2 createValues() {
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
//			System.out.println("x = " + x + "  dX = " + Panel.dX);
			xC[counter] = counter;
			yActualVal[counter] = 100  * Math.cos(((double)x) / (100  * (Panel.scaler)));
			
			yC[counter] = Panel.HEIGHT/2 - (int) ((Panel.scaler) * yActualVal[counter]);
	//		System.out.println("x = " + x + "  for the output of y = " + yActualVal[counter]);
			counter++;
		}
		return this;
	}
	
	public Cosine2 rescaleAllY() {
		int newSize =(int) (((double) yC.length) * (Panel.scaler));
		int[] newY = new int[newSize]; 
		int[] newX = new int[newSize];


		for(int y = 0; y < yC.length; y++) {

			
			xC[y] = (int) (((double) y) * (Panel.scaler)); 
			yC[y] = Panel.HEIGHT/2 - (int) (yActualVal[y] * (Panel.scaler)); 

		}
		return this;
	}

}
