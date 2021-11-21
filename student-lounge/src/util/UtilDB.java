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
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			List<?> Books = session.createQuery("FROM Book").list();
			for (Iterator<?> iterator = Books.iterator(); iterator.hasNext();) {
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
						|| book.getMajor().contains(keyword)) {
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
}
