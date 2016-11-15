package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends User {

	
    public Student(){
    	type="alu";
    }
    
	public Student(String nameParam, String passParam, Config config, String mailParam) {
		super(nameParam, passParam,config,mailParam);
		type="alu";
	}

}
