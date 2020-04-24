package com.management.dao;

import com.management.model.User;
import com.management.util.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
@Repository
public class UserDao {

    /**
     * Save User
     * @param user
     */
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update User
     * @param user
     */
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete User
     * @param id
     */
    public void deleteUser(int id) {

        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get User By ID
     * @param cf
     * @return
     */
    public User getUserByDB(String cf) {

        Transaction transaction = null;
        List < User > listOfUser = null;
        User user = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from User u where u.cf = :cf");
            query.setParameter("cf", cf);
            listOfUser = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(listOfUser.size() > 0) {
            return listOfUser.get(0);
        }else {
            return null;
        }
    }

    public User getUserById(int id) {

        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from User u where u.id = :id");
            query.setParameter("id", id);
            listOfUser = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser.get(0);
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < User > getAllUser() {

        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfUser = session.createQuery("from User").getResultList();
            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }

    public boolean Validate(String username, String pass){
        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User u where u.password = :pass and u.cf = :username");
            query.setParameter("pass", pass);
            query.setParameter("username", username);
            listOfUser = query.list();
            // commit transaction
            //transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(listOfUser.isEmpty())
            return false;
        else
            return true;
    }

    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}