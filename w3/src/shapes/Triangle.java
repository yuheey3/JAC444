/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */
package shapes;

public class Triangle implements Shape {
	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c) throws Exception {
		double max;
		// all numbers must be bigger than 0
		if (a > 0 && b > 0 && c > 0) {
			// find maximum number and calculate
			// if the max number is bigger than sum of two numbers, throw error
			if (a >= b && a >= c) {
				max = a;
				if (a >= b + c)
					throw new Exception("invalid side(s)!");

			} else if (b >= a && b >= c) {
				max = b;
				if (b >= a + c)
					throw new Exception("invalid side(s)!");

			} else {
				max = c;
				if (c >= a + b)
					throw new Exception("invalid side(s)!");
			}
			this.a = a;
			this.b = b;
			this.c = c;
		} else
			throw new Exception("invalid side(s)!");

		// System.out.println("Triangle constructor was called");
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public double perimaters() {
		return a + b + c;

	}

	@Override
	public String toString() {
		return String.format("Triangle {a=%.1f b=%.1f c=%.1f} perimaters = %.4f", getA(), getB(), getC(), perimaters());
//		return String.format(this.getClass().getName()+"{a="+ getA()+" b="+getB()+ " c="+getC()+"} perimaters = " +perimaters());
	}
}
