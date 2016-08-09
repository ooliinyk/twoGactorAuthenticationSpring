package app.common.dao;

import app.common.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 15.04.2016.
 */

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    public void save(User user) {
        persist(user);
    }

    public List<User> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("login"));
        return (List<User>) criteria.list();
    }

    public User findById(long id) {
        return getByKey(id);
    }

    public void delteById(long id) {
        User user = getByKey(id);
        delete(user);
    }

    public User findByLogin(String login) {

        Criteria crit = createEntityCriteria();
        System.out.println("1");
        crit.add(Restrictions.eq("login", login));
        System.out.println("2");
        User user = (User) crit.uniqueResult();
        System.out.println("user" + user.toString());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println("3");

        return (User) crit.uniqueResult();
    }
}