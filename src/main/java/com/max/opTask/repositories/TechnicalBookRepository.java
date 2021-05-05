package com.max.opTask.repositories;

import com.max.opTask.models.Book;
import com.max.opTask.models.TechnicalBook;
import org.hibernate.Session;

import java.util.List;

public class TechnicalBookRepository implements GenericRepository<TechnicalBook, Integer> {
    private Session session;

    public TechnicalBookRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public TechnicalBook save(TechnicalBook object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public TechnicalBook update(TechnicalBook object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public TechnicalBook getById(Integer id) {
        return session.get(TechnicalBook.class, id);
    }

    @Override
    public List<Book> getAll() {
        return session.createQuery("from Book").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        session.beginTransaction();
        TechnicalBook book = new TechnicalBook();
        book.setId(id);
        session.delete(book);
        session.getTransaction().commit();
    }
}
