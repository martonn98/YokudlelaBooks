package yokudlela.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yokudlela.books.datamodel.Library;
import yokudlela.books.store.BookRepository;
import yokudlela.books.store.LibraryRepository;

@Service
public class LibraryService {
    @Autowired
    BookRepository foodRep;
    @Autowired
    LibraryRepository menuRep;


    public List<Library> getAll(){
        List<Library> allAvailable = menuRep.findAll();
        return allAvailable;
    }
}
