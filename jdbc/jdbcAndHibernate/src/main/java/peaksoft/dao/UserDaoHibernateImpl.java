package peaksoft.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        String dropTableQuery = "drop table users";
        session.createNativeQuery(dropTableQuery).executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("table is deleted!!!");

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);
        session.getTransaction().commit();
        session.close();

        System.out.println(user + " is saved");
    }

    @Override
    public void removeUserById(long id) {

        Session session = Util.getSession().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);

            if (user != null){
                System.out.println(user + " is deleted");
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;

    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createNativeQuery("delete from users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
