
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class GSeeScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	GSeeScreen(String str){
		Image img = null;
		icon = new ImageIcon("G.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300,575);
		bg.setLayout(null);
		
		JLabel jl = new JLabel("力格");
		jl.setSize(100,100);
		jl.setLocation(10,-30);
		bg.add(jl);
		
		JTextField title = new JTextField(str);
		title.setSize(270,30);
		title.setLocation(10,40);
		title.setEditable(false); 
		Font font = new Font("arian",Font.BOLD,15);
		title.setFont(font);
		bg.add(title);
		
		JLabel j2 = new JLabel("郴侩");
		j2.setSize(100,100);
		j2.setLocation(10,40);
		bg.add(j2);
		
		String str2 = DataBase.h.get(str);
		JTextArea content = new JTextArea(str2);
		javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black,1);
		javax.swing.border.Border empty = BorderFactory.createEmptyBorder(7,7,7,7);
		content.setEditable(false); 
		content.setBorder(BorderFactory.createCompoundBorder(line,empty));
		JScrollPane contentj = new JScrollPane(content);
		contentj.setSize(270,365);
		contentj.setLocation(10,100);
		bg.add(contentj);
		
		
		
		JButton 第肺 =  new JButton("第肺");
		第肺.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GSeeScreen.bg.setVisible(false);
			GMainScreen ns = new GMainScreen();	
		}});
		第肺.setSize(270,50);
		第肺.setLocation(10,475);
		bg.add(第肺);
		
		Sys.f.newScreen(bg);
	}
}