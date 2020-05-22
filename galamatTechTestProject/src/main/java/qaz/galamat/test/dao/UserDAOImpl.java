package qaz.galamat.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qaz.galamat.test.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByName(final String name) {
        // get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create query to read user from database using username
        // Error: 'from' unexpected
        // fixed by: adding Hibernate as supported framework in Project->Add Framework Support
        Query<User> query = session.createQuery("from User where username=:uName", User.class);
        query.setParameter("uName", name);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }
}
