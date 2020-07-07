
/*
 * Name: Yuki Waka
 * Date: July 6,2020 
 * Assignment5
 * Student#: 141082180
 * */
// JTextFields and JPasswordFields.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel; // displays text and images
import javax.swing.JButton;
import java.io.*;

public class WriteObject extends JFrame {

	private JLabel label1, label2, label3, label4, label5, label6, label7; // label
	private final JButton plainJButton; // button with just text

	// create student object and list
	Student[] Students = new Student[10];
	List<Student> sections = new ArrayList<Student>();
	//ArrayList<String> list = new ArrayList<String>();

	JTextField[] textField1 = new JTextField[10];
	JTextField[] textField2 = new JTextField[10];
	JTextField[] textField3 = new JTextField[10];
	JTextField[] textField4 = new JTextField[10];
	JTextField[] textField5 = new JTextField[10];
	JTextField[] textField6 = new JTextField[10];
	JTextField[] textField7 = new JTextField[10];

	// constructor adds JTextFields/label to JFrame
	public WriteObject() {

		super("Testing JTextField and label");
		setLayout(new FlowLayout());
		
		// loop 10 for 10 students
		// add label to JFrame
		// construct textfield with 10 columns
		for (int i = 0; i < 10; i++) {

			label1 = new JLabel("Student Id: ");
			label1.setToolTipText("This is label1");
			add(label1);

			textField1[i] = new JTextField(10);
			add(textField1[i]);

			label2 = new JLabel("First Name: ");
			label2.setToolTipText("This is label2");
			add(label2);

			textField2[i] = new JTextField(10);
			add(textField2[i]);

			label3 = new JLabel("last Name: ");
			label3.setToolTipText("This is label3");
			add(label3);

			textField3[i] = new JTextField(10);
			add(textField3[i]);

			label4 = new JLabel("Course1: ");
			label4.setToolTipText("This is label4");
			add(label4);

			textField4[i] = new JTextField(10);
			add(textField4[i]);

			label5 = new JLabel("Course2: ");
			label5.setToolTipText("This is label5");
			add(label5);

			textField5[i] = new JTextField(10);
			add(textField5[i]);

			label6 = new JLabel("Course3: ");
			label6.setToolTipText("This is label6");
			add(label6);

			textField6[i] = new JTextField(10);
			add(textField6[i]);

			label7 = new JLabel("Course4: ");
			label7.setToolTipText("This is label7");
			add(label7);

			textField7[i] = new JTextField(10);
			add(textField7[i]);
		}

		plainJButton = new JButton("Submit"); // button with text
		add(plainJButton);
		// action listener
		for (int i = 0; i < 7; i++) {
			TextFieldHandler handler = new TextFieldHandler();
			textField1[i].addActionListener(handler);
			textField2[i].addActionListener(handler);
			textField3[i].addActionListener(handler);
			textField4[i].addActionListener(handler);
			textField5[i].addActionListener(handler);
			textField6[i].addActionListener(handler);
			textField7[i].addActionListener(handler);
		}
		TextFieldHandler handle8r = new TextFieldHandler();
		plainJButton.addActionListener(handle8r);
	}

	private class TextFieldHandler implements ActionListener {
		// handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
			for (int i = 0; i < 10; i++) {
				ArrayList<String> list = new ArrayList<String>();
				Students[i] = new Student();
				int id = Integer.parseInt(textField1[i].getText());
				Students[i].setId(id);
				Students[i].setFirstName(textField2[i].getText());
				Students[i].setLastName(textField3[i].getText());
				list.add(textField4[i].getText());
				list.add(textField5[i].getText());
				list.add(textField6[i].getText());
				list.add(textField7[i].getText());
				Students[i].setCourse(list);
				sections.add(Students[i]);
			}
			// store into file
			try {
				FileOutputStream fos = new FileOutputStream("file.out");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(sections);
				oos.flush();
				fos.close();

			} catch (Throwable e) {
				System.err.println(e);
			}
			JOptionPane.showMessageDialog(WriteObject.this, String.format("Student data is submitted!"));// button
		}
	}
}
