/*
 * Name: Yuki Waka
 * Date: June 15,2020
 * 
 * */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Circle;
import shapes.Parallelogram;
import shapes.Square;
import shapes.Triangle;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * Task 1
		 * 
		 */
		System.out.println("------->JAC 444 Assignment2<------");
		System.out.println("------->Task 1 ...<------");
		String[] arr = new String[200];
		int size = 0;
		Shape[] shapes = new Shape[32];

		String path = Main.class.getResource("").getPath();

		File fileName = new File(path + "allShape.txt");
//read file 
		try (FileReader fileStream = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileStream)) {

			String line = null;
//get line
			while ((line = bufferedReader.readLine()) != null) {
				if (line.startsWith("Shape") || line.startsWith("Something") || line.startsWith("Garbage")
						|| line.startsWith("END")) {
					// System.out.println("Invalid radius!");
				} else {
					String[] tokens = line.split(",");

					// assign to String array
					for (String element : tokens) {
						arr[size] = element;
						size++;
					}
				}
			}

			int shapeSize = 0;
			for (int i = 0; i < size; i++) {

				if (arr[i].equals("Circle")) {

					double d = Double.parseDouble(arr[i + 1]);
					if (arr[i + 2].equals("0")) {

					} else {
						try {
							shapes[shapeSize] = new Circle(d);
							shapeSize++;
							i++;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (arr[i].equals("Parallelogram")) {
					double d1 = Double.parseDouble(arr[i + 1]);
					double d2 = Double.parseDouble(arr[i + 2]);
					if (arr[i + 3].equals("0.0")) {

					} else {
						try {
							shapes[shapeSize] = new Parallelogram(d1, d2);
							shapeSize++;
							i = i + 2;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (arr[i].equals("Rectangle")) {
					double d1 = Double.parseDouble(arr[i + 1]);
					double d2 = Double.parseDouble(arr[i + 2]);
					try {
						shapes[shapeSize] = new Rectangle(d1, d2);
						shapeSize++;
						i = i + 2;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (arr[i].equals("Square")) {
					double d = Double.parseDouble(arr[i + 1]);
					try {
						shapes[shapeSize] = new Square(d);
						shapeSize++;
						i++;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (arr[i].equals("Triangle")) {
					double d1 = Double.parseDouble(arr[i + 1]);
					double d2 = Double.parseDouble(arr[i + 2]);
					double d3 = Double.parseDouble(arr[i + 3]);
					try {
						shapes[shapeSize] = new Triangle(d1, d2, d3);
						shapeSize++;
						i = i + 3;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
			System.out.println("\n" + shapeSize + " shapes were created.");

			for (Shape shape : shapes) {
				// System.out.println(shape);
				System.out.printf(shape.toString() + "\n\n");
			}
			/*
			 * Task 2
			 * 
			 */
			System.out.println("\n\n------->Task 2 ...<------");

			double triMin = 100;
			double cirMax = 0;
			// declare temporary Shape
			Shape[] temp = new Shape[shapes.length];
			int index = 0;

			for (int i = 0; i < shapes.length; i++) {
				// find minimum parameters in Triangle
				if ((shapes[i].getClass().getName()).equals("shapes.Triangle")) {
					double p = shapes[i].perimaters();
					if (triMin > p) {
						triMin = p;

					}
					// find maximum parameters in Circle
				} else if ((shapes[i].getClass().getName()).equals("shapes.Circle")) {
					double p = shapes[i].perimaters();
					if (cirMax < p) {
						cirMax = p;
					}
				}
			}
			for (int i = 0; i < shapes.length; i++) {
				// if find matched minimum parameters, not assign to array, otherwise assign to
				// it
				if ((shapes[i].getClass().getName()).equals("shapes.Triangle")) {
					double p = shapes[i].perimaters();
					if (triMin == p) {

					} else {
						temp[index] = shapes[i];
						index++;
					}
					// if find matched maximum parameters, not assign to array, otherwise assign to
					// it
				} else if ((shapes[i].getClass().getName()).equals("shapes.Circle")) {
					double p = shapes[i].perimaters();
					if (cirMax == p) {

					} else {
						temp[index] = shapes[i];
						index++;
					}
					// rest of them assign to array
				} else {
					temp[index] = shapes[i];
					index++;
				}

			}
			// assign with proper size of array
			Shape[] shapes2 = new Shape[index];
			for (int i = 0; i < index; i++) {
				shapes2[i] = temp[i];
			}
			// display
			for (Shape shape : shapes2) {
				// System.out.println(shape);
				System.out.printf(shape.toString() + "\n\n");
			}
			/*
			 * Task 3
			 * 
			 */
			System.out.println("\n\n------->Task 3 ...<------");
			double parallTotal = 0;
			double triTotal = 0;

			for (int i = 0; i < shapes2.length; i++) {
				// calculate total of Parallelogram perimaters
				if ((shapes2[i].getClass().getName()).equals("shapes.Parallelogram")) {
					double p = shapes2[i].perimaters();
					parallTotal += p;
					// calculate total of Triangle perimaters
				} else if ((shapes2[i].getClass().getName()).equals("shapes.Triangle")) {
					double p = shapes2[i].perimaters();
					triTotal += p;
				}
			}
			System.out.println(String.format("Total perimeter of Parallelogram is: %.14f", parallTotal));
			System.out.println(String.format("Total perimeter of Triangle is: %.1f", triTotal));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
