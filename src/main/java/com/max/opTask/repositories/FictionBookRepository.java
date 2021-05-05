package com.max.opTask.repositories;

import com.max.opTask.models.Book;
import com.max.opTask.models.FictionBook;
import com.max.opTask.models.TechnicalBook;
import org.hibernate.Session;

import java.util.List;

public class FictionBookRepository implements GenericRepository<FictionBook, Integer>{
   private Session session;

   public FictionBookRepository(){
       session = SessionBuilder.getSession();
   }

    @Override
    public FictionBook save(FictionBook object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public FictionBook update(FictionBook object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public FictionBook getById(Integer id) {
        return session.get(FictionBook.class, id);
    }

    @Override
    public List<Book> getAll() {
        return session.createQuery("from Book ").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        session.beginTransaction();
        FictionBook book = new FictionBook();
        book.setId(id);
        session.delete(book);
        session.getTransaction().commit();
    }
}
