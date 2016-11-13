package clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Board extends Observable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	
	@ManyToMany
	@ElementCollection
	//@JoinTable(name="board_board",joinColumns=
	//@JoinColumn(name="idBoardFather", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="idBoardChild", referencedColumnName="id"))
	private Collection<Board> boardList;
	@ManyToMany
	@ElementCollection
	//@JoinTable(name="board_note",joinColumns=
	//@JoinColumn(name="idBoard", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="idNote", referencedColumnName="id"))
	private Collection<Note> noteList;
	
	public Board(){
		
	}
	
	public Board(String nameParam, String descriptionParam) {
		name = nameParam;
		description = descriptionParam;
		boardList = new ArrayList<Board>();
		noteList = new ArrayList<Note>();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void addBoard(Board boardParam){
		boardList.add(boardParam);
	}
	
	public void removeBoard(Board boardParam){
		boardList.remove(boardParam);
	}
	
	public Collection<Board> getBoardList() {
		return boardList;
	}


	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}


	public Collection<Note> getNoteList() {
		return noteList;
	}


	public void addNote(Note noteParam) {
		noteList.add(noteParam);
		setChanged();
	    notifyObservers(noteParam);
	}
	
	public void removeNote(Note noteParam) {
		noteList.remove(noteParam);
	}
	
	
}

