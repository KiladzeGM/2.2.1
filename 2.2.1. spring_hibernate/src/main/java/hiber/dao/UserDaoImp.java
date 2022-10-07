package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User setUser(User user, String firstName, String lastName, String email, int series, String model) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.getCarId().setSeries(series);
        user.getCarId().setModel(model);
        return user;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User returnUser(int series, String model) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where carId.series = :series and carId.model = :model", User.class);
        query.setMaxResults(1);
        query.setParameter("series", series);
        query.setParameter("model", model);
        return query.getSingleResult();
    }

}
