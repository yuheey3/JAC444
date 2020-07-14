/*
 * Name: Yuki Waka
 * Date: July 13,2020
 * 
 * */

package shapes;

public class Rectangle implements Shape {
	private double width;
	private double length;
	// create object for area
	Area recObj = () -> {
		return width * length;
	};

	public Rectangle(double width, double height) throws Exception {

		if (width > 0 && height > 0) {
			this.width = width;
			this.length = height;
		} else
			throw new Exception("invalid side!");
		// System.out.println("Rectangle constructor was called");
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return length;
	}

	public void setHeight(double height) {
		this.length = height;
	}
	
	@Override
	public double perimaters() {
		return (2 * getWidth()) + (2 * getHeight());

	}
	// get area
	public double getArea() {
		return recObj.calArea();
	}
	@Override
	public String toString() {
		return String.format("Rectangle {w=%.1f h=%.1f} perimaters = %.4f   (Area = %.2f)", getWidth(), getHeight(),
				perimaters(), getArea());
		// return String.format(this.getClass().getName()+"{w="+
		// getWidth()+"h="+getHeight()+"} perimaters = " +perimaters());
	}
}
