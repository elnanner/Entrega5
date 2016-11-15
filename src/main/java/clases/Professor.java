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
public class Professor extends User {
		


	@OneToMany
	@ElementCollection
	private Collection<Board> permissionsList;
	
	public Collection<Board> getPermissionsList() {
		return permissionsList;
	}

	public Professor(){
		type="doc";
	}
	
	public void addPermission(Board permissionParam) {
		permissionsList.add(permissionParam);
	}

	public Professor(String nameParam, String passParam,Config config,String mailParam) {
		super(nameParam, passParam,config,mailParam);
		permissionsList=new ArrayList<Board>();
		type="doc";
	}

}
