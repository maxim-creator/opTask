package com.max.opTask.repositories;

import com.max.opTask.models.Book;
import com.max.opTask.models.ChildBook;
import com.max.opTask.models.TechnicalBook;
import org.hibernate.Session;

import java.util.List;

public class ChildBookRepository implements GenericRepository<ChildBook, Integer> {
    private Session session;

    public ChildBookRepository(){
        session = SessionBuilder.getSession();
    }


    @Override
    public ChildBook save(ChildBook object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public ChildBook update(ChildBook object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public ChildBook getById(Integer id) {
        return session.get(ChildBook.class, id);
    }

    @Override
    public List<Book> getAll() {
        return session.createQuery("from Book ").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        session.beginTransaction();
        ChildBook book = new ChildBook();
        book.setId(id);
        session.delete(book);
        session.getTransaction().commit();
    }
}
