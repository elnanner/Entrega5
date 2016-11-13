package clases;


import java.util.HashMap;

import java.util.Map;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class SuscriptionManager {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@Cascade({CascadeType.PERSIST,CascadeType.SAVE_UPDATE, CascadeType.MERGE})
	 private  Map<Board,MailNotifier> mailNotifiers;
    //private  Map<MailNotifier> mailNotifiers;
	
	
/*	@OneToMany
	@Column(nullable=false)
	 private  ArrayList<Board> boards;*/
	
    private static SuscriptionManager instance = null; //singleton
    

    
    protected SuscriptionManager() {
    	mailNotifiers=new HashMap<Board,MailNotifier>();
    	//boards=new ArrayList<Board>();
     }
    
    public static SuscriptionManager getInstance() {
        if(instance == null) {
           instance = new SuscriptionManager();
        }
        return instance;
     }
    
    
    public void addMailNotifier(String mail,Board board){
    	if(! mailNotifiers.containsKey(board)){
    		mailNotifiers.put(board,new MailNotifier(board));
    		//mailNotifiers.add(new MailNotifier(board));
        }
    	mailNotifiers.get(board).addMail(mail); 
    	
    	/*if(! boards.contains(board)){
    		boards.add(board);
    		mailNotifiers.add(new MailNotifier(board));
        }
    	mailNotifiers.get(boards.indexOf(board)).addMail(mail);  */  
    }
    
    public void removeMailNotifier(String mail,Board board){
    	 if(mailNotifiers.containsKey(board)){
    		 mailNotifiers.get(board).removeMail(mail);
    	 }
    	 
    	/*
    	 if(boards.contains(board)){
    		 mailNotifiers.get(boards.indexOf(board)).removeMail(mail);
         }
         */
    	
    }
	
}
