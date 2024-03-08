package backendproject.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import backendproject.Bookstore.domain.Book;
import backendproject.Bookstore.domain.BookRepository;
import backendproject.Bookstore.domain.Category;
import backendproject.Bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BookJPATest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @Test
        public void createNewBook() {
            Category categoryTest = new Category("TESTcategory");
            crepository.save(categoryTest);
            Book testBook = new Book("test BookTitle","test Author",2222,"0000000",222.22,categoryTest);
            brepository.save(testBook);
            assertThat(testBook.getId()).isNotNull();
             }   

        @Test
        public void deleteNewBook() {
            List<Book> books = brepository.findByTitle("The Color of Magic");
            Book testBook = books.get(0);
            brepository.delete(testBook);
            List<Book> newBooks = brepository.findByTitle("The Color of Magic");
            assertThat(newBooks).hasSize(0);
        }


}
