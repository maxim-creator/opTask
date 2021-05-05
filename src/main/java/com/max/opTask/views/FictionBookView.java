package com.max.opTask.views;

import com.max.opTask.models.FictionBook;
import com.max.opTask.models.FictionBookType;
import com.max.opTask.models.TechnicalBook;
import com.max.opTask.repositories.FictionBookRepository;

import java.util.List;
import java.util.Scanner;

public class FictionBookView implements GenericView <FictionBook, Integer>{
  FictionBookRepository repository = new FictionBookRepository();
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
    public FictionBook Update() {
        System.out.println("enter id");
        int i = scanner.nextInt();
        FictionBook book = getBookWithoutId();
        book.setId(i);
        return repository.update(book);
    }

    @Override
    public FictionBook save() {
        return repository.save(getBookWithoutId());
    }

    public FictionBook getBookWithoutId(){
        FictionBook book = new FictionBook();
        System.out.println("enter book name");
        book.setName(scanner.next());
        System.out.println("enter author");
        book.setAuthor(scanner.next());
        System.out.println("enter publisher");
        book.setPublisher(scanner.next());
        System.out.println("enter pages");
        book.setPages(scanner.nextInt());
        System.out.println("1 - roman, 2 - piesa, 3 - stix");
        switch (scanner.nextInt()){
            case 1:
                book.setFictionBookType(FictionBookType.ROMAN);
                break;
            case 2:
                book.setFictionBookType(FictionBookType.PIESA);
                break;
            case 3:
                book.setFictionBookType(FictionBookType.STIX);
                break;
        }
        return book;
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        repository.deleteById(scanner.nextInt());
    }
}
