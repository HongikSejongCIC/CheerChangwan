
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	RegisterScreen(){
		Image img = null;
		icon = new ImageIcon("메인.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300,575);
		bg.setLayout(null);
		
		JLabel jl = new JLabel("제목");
		jl.setSize(100,100);
		jl.setLocation(10,-30);
		bg.add(jl);
		
		JTextField title = new JTextField();
		title.setSize(270,30);
		title.setLocation(10,40);
		Font font = new Font("arian",Font.BOLD,15);
		title.setFont(font);
		bg.add(title);
		
		JLabel j2 = new JLabel("내용");
		j2.setSize(100,100);
		j2.setLocation(10,40);
		bg.add(j2);
		
		JTextArea content = new JTextArea();
		javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black,1);
		javax.swing.border.Border empty = BorderFactory.createEmptyBorder(7,7,7,7);
		content.setBorder(BorderFactory.createCompoundBorder(line,empty));
		JScrollPane contentj = new JScrollPane(content);
		contentj.setSize(270,365);
		contentj.setLocation(10,100);
		bg.add(contentj);
		
		JButton 등록 =  new JButton("등록");
		등록.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String t = title.getText();
				String c = content.getText();
				DataBase.listModel2.addElement(t);
				Sys.db.Save(t,c);
				t="";
				c="";
				RegisterScreen.bg.setVisible(false);
				MainScreen ns = new MainScreen();
			}});
		등록.setSize(130,50);
		등록.setLocation(10,475);
		bg.add(등록);
		
		JButton 뒤로 =  new JButton("뒤로");
		뒤로.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			RegisterScreen.bg.setVisible(false);
			MainScreen ns = new MainScreen();	
		}});
		뒤로.setSize(130,50);
		뒤로.setLocation(150,475);
		bg.add(뒤로);
		
		Sys.f.newScreen(bg);
	}
}