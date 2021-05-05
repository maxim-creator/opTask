package com.max.opTask.views;

import com.max.opTask.models.TechnicalBook;
import com.max.opTask.repositories.TechnicalBookRepository;

import java.util.List;
import java.util.Scanner;

public class TechnicalBookView implements GenericView<TechnicalBook, Integer>{
    TechnicalBookRepository repository = new TechnicalBookRepository();
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
    public TechnicalBook Update() {
        System.out.println("enter id");
        int i = scanner.nextInt();
        TechnicalBook book = getBookWithoutId();
        book.setId(i);
        return repository.update(book);
    }

    @Override
    public TechnicalBook save() {
        return repository.save(getBookWithoutId());
    }

    public TechnicalBook getBookWithoutId(){
        TechnicalBook book = new TechnicalBook();
        System.out.println("enter book name");
        book.setName(scanner.next());
        System.out.println("enter author");
        book.setAuthor(scanner.next());
        System.out.println("enter publisher");
        book.setPublisher(scanner.next());
        System.out.println("enter pages");
        book.setPages(scanner.nextInt());
        System.out.println("is book russian? y - yes, enter - no");
        book.setRussian(scanner.hasNext());
        return book;
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        repository.deleteById(scanner.nextInt());
    }
}
