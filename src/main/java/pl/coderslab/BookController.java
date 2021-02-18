package pl.coderslab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {



    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("/")
    public List<Book> mockBook(){
        MemoryBookService memoryBookService = new MemoryBookService();
        return memoryBookService.MockBookService();
    }
}

