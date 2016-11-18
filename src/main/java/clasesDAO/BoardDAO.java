package clasesDAO;

import clases.Board;

public interface BoardDAO extends GenericDAO<Board> {

	public Board getBoardCall(String name);
	public Board getBoardUrl(String url);
	//public Board getBoardByName(String name){
	//public Board getIdBoardByName(String name){
	
	
}
