package clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MailNotifier implements Observer {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ElementCollection
	private Collection<String> mails;
	
	public MailNotifier(){
		
	}
	
	public MailNotifier(Board board){
		board.addObserver(this);
		mails=new ArrayList<String>();
	}
	
	
	 
	public void addMail(String mail){
		mails.add(mail);
	}
	
	public void removeMail(String mail){
		mails.remove(mail);
	}
	 
	
	@Override
	public void update(Observable board, Object noteParam) {
		//notifico por mail...
		Note note= (Note) noteParam;
		System.out.println("nota notificada.... "+note.getPublish());
	}


}
