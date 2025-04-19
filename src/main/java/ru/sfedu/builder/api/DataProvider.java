package ru.sfedu.builder.api;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.sfedu.builder.Constants;
import ru.sfedu.builder.utils.HibernateUtil;
import ru.sfedu.builder.utils.HistoryContent.Status;
import java.util.Optional;

import static java.lang.Thread.currentThread;
@Component
public class DataProvider implements IDataProvider {
    private static final Logger logger = LogManager.getLogger(DataProvider.class);
    @Override
    public <T> boolean insert(T object) {
        Status status = Status.FAULT;
        logger.info("start insert");
        logger.debug("start insert with entity: " + object);
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB3_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            logger.info("insert successful");

            status = Status.SUCCESS;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
              //  transaction.rollback();
                status = Status.FAULT;
            }
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(object));
        return false;
    }

    @Override
    public <T> Optional<T> getById(Class<T> tClass, long id) {
        logger.info("start getById");
        logger.debug("start getById with id: " + id);
        Transaction transaction = null;
        Optional<T> optional;
        try (Session session = getSession(Constants.LAB3_HBN_CFG)) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(tClass, id));

            transaction.commit();
            logger.info("getById successful");
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    @Override
    public <T> boolean update(T object) {
        logger.info("start update");
        logger.debug("start update with entity: " + object);
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB3_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            logger.info("update successful");
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public <T> boolean delete(T object) {
        logger.info("start delete");
        logger.debug("start delete with entity: " + object);
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB3_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            logger.info("delete successful");
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    Session getSession(String hbn_cnf){
        logger.info("start getSession()");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }
}
