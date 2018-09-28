package com.wasp.songappspring.repositories;

import com.wasp.songappspring.models.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlSongsRepositoryImpl implements SongsRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addSong(Song newSong) {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            session.save(newSong);

            transaction.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    @Override
    public void deleteSong(int id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Song songToDelete = session.get(Song.class, id);

            session
                    .delete(songToDelete);

            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    @Override
    public Song updateSongPlayCounter(Song songToUpdate, int id) {


        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Song song = session.get(Song.class, id);
            song
                    .setPlaysCount(songToUpdate.getPlaysCount());

            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return getSongById(id);
    }

    @Override
    public Song getSongById(int id) {
        Song searchedSong = null;
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            searchedSong = session.get(Song.class, id);

            transaction.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return searchedSong;
    }

    @Override
    public List<Song> getAllSongs() {
        List<Song> allSongs = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Song> criteriaQuery = criteriaBuilder.createQuery(Song.class);
            criteriaQuery.from(Song.class);

            allSongs = session
                    .createQuery(criteriaQuery)
                    .getResultList();

            transaction.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return allSongs;
    }
}
