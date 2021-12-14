package web.dao;


import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
//@Transactional(readOnly = true) <- replaced to [service]
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User showUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    //@Transactional <- replaced to [service]
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    //@Transactional <- replaced to [service]
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    //@Transactional <- replaced to [service]
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
