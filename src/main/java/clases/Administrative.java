package clases;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrative extends User {


	
	@OneToMany
	@ElementCollection
	private Collection<Board> permissionsList;
	
	public Administrative(String nameParam, String passParam,Config config,String mailParam) {
		super(nameParam, passParam,config,mailParam);
		permissionsList=new ArrayList<Board>();
		type="administrative";
	}
	
	public Administrative(){
		type="administrative";
	}
	
	public Collection<Board> getPermissionsList() {
		return permissionsList;
	}

	public void addPermission(Board permissionParam) {
		permissionsList.add(permissionParam);
	}
	
	public Boolean canPublish(Board board){
		
		Integer result=((ArrayList)permissionsList).indexOf(board);
		if(result==-1){
			return false;
		}else{
			return true;
		}
	}
	
	public void publish(Note note,Board board){
	   board.addNote(note);
	}

}
