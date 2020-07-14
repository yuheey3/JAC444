/*
 * Name: Yuki Waka
 * Date: July 13,2020
 * 
 * */
package shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import shapes.Circle;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * Task 4
		 * 
		 */
		System.out.println("------->JAC 444 Workshop 6<------");
		System.out.println("------->Task 4 ...<------");
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
			//display
			System.out.println("\n" + shapeSize + " shapes were created.");

			for (Shape shape : shapes) {
				// System.out.println(shape);
				System.out.printf(shape.toString() + "\n\n");

			}
		}
	}

}
