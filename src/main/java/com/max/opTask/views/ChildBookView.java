package com.max.opTask.views;

import com.max.opTask.models.ChildBook;
import com.max.opTask.models.ChildBookType;
import com.max.opTask.models.TechnicalBook;
import com.max.opTask.repositories.ChildBookRepository;
import com.max.opTask.repositories.TechnicalBookRepository;

import java.util.List;
import java.util.Scanner;

public class ChildBookView implements GenericView<ChildBook, Integer> {
    ChildBookRepository repository = new ChildBookRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void printAll() {
        List books = repository.getAll();
        if(books != null)
            books.forEach(x-> System.out.println(x));
        else
            System.out.println("no saved books");
    }

    @Override
    public ChildBook Update() {
        System.out.println("enter id");
        int i = scanner.nextInt();
        ChildBook book = new ChildBook();
        book.setId(i);
        return repository.update(book);
    }

    @Override
    public ChildBook save() {
        return repository.save(getBookWithoutId());
    }

    public ChildBook getBookWithoutId(){
        ChildBook book = new ChildBook();
        System.out.println("enter book name");
        book.setName(scanner.next());
        System.out.println("enter author");
        book.setAuthor(scanner.next());
        System.out.println("enter publisher");
        book.setPublisher(scanner.next());
        System.out.println("enter pages");
        book.setPages(scanner.nextInt());
        System.out.println("1 - skazka, 2 - stix");
        if(scanner.nextInt() == 1)
            book.setChildBookType(ChildBookType.SKAZKA);
        else
            book.setChildBookType(ChildBookType.STIX);
        return book;
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        repository.deleteById(scanner.nextInt());
    }
}
