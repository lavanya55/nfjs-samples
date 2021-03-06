package habuma;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

//@Controller
//@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksWebController {

	private final BookRepository repo;
	
	@GetMapping
	public String allBooks(Model model) {
		Iterable<Book> allbooks = repo.findAll();
		model.addAttribute("books", allbooks);
		return "booklist";
	}
}
