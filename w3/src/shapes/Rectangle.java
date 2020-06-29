/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */

package shapes;


public class Rectangle implements Shape {
	private double width;
	private double length;
	
	public Rectangle(double width, double height) throws Exception {
		
		if(width > 0 && height > 0) {
			this.width = width;
			this.length = height;
		}
		else
			throw new Exception("invalid side!");
		//System.out.println("Rectangle constructor was called");
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
		return (2*getWidth()) + (2*getHeight());
	
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle {w=%.1f h=%.1f} perimaters = %.4f", getWidth(), getHeight(), perimaters());
		//return String.format(this.getClass().getName()+"{w="+ getWidth()+"h="+getHeight()+"} perimaters = " +perimaters());
	}
}
