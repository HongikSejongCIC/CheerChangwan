
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class RegiScreen extends JFrame{
	static JTextField id;
	static JPasswordField pw;
	static JPanel bg;
	ImageIcon icon;
	static JScrollPane scrollPane;
	
	RegiScreen(){
		Image img = null;
		icon = new ImageIcon("로그인.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300, 575);
		bg.setLayout(null);
		regi r = new regi();
		JButton login = new JButton("가입");
		login.addActionListener(r);
		login.setLocation(180, 400);
		login.setSize(70, 50);
		bg.add(login);
		
		JButton 뒤로 =  new JButton("뒤로");
		뒤로.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			RegiScreen.bg.setVisible(false);
			LoginScreen ls = new LoginScreen();
		}});
		뒤로.setSize(190,25);
		뒤로.setLocation(60,450);
		bg.add(뒤로);
		
		id = new JTextField();
		pw = new JPasswordField();
		id.setHorizontalAlignment(JTextField.RIGHT);
		pw.setHorizontalAlignment(JPasswordField.RIGHT);
		id.setSize(120, 25);
		pw.setSize(120, 25);
		id.setLocation(60, 400);
		pw.setLocation(60, 425);
		bg.add(id);
		bg.add(pw);
		JLabel idl = new JLabel("   ID");
		JLabel pwl = new JLabel("PW");
		idl.setSize(50, 25);
		pwl.setSize(50, 25);
		idl.setLocation(30, 400);
		pwl.setLocation(30, 425);

		bg.add(idl);
		bg.add(pwl);
		Frame.scr.add(bg);
	}
}

class regi  implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String id = RegiScreen.id.getText();
		String pw = RegiScreen.pw.getText();
		DataBase.user.put(id, pw);
		RegiScreen.bg.setVisible(false);
		LoginScreen ls = new LoginScreen();
	}
}