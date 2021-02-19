package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController{
@Autowired
private BookService bookService;

public BookController(BookService bookService){
    this.bookService = bookService;
}

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public @ResponseBody
    List<Book> getList() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
    bookService.add(book);
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}

