
public class Manager {
	String id;
	String pw;
	String content;
	String title;
	Board B = new Board();
	RankingSystem R = new RankingSystem();

	
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
	
	boolean 공지사항등록(String title, String content){
		if(B.공지사항등록(title,content))
			return true;
		else
		return false;
		
	}
	boolean 공지사항수정(){
		if(B.비밀번호확인(pw, id))
			if(B.공지사항수정(pw,title,content))
				return true;
			else return false;
		return false;
		
	}
	boolean 공지사항삭제(){
		if(B.비밀번호확인(pw, id))
			if(B.공지사항삭제(pw,id))
				return true;
			else return false;
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
	
	boolean 매니저체크(String id,String pw){
		if(this.id == id && this.pw == pw)
			return true;
		else
			return false;
	}
	RankingSystem 순위(){
		return R.max;
	}
}
