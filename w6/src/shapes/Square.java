/*
 * Name: Yuki Waka
 * Date: July 13,2020
 * 
 * */
package shapes;

public class Square extends Rectangle {
	//create object for area
     Area squareObj = () -> { return getWidth() * getHeight(); };
		
	public Square(double side) throws Exception {
	
			super(side, side);
			
		//System.out.println("Square constructor was called");
	}
	@Override
	public String toString() {
		if(getWidth() >= 0.1)
		return String.format("Square {s=%.1f} perimaters = %.3f   (Area = %.2f)", getWidth(), perimaters(), getArea());
		else
			return String.format("Square " +"{s="+ getWidth()+"} perimaters = " +perimaters());
	}
	//get area
    public double getArea() {
	    return squareObj.calArea();
	 }
}

