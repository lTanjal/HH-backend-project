package backendproject.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backendproject.Bookstore.domain.Book;
import backendproject.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping(value = {"/booklist" })
	public String bookList(Model model) {
        model.addAttribute("books",repository.findAll());
		return "booklist";
	}


}
