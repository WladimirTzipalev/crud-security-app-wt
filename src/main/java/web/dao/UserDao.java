package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getById(Long id);

    User getByLogin(String email);

    void update(User updateUser);

    void save(User user);

    void delete(Long id);
}
