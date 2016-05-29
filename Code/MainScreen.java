import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg ;
	MainScreen(){
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
		
		JLabel j = new JLabel("검색");
		j.setSize(30,100);
		j.setLocation(10,-30);
		bg.add(j);
		
		JTextField search = new JTextField();
		search.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_ENTER){
					if(DataBase.h.containsKey(search.getText())){
						MainScreen.bg.setVisible(false);
						SeeScreen s = new SeeScreen(search.getText());
						}
					else
						JOptionPane.showMessageDialog(null, "찾을 수 없습니다!", "Warring", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		search.setSize(230,20);
		search.setLocation(50,10);
		bg.add(search);
		
		JLabel jl = new JLabel("금주의 Best");
		jl.setSize(100,100);
		jl.setLocation(10,55);
		bg.add(jl);
		
		JLabel j3 = new JLabel("공지사항");
		j3.setSize(100,100);
		j3.setLocation(10,0);
		bg.add(j3);
		
		DataBase.Gong = new JList(DataBase.listModel3);
		DataBase.Gong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.Gong.setSelectedIndex(0);
		JScrollPane Gongs = new JScrollPane(DataBase.Gong);
		Gongs.setSize(270,30);
		Gongs.setLocation(10,60);
		bg.add(Gongs);
		DataBase.Gong.clearSelection();
		
		DataBase.best = new JList(DataBase.listModel);
		DataBase.best.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.best.setSelectedIndex(0);
		javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black,1);
		javax.swing.border.Border empty = BorderFactory.createEmptyBorder(7,7,7,7);
		DataBase.best.setBorder(BorderFactory.createCompoundBorder(line,empty));
		DataBase.best.setSize(270,70);
		DataBase.best.setLocation(10,115);
		bg.add(DataBase.best);
		DataBase.best.clearSelection();
		
		JLabel j2 = new JLabel("신작 레시피");
		j2.setSize(100,100);
		j2.setLocation(10,150);
		bg.add(j2);
		
		DataBase.board = new JList(DataBase.listModel2);
		DataBase.board.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.board.setSelectedIndex(0);
		JScrollPane boards = new JScrollPane(DataBase.board);
		boards.setSize(270,220);
		boards.setLocation(10,210);
		bg.add(boards);
		JButton 조회 =  new JButton("조회");
		조회.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()&&DataBase.best.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"선택된 글이 없습니다.");
				}
				else if(DataBase.board.isSelectedIndex(DataBase.board.getSelectedIndex())){
					String s = (String) DataBase.board.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);
				}
				else if(DataBase.best.isSelectedIndex(DataBase.best.getSelectedIndex())){
					String s = (String) DataBase.best.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);	
				}
				else if(DataBase.Gong.isSelectedIndex(DataBase.Gong.getSelectedIndex())){
					String s = (String) DataBase.Gong.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);	
				}
			}
		});
		조회.setSize(60,50);
		조회.setLocation(10,450);
		bg.add(조회);
		DataBase.board.clearSelection();
		
		JButton 등록 =  new JButton("등록");
		등록.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainScreen.bg.setVisible(false);
				RegisterScreen rs = new RegisterScreen();	
			}
		});
		등록.setSize(60,50);
		등록.setLocation(80,450);
		bg.add(등록);
		
		JButton 로그아웃 =  new JButton("로그아웃");
		로그아웃.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainScreen.bg.setVisible(false);
				LoginScreen ls = new LoginScreen();	
			}
		});
		로그아웃.setSize(270,30);
		로그아웃.setLocation(10,510);
		bg.add(로그아웃);
		
		JButton 수정 =  new JButton("수정");
		수정.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"선택된 글이 없습니다.");
				}
				else{
					String resultStr = null;
					resultStr = JOptionPane.showInputDialog("비밀 번호를 입력하세요.");
					if(resultStr.equals("123")){
						int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?","Change",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(result == 0){
						MainScreen.bg.setVisible(false);
						ChangeScreen rs = new ChangeScreen((String) DataBase.board.getSelectedValue());	
					}
				}
					else{
						JOptionPane.showMessageDialog(null,"비밀번호 오류","Warring",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		수정.setSize(60,50);
		수정.setLocation(150,450);
		bg.add(수정);
		
		JButton 삭제 =  new JButton("삭제");
		삭제.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"선택된 글이 없습니다.");
				}
				else{
					String resultStr = null;
					resultStr = JOptionPane.showInputDialog("비밀 번호를 입력하세요.");
					if(resultStr.equals("123")){
						int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","Delete",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(result == 0){
						Sys.db.Delete((String) DataBase.board.getSelectedValue());
						int index = DataBase.board.getSelectedIndex();
						DataBase.listModel2.remove(index);
						if(DataBase.listModel2.getSize()==0){ 
						    삭제.setEnabled(false);
						   }
						   if(index == DataBase.listModel2.getSize()){
						    index--;  
						   }   
						   DataBase.board.setSelectedIndex(index);
						   DataBase.board.ensureIndexIsVisible(index);
					}
				}
					else{
						JOptionPane.showMessageDialog(null,"비밀번호 오류","Warring",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		삭제.setSize(60,50);
		삭제.setLocation(220,450);
		bg.add(삭제);
		
		Sys.f.newScreen(bg);
	}
}

