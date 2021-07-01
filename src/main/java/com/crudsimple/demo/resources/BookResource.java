package com.crudsimple.demo.resources;

import com.crudsimple.demo.entify.Book;
import com.crudsimple.demo.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//já transforma em Json
//identificador da classe no http
@RequestMapping("/books")
public class BookResource {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> listarLivros() {
        return this.bookRepository.findAll();

    }

    @GetMapping("/{id}")
    public Book listarLivrosId(@PathVariable Long id) {
        return this.bookRepository.findById(id).get();

    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return this.bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        Book bookDataBase = this.bookRepository.findById(id).get();
        BeanUtils.copyProperties(book, bookDataBase, "id", "createdAt");
        return this.bookRepository.save(bookDataBase);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        this.bookRepository.deleteById(id);

    }
}
