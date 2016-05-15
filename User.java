public class User {
	String id;
	String pw;
	Board B = new Board();
	RankingSystem R = new RankingSystem();
	
	boolean 레시피등록(String title, String content){
		if(B.레시피등록(title,content)==true)
			return true;
		else
			return false;
	}
	
	boolean 레시피수정(String pw,String title, String content){
		if(B.비밀번호확인(pw,id)==true){
			if(B.레시피수정(pw,title,content)==true)
				return true;
			else
				return false;
		}
		else
			return false;
		
	}
	
	Board 레시피조회(String title, String content){
		B.레시피조회();
		return null;
		
	}
	
	boolean 레시피삭제(){
		if(B.비밀번호확인(pw,id)==true)
			if(B.레시피삭제(pw)==true)
				return true;
			else
				return false;
		else return false;
	}
	
	Board 공지사항조회(String title, String content){
		B.공지사항조회(title,content);
		return null;
		
	}
	Board 게시판내검색(String keyward){
		if(B.게시판내검색(keyward)==true)
			return B.content;
		else
		return null;
		
	}
	boolean 투표(){
		R.투표(id);
		return false;
		
	}
}
