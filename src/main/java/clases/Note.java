package clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Note {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Boolean canComment;
	private Date publishDate;
	
	@Transient
	private DateFormat format;
	

	@ElementCollection
	private Collection<String> resources;
	
	@ManyToMany
	@ElementCollection
	private Collection<Comment> comments;
	private String publish;
	
	
	@ManyToOne
	@JoinColumn(name = "authorId")
	private User author;
	
	protected Boolean down;
	
	public Note(){
		format= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // yyyy/MM/dd
	}
	
	//elegir si dejar en el cnstructor el date o no (lo mismo para comment)
	public Note(Boolean canCommentParam, Date publishDateParam, User authorParam, String publishParam){
		canComment=canCommentParam;
		author=authorParam;
		publishDate=publishDateParam;
		resources=new ArrayList<String>();
		comments=new ArrayList<Comment>();
		publish=publishParam;
		format= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // yyyy/MM/dd
		down=false;
	}


	public String getPublish() {
		return publish;
	}


	public void setPublish(String publishParam) {
		publish = publishParam;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User authorParam) {
		author = authorParam;
	}


	public Collection<Comment> getComments() {
		return comments;
	}


	public void addComment(Comment commentParam) {
		comments.add(commentParam);
	}


	public void addRecurse(String resourceParam) {
		resources.add(resourceParam);
	}


	public Collection<String> getResources() {
		return resources;
	}


	public void setRecurse(String resourceParam) {
		resources.add(resourceParam);
	}


	public Boolean getCanComment() {
		return canComment;
	}


	public void setCanComment(Boolean canComment) {
		this.canComment = canComment;
	}


	public String getPublishDate() {
		return format.format(publishDate);
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	public DateFormat getFormat() {
		return format;
	}


	public void setFormat(DateFormat format) {
		this.format = format;
	}
	
	
}
