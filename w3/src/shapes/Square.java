/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */
package shapes;

public class Square extends Rectangle {
	public Square(double side) throws Exception {
	
			super(side, side);
			
		//System.out.println("Square constructor was called");
	}
	@Override
	public String toString() {
		if(getWidth() >= 0.1)
		return String.format("Square {s=%.1f} perimaters = %.3f", getWidth(), perimaters());
		else
			return String.format("Square " +"{s="+ getWidth()+"} perimaters = " +perimaters());
	}
	
}

