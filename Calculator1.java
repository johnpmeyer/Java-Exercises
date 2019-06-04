import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Sample application using Frame.
 *
 * @author
 * @version 1.00 07/04/18
 */
 import java.awt.event.*;

public class Calculator1 extends JFrame implements ActionListener{
     JTextField jb = new JTextField();
     double result = 0;
     double numberOne = 0;
     double numberTwo = 0;
     String action="";

     public static void main(String[] args) {
		Calculator1 demo = new Calculator1();
		demo.setVisible(true);
	}

    /**
     * The constructor.
     */
     public Calculator1() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu();
        JMenuItem menuFileExit = new JMenuItem();
        Container c = getContentPane();
        c.setBackground(Color.YELLOW);
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        JButton clear = new JButton("C");
        JButton equals = new JButton("=");



        setLayout(new GridLayout(5,1));
        JPanel r1 = new JPanel();
        r1.setBackground(Color.RED);
        JPanel r2 = new JPanel();
        r2.setBackground(Color.WHITE);
        JPanel r3 = new JPanel();
        r3.setBackground(Color.BLUE);
        JPanel r4 = new JPanel();
        r4.setBackground(Color.YELLOW);
        JPanel r5 = new JPanel();
        r5.setBackground(Color.CYAN);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        r1.setLayout(new GridLayout(1,1));
        r1.add(jb);
        r2.setLayout(new GridLayout(1,4));
        r2.add(b1);
        r2.add(b2);
        r2.add(b3);
        r2.add(plus);
        r3.setLayout(new GridLayout(1,4));
        r3.add(b4);
        r3.add(b5);
        r3.add(b6);
        r3.add(minus);
        r4.setLayout(new GridLayout(1,4));
        r4.add(b7);
        r4.add(b8);
        r4.add(b9);
        r4.add(divide);
        r5.setLayout(new GridLayout(1,4));
        r5.add(clear);
        r5.add(b0);
        r5.add(equals);
        r5.add(multiply);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        minus.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        plus.addActionListener(this);

        menuFile.setLabel("File");
        menuFileExit.setLabel("Exit");

        // Add action listener.for the menu button
        menuFileExit.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Calculator1.this.windowClosed();
                }
            }
        );
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);

        setTitle("Calculator");
        setJMenuBar(menuBar);
        setSize(new Dimension(400, 400));

        // Add window listener.
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Calculator1.this.windowClosed();
                }
            }
        );
    }

    public void actionPerformed(ActionEvent e){
    	String bs = e.getActionCommand();
    	System.out.println(bs);
    	String x = jb.getText();

    	switch(bs) {
			case "1": jb.setText(x+"1");
			break;

			case "2": jb.setText(x+"2");
			break;

			case "3": jb.setText(x+"3");
			break;

			case "4": jb.setText(x+"4");
			break;

			case "5": jb.setText(x+"5");
			break;

			case "6": jb.setText(x+"6");
			break;

			case "7": jb.setText(x+"7");
			break;

			case "8": jb.setText(x+"8");
			break;

			case "9": jb.setText(x+"9");
			break;

			case "0": jb.setText(x+"0");
			break;

			case "+":
				action = "add";
				if(numberOne==0){
					numberOne = stringToDouble(jb.getText());
				}
				jb.setText("");
				break;

			case "-":
				action="subtract";
				if(numberOne==0){
					numberOne = stringToDouble(jb.getText());
				}
				jb.setText("");
				break;

			case "/":
				action = "divide";
				if(numberOne==0){
					numberOne = stringToDouble(jb.getText());
				}
				jb.setText("");
				break;

			case "*":
				action = "multiply";
				if(numberOne==0){
					numberOne = stringToDouble(jb.getText());
				}
				jb.setText("");
				break;

			case "C": jb.setText("");
					  result = 0;
					  numberOne=0;
					  numberTwo=0;
					  break;

			case"=":
					 numberTwo = Double.parseDouble(jb.getText().trim());
					 result = solveEquation(action, numberOne, numberTwo);
					 jb.setText(""+result);
					 action = "";
					 numberOne=result;
					 numberTwo=0;
					 break;

		}
    }
    /**
     * Shutdown procedure when run as an application.
     */
    protected void windowClosed() {

    	// TODO: Check if it is safe to close the application

        // Exit application.
        System.exit(0);
    }

    public Double stringToDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch(NumberFormatException e) {
			jb.setText("Invalid Number Format. Please clear and start over.");
		}

		return (double) 0;
	}

    public double solveEquation(String action, double n1, double n2) {
		switch (action) {
			case "add":
				result = n1+n2;
				break;
			case "subtract":
				result = n1-n2;
				break;
			case "multiply":
				result = n1*n2;
				break;
			case "divide":
				result = n1/n2;
				break;
		}

		return result;
	}
}
