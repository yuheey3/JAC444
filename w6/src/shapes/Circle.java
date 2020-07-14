/*
 * Name: Yuki Waka
 * Date: July 13,2020
 * 
 * */
package shapes;

import static java.lang.Math.PI;

public class Circle implements Shape {
	private Math math;
	private double radius;
	// create object for area
	Area cirObj = () -> {
		return PI * radius * radius;
	};
	public Circle(double radius) throws Exception {

		if (radius > 0)
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
		result = Math.round(result * 100000) / 100000.0;

		return result;
	}
	// get area
	public double getArea() {
		return cirObj.calArea();
	}
	@Override
	public String toString() {
		return String.format("Circle {r=%.1f} perimaters = %.5f   (Area = %.2f)", getR(), perimaters(), getArea());
		// return String.format("Circle "+"{r="+ getR()+"} perimaters = " +perimaters()
		// );
	}
}
