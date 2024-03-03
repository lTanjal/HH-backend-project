package backendproject.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendproject.Bookstore.domain.AppUser;
import backendproject.Bookstore.domain.AppUserRepository;
import backendproject.Bookstore.domain.Book;
import backendproject.Bookstore.domain.BookRepository;
import backendproject.Bookstore.domain.Category;
import backendproject.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, AppUserRepository arepository) {
	return (args) -> {
		log.info("save a couple of books");

		Category category1 = new Category("Comic fantasy");
		Category category2 = new Category("Satire");
		Category category3 = new Category("Science fiction");
			
		crepository.save(category1);
		crepository.save(category2);
		crepository.save(category3);

		brepository.save(new Book("The Color of Magic","Terry Pratchett", 2013,"9780062225672", 12.0, category2));
		brepository.save(new Book("The Light Fantastic", "Terry Pratchett", 2005,"9780060855888",20.0, category1));
		brepository.save(new Book("The Wit and Wisdom of Discworld", "Terry Pratchett", 2008,"9780061370519",24.0,category3 ));
		for (Book books : brepository.findAll()) {
			log.info(books.toString());
			
		}

		// Create users: admin/admin user/user
		AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		arepository.save(user1);
		arepository.save(user2);


	};


	}
	
}
