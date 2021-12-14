package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import datamodel.Book;
import datamodel.User;
import util.UtilDB;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class JunitTest {

	@Test
	void testUserClass()
	{
		User user = new User ("user@gmail.com", "user1", "Ali" , "Alharrasi", "password1", false);
		
		
		String email = user.getEmail();
        Assert.assertEquals("user@gmail.com", email);
        
        String username = user.getUserName();
        Assert.assertEquals("user1", username);
        
        String fname = user.getFirstName();
        Assert.assertEquals("Ali", fname);
        
        String lname = user.getLastName();
        Assert.assertEquals("Alharrasi", lname);
        
        String password = user.getPassword();
        Assert.assertEquals("password1", password);
        
        Boolean isadmin = user.isAdmin();
        Assert.assertFalse(isadmin);
        
        String ex = "User [id=" + 1 + ", userName=" + username + ", firstName=" + fname + ", lastName=" + lname
				+ ", email=" + email + ", password=" + password + ", admin=" + isadmin + "]";
        Assert.assertEquals(ex, user.toString());
		
	}
	
	@Test
	void testUserClassSecondID()
	{
		User user = new User (1, "user@gmail.com", "user1", "Ali" , "Alharrasi", "password1", false);
		
		user.setAdmin(false);
		user.setEmail("user@gmail.com");
		user.setFirstName("Ali");
		user.setId(1);
		user.setLastName("Alharrasi");
		user.setPassword("password1");
		user.setUserName("user1");
		
		int id = user.getId();
        Assert.assertEquals(1, id);
        
        String email = user.getEmail();
        Assert.assertEquals("user@gmail.com", email);
        
        String username = user.getUserName();
        Assert.assertEquals("user1", username);
        
        String fname = user.getFirstName();
        Assert.assertEquals("Ali", fname);
        
        String lname = user.getLastName();
        Assert.assertEquals("Alharrasi", lname);
        
        String password = user.getPassword();
        Assert.assertEquals("password1", password);
        
        Boolean isadmin = user.isAdmin();
        Assert.assertFalse(isadmin);
		
	}
	
	@Test
	void testUserClassDefualt()
	{
		User user = new User ();
		
		user.setAdmin(false);
		user.setEmail("user@gmail.com");
		user.setFirstName("Ali");
		user.setId(1);
		user.setLastName("Alharrasi");
		user.setPassword("password1");
		user.setUserName("user1");
		
		String email = user.getEmail();
        Assert.assertEquals("user@gmail.com", email);
        
        String username = user.getUserName();
        Assert.assertEquals("user1", username);
        
        String fname = user.getFirstName();
        Assert.assertEquals("Ali", fname);
        
        String lname = user.getLastName();
        Assert.assertEquals("Alharrasi", lname);
        
        String password = user.getPassword();
        Assert.assertEquals("password1", password);
        
        Boolean isadmin = user.isAdmin();
        Assert.assertFalse(isadmin);
		
	}
	
	@Test
	void testBook()
	{
		Book book = new  Book("booktest1", "tester1", "1111", "user", "testing1", "ist1000");
		
		Integer id = 1;
		String title = book.getTitle();
		Assert.assertEquals("booktest1", title);
		
		String author = book.getAuthor();
		Assert.assertEquals("tester1", author);
		
		String iSBN = book.getISBN();
		Assert.assertEquals("1111", iSBN);
		
		String uploader = book.getUploader();
		Assert.assertEquals("user", uploader);
		
		String major = book.getMajor();
		Assert.assertEquals("testing1", major);
		
		String bookClass = book.getBookClass();
		Assert.assertEquals("ist1000", bookClass);
		
		String res = book.toString();
		String ex = "Book [id=" + id + ", title=" + title + ", author=" + author + ", ISBN=" + iSBN + ", uploader="
				+ uploader + ", major=" + major + ", bookClass=" + bookClass + "]";
		
		Assert.assertEquals(ex, res);
		
		
	}
	
	@Test
	void testBookSecondID()
	{
		Book book = new  Book(1, "booktest1", "tester1", "1111", "user", "testing1", "ist1000");
		
		Integer id = 1;
		String title = book.getTitle();
		Assert.assertEquals("booktest1", title);
		
		String author = book.getAuthor();
		Assert.assertEquals("tester1", author);
		
		String iSBN = book.getISBN();
		Assert.assertEquals("1111", iSBN);
		
		String uploader = book.getUploader();
		Assert.assertEquals("user", uploader);
		
		String major = book.getMajor();
		Assert.assertEquals("testing1", major);
		
		String bookClass = book.getBookClass();
		Assert.assertEquals("ist1000", bookClass);
		
		
	}
	
	@Test
	void testBookDefaultID()
	{
		Book book = new  Book();
		
		book.setAuthor("tester1");
		book.setBookClass("ist1000");
		book.setId(1);
		book.setISBN("1111");
		book.setMajor("testing1");
		book.setTitle("booktest1");
		book.setUploader("user");
		
		int id = book.getId();
		Assert.assertEquals(1, id);
		
		String title = book.getTitle();
		Assert.assertEquals("booktest1", title);
		
		String author = book.getAuthor();
		Assert.assertEquals("tester1", author);
		
		String iSBN = book.getISBN();
		Assert.assertEquals("1111", iSBN);
		
		String uploader = book.getUploader();
		Assert.assertEquals("user", uploader);
		
		String major = book.getMajor();
		Assert.assertEquals("testing1", major);
		
		String bookClass = book.getBookClass();
		Assert.assertEquals("ist1000", bookClass);
		
		
	}

	
	

	
	

}
