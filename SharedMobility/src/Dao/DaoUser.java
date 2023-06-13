package Dao;

import Model.User;

import java.util.List;
import java.util.UUID;

public interface DaoUser {

    boolean insert(User user);

    boolean update(User user);

    boolean delete(UUID id);

    User get(UUID id);

    List<User> getAll();
}
