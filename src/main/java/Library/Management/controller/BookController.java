package Library.Management.controller;


import Library.Management.entity.Books;
import Library.Management.services.BookService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService serb;

    public BookController(BookService serb) {
        this.serb = serb;
    }

    //  Finding all books

    @RequestMapping(value = "/allbook", method = RequestMethod.GET)
    public List<Books> getAll()
    {
        return serb.getAllBook();
    }

    @RequestMapping(value = "/findbybid/{id}", method = RequestMethod.GET)
    public Optional<Books> getByBookid(@PathVariable int id)
    {
        return serb.gettingByBId(id);
    }

    //         Adding new Book

    @PostMapping(value = "/addbook" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addbook(@RequestBody JsonNode formNode )
    {
        return serb.addingNewBook(formNode);
    }

    //         update book

    @PutMapping("/updatebook/{id}")
    public ResponseEntity<Object> updateBooks(@PathVariable int id, @Valid @RequestBody JsonNode formNode) {

        return serb.updateBook(id , formNode);

    }
    //        Delete User by bid

    @DeleteMapping(value="/deletebook/{id}")
    public ResponseEntity<Object> deletebook(@PathVariable int id)
    {

        return serb.deletebook(id);
    }




    // serb.authBookService(String str);

}
