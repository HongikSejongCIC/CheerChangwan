public class User {
	String id;
	String pw;
	Board B = new Board();
	RankingSystem R = new RankingSystem();
	
	boolean �����ǵ��(String title, String content){
		if(B.�����ǵ��(title,content)==true)
			return true;
		else
			return false;
	}
	
	boolean �����Ǽ���(String pw,String title, String content){
		if(B.��й�ȣȮ��(pw,id)==true){
			if(B.�����Ǽ���(pw,title,content)==true)
				return true;
			else
				return false;
		}
		else
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
	boolean ��ǥ(){
		R.��ǥ(id);
		return false;
		
	}
}
