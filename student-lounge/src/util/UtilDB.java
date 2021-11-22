/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.Book;
import datamodel.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<Book> listBooks() {
	      List<Book> resultList = new ArrayList<Book>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> books = session.createQuery("FROM Book").list();
	         for (Iterator<?> iterator = books.iterator(); iterator.hasNext();) {
	            Book book = (Book) iterator.next();
	            resultList.add(book);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
	
	
	public static Book getBookById(String id) {
		Book book = new Book();

		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			List<?> books = session.createQuery(String.format("FROM Book where id= '%s'", id)).list();
			book = (Book) books.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return book;
	}

	public static List<Book> listBooks(String keyword) {
		List<Book> resultList = new ArrayList<Book>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println((Book) session.get(Book.class, 1));
			List<?> books = session.createQuery("FROM Book").list();
			for (Iterator<?> iterator = books.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				if (book.getTitle().contains(keyword) || book.getBookClass().contains(keyword)
						|| book.getMajor().contains(keyword) || book.getISBN().contains(keyword)) {
					resultList.add(book);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<Book> listUserBooks(String keyword) {
		List<Book> resultList = new ArrayList<Book>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println((Book) session.get(Book.class, 1));
			List<?> books = session.createQuery("FROM Book").list();
			for (Iterator<?> iterator = books.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				if (book.getUploader().contains(keyword)) {
					resultList.add(book);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<User> getUsers(String keyword, String format) {
		List<User> resultList = new ArrayList<User>();
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Users = session.createQuery(String.format("FROM User where %s= '%s'", format, keyword)).list();
			for (Iterator<?> iterator = Users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				resultList.add(user);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	
	public static void removeBook(String id) {

		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			session.createQuery(String.format("DELETE Book where id= %s", id)).executeUpdate();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void editUser(String email, String keyword, String format) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();

			String res = String.format("UPDATE User set " + "%s = '%s' " + "where EMAIL = '%s'",
					format, keyword, email);

			session.createQuery(res).executeUpdate();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void editBook(String idformat ,String idkeyword, String keyword, String format) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();

			String res = String.format("UPDATE Book set %s= '%s' where %s= '%s'",
					format, keyword, idformat, idkeyword);

			session.createQuery(res).executeUpdate();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createBooks(String title, String author, String iSBN, String uploader, String major,
			String bookClass) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Book(title, author, iSBN, uploader, major, bookClass));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createUser(String email, String userName, String firstName, String lastName, String password,
			boolean admin) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new User(email, userName, firstName, lastName, password, admin));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
