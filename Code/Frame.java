import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
	static Container scr;
	Frame(){
		setTitle("Cooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scr = getContentPane();
		scr.setLayout(null);
		LoginScreen ls = new LoginScreen();
		setSize(300,575);
		setVisible(true);
		setResizable(false);
	}
	void newScreen(Container nct){
		scr.add(nct);
	}
}
