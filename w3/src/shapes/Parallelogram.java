/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */
package shapes;

public class Parallelogram extends Rectangle {
	public Parallelogram(double side, double side2) throws Exception {
		super(side, side2);
	}
		@Override
		public String toString() {
			return String.format("Parallelogram {w=%.1f h=%.1f} perimaters = %.5f", getWidth(),getHeight(), perimaters());
			
			//return String.format("Square " +"{s="+ getWidth()+"} perimaters = " +perimaters());
		}
		
	
}
