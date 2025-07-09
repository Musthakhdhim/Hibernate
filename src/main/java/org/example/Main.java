package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1=new Student(1,"john","java");

        Configuration config=new Configuration();
        config.addAnnotatedClass(org.example.Student.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory factory= config.buildSessionFactory();
        Session session= factory.openSession();

        Transaction transaction= session.beginTransaction();

        session.persist(s1);

        transaction.commit();

//        Student s2=session.find(Student.class,1);
//        System.out.println(s2);
    }
}