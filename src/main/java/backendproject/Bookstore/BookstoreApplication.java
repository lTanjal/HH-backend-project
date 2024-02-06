package backendproject.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendproject.Bookstore.domain.Book;
import backendproject.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
	return (args) -> {
		log.info("save a couple of books");
		repository.save(new Book("The Color of Magic","Terry Pratchett", 2013,"9780062225672", 12.0));
		repository.save(new Book("The Light Fantastic", "Terry Pratchett", 2005,"9780060855888",20.0));
		repository.save(new Book("The Wit and Wisdom of Discworld", "Terry Pratchett", 2008,"9780061370519",24.0));
		for (Book books : repository.findAll()) {
			log.info(books.toString());
			
		}
	};


	}
	
}
