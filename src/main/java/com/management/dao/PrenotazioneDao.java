package com.management.dao;

import com.management.model.Prenotazione;
import com.management.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PrenotazioneDao {


    public void saveReservation(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(prenotazione);
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
     * Update Prenotazione
     *
     * @param prenotazione
     */
    public void updateReservation(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(prenotazione);
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
     * Delete Veicolo
     *
     * @param id
     */
    public void deleteReservation(int id) {

        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Prenotazione prenotazione = session.get(Prenotazione.class, id);
            if (prenotazione != null) {
                session.delete(prenotazione);
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

    public Prenotazione getReservationById(int id) {

        Transaction transaction = null;
        List<Prenotazione> prenotazioni = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Prenotazione u where u.id = :id");
            query.setParameter("id", id);
            prenotazioni = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazioni.get(0);
    }

    public List<Prenotazione> getReservationByUserId(int id) {

        Transaction transaction = null;
        List<Prenotazione> prenotazioni = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Prenotazione p where p.user.id = :id");
            query.setParameter("id", id);
            prenotazioni = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazioni;
    }

    public List<Prenotazione> getPendingReservations() {

        Transaction transaction = null;
        List<Prenotazione> prenotazioni = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Prenotazione p where p.approvata= :approved");
            query.setParameter("approved", false);
            prenotazioni = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazioni;
    }

    /**
     * Get all Prenotazioni
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Prenotazione> getAllReservations() {

        Transaction transaction = null;
        List<Prenotazione> prenotazioni = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            prenotazioni = session.createQuery("from Prenotazione ").getResultList();
            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazioni;
    }


    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}