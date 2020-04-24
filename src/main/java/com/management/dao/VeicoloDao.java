package com.management.dao;

import com.management.model.Veicolo;
import com.management.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class VeicoloDao {


    public void saveVeicolo(Veicolo veicolo) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(veicolo);
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
     * Update Veicolo
     * @param veicolo
     */
    public void updateVehicle(Veicolo veicolo) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(veicolo);
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
     * @param id
     */
    public void deleteVehicle(int id) {

        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Veicolo veicolo = session.get(Veicolo.class, id);
            if (veicolo != null) {
                session.delete(veicolo);
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

    public Veicolo getVeicoloById(int id) {

        Transaction transaction = null;
        List < Veicolo > veicoli = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Veicolo u where u.id = :id");
            query.setParameter("id", id);
            veicoli = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return veicoli.get(0);
    }
    public Veicolo getVeicoloByTarga(String targa) {

        Transaction transaction = null;
        List < Veicolo > veicoli = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Veicolo u where u.targa = :targa");
            query.setParameter("targa", targa);
            veicoli = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(veicoli.size() > 0) {
            return veicoli.get(0);
        }else{
            return null;
        }
    }

    /**
     * Get all Veicoli
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Veicolo > getAllVeicoli() {

        Transaction transaction = null;
        List < Veicolo > veicoli = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            veicoli = session.createQuery("from Veicolo ").getResultList();
            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return veicoli;
    }


    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

}
