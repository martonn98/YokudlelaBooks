package yokudlela.books.store;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yokudlela.books.datamodel.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, String> {
    public Library findByName(String name);
    public List<Library> findAll();
    public Library save(Library menu);
    public void delete(Library menu);
}
