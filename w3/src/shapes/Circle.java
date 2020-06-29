/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */
package shapes;


public class Circle implements Shape {
	private Math math;
	private double radius;

	
	public Circle(double radius) throws Exception {
		
		if(radius > 0)
			this.radius = radius;
		else
			throw new Exception("invalid radius!");
	
	}
	
	public double getR() {
		return radius;
	}
 
	public void setR(double radius) {
		this.radius = radius;
	}

	@Override
	public double perimaters() {
	
		double result = 2 * math.PI * radius;
		result = Math.round(result*100000)/100000.0;
	
		return result;  
	}
	
	@Override
	public String toString() { 
		return String.format("Circle {r=%.1f} perimaters = %.5f", getR(), perimaters());
		//return String.format("Circle "+"{r="+ getR()+"} perimaters = " +perimaters() );
		
	}
}

