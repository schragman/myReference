package beans;

import java.util.List;

import javax.ejb.Remote;

import entities.Book;

@Remote
public interface BookBeanRemote {

	List<Book> findBooks();
	Book findBookById(Long id);
	Book createBook(Book book);
	void deleteBook(Book book);
	Book updateBook(Book book);

}
