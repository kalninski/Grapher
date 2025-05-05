package statistics;

public class Pow extends Function {
	
	private double power;
	
	public Pow(double power) {
		this.power = power;
		createValues();
		Panel.listOfFunctions.add(this);
	}

	@Override
	public Function createValues() {
		StringBuilder str = new StringBuilder();

		int y = 0;
		int counter = 0;
		for(int x = -Panel.WIDTH/2; x < Panel.WIDTH/2; x++) {
			xC[counter] = counter;
			yC[counter] = Panel.HEIGHT/2 - (int) ((100 * Panel.scaler) * Math.pow((x/(100 * Panel.scaler)), power));
			str.append(counter + ",");
			str.append(yC[counter] + " ");
			counter++;
		}
		System.out.println(str.toString());
		return this;
	}
}
