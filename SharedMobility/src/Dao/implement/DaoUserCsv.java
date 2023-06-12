package Dao.implement;

import Dao.DaoUser;
import Model.User;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class DaoUserCsv implements DaoUser {

    private Path usersCsv;
    private TreeMap<UUID,User> idsToUsers;

    public DaoUserCsv(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.idsToUsers= new TreeMap<>();
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
