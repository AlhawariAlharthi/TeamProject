package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BookTable")
public class Book {
	
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id") // specify the column name. Without it, it will use method name
		private Integer id;
		

	@Column(name = "title")
	   private String title;

	   
	   @Column(name = "author")
	   private String author;
	   
	  
	   @Column(name = "ISBN")
	   private String ISBN;
	   
	   @Column(name = "uploader")
	   private String uploader;
	   
	   @Column(name = "major")
	   private String major;
	   
	   @Column(name = "bookClass")
	   private String bookClass;

	public Book(Integer id, String title, String author, String iSBN, String uploader, String major,
			String bookClass) {
		this.id = id;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.uploader = uploader;
		this.major = major;
		this.bookClass = bookClass;
	}
	
	public Book( String title, String author, String iSBN, String uploader, String major,
			String bookClass) {
		
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.uploader = uploader;
		this.major = major;
		this.bookClass = bookClass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getBookClass() {
		return bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", uploader="
				+ uploader + ", major=" + major + ", bookClass=" + bookClass + "]";
	}

	   
	}

