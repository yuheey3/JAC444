
/*
 * Name: Yuki Waka
 * Date: July 6,2020 
 * Assignment5
 * Student#: 141082180
 * */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ReadObject extends JFrame {
	private final JTextArea textArea1;
	private final JButton checkButton;

	@SuppressWarnings("unchecked")
	public ReadObject() {
		List<Student> studentObj = new ArrayList<Student>();

		try {// read file
			FileInputStream fis = new FileInputStream("file.out");
			ObjectInputStream ois = new ObjectInputStream(fis);
			studentObj = (List<Student>) ois.readObject();
			fis.close();

		} catch (Throwable e) {
			System.err.println(e);
		}
		// assign to string
		String string = "";
		String s = "";
		for (int i = 0; i < studentObj.size(); i++) {
			s = ("Student Id: " + studentObj.get(i).getId() + ", Name: " + studentObj.get(i).getFirstName() + " "
					+ studentObj.get(i).getLastName() + ", Course: " + studentObj.get(i).getCourse() + "\n");
			string = string + s;
		}

		Box box = Box.createHorizontalBox(); // create box
		textArea1 = new JTextArea(string, 10, 15);
		Font  f1  = new Font(Font.SERIF, Font.PLAIN,  18);//font
		textArea1.setFont(f1);//set font
		box.add(new JScrollPane(textArea1)); // add scrollpane
		textArea1.setVisible(false);
		checkButton = new JButton("Check All Students Info"); // button
		box.add(checkButton); // add copy button to box
		checkButton.addActionListener(new ActionListener() // anonymous inner class
		{
			@Override
			public void actionPerformed(ActionEvent event) {
				textArea1.setVisible(true);// when button clicked, show the box
			}
		});
		add(box); // add box to frame

	}
}
