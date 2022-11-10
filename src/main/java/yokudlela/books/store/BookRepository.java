package yokudlela.books.store;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yokudlela.books.datamodel.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public Book findByName(String pName);
    public List<Book> findAll();
    public Book save(Book pTable);
    public void delete(Book pFood);
}