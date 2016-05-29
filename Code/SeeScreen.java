
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class SeeScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	SeeScreen(String str){
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
		
		JTextField title = new JTextField(str);
		title.setSize(270,30);
		title.setLocation(10,40);
		title.setEditable(false); 
		Font font = new Font("arian",Font.BOLD,15);
		title.setFont(font);
		bg.add(title);
		
		JLabel j2 = new JLabel("내용");
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
		
		JButton 투표 =  new JButton("투표");
		투표.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "투표하시겠습니까?","Vote",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(result == 0){
					Sys.rs.vote(title.getText());
					Sys.rs.max();
					Sys.rs.best();
				}
			}});
		투표.setSize(130,50);
		투표.setLocation(10,475);
		bg.add(투표);
		
		JButton 뒤로 =  new JButton("뒤로");
		뒤로.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			SeeScreen.bg.setVisible(false);
			MainScreen ns = new MainScreen();	
		}});
		뒤로.setSize(130,50);
		뒤로.setLocation(150,475);
		bg.add(뒤로);
		
		Sys.f.newScreen(bg);
	}
}