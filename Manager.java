
public class Manager {
	String id;
	String pw;
	String content;
	String title;
	Board B = new Board();
	RankingSystem R = new RankingSystem();

	
	Board ����������ȸ(String title, String content){
		B.����������ȸ(title,content);
		return null;
		
	}
	
	Board �Խ��ǳ��˻�(String keyward){
		if(B.�Խ��ǳ��˻�(keyward)==true)
			return B.content;
		else
		return null;
		
	}
	
	boolean �������׵��(String title, String content){
		if(B.�������׵��(title,content))
			return true;
		else
		return false;
		
	}
	boolean �������׼���(){
		if(B.��й�ȣȮ��(pw, id))
			if(B.�������׼���(pw,title,content))
				return true;
			else return false;
		return false;
		
	}
	boolean �������׻���(){
		if(B.��й�ȣȮ��(pw, id))
			if(B.�������׻���(pw,id))
				return true;
			else return false;
		return false;
		
	}
	
	Board ��������ȸ(String title, String content){
		B.��������ȸ();
		return null;
		
	}
	
	boolean �����ǻ���(){
		if(B.��й�ȣȮ��(pw,id)==true)
			if(B.�����ǻ���(pw)==true)
				return true;
			else
				return false;
		else return false;
	}
	
	boolean �Ŵ���üũ(String id,String pw){
		if(this.id == id && this.pw == pw)
			return true;
		else
			return false;
	}
	RankingSystem ����(){
		return R.max;
	}
}
