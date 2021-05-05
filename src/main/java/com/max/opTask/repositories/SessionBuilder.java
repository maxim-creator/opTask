package com.max.opTask.repositories;

import com.max.opTask.models.ChildBook;
import com.max.opTask.models.FictionBook;
import com.max.opTask.models.TechnicalBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionBuilder {

    private static Session session;

    private SessionBuilder() {
    }

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(TechnicalBook.class);
        configuration.addAnnotatedClass(FictionBook.class);
        configuration.addAnnotatedClass(ChildBook.class);

        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        if(session == null)
            openSession();
        return session;
    }

    public static Session refreshSession(){
        session.close();
        session = buildSessionFactory().openSession();
        return session;
    }

    public static void openSession(){
        session = buildSessionFactory().openSession();
    }

    public static void closeSession(){
        session.close();
    }
}
