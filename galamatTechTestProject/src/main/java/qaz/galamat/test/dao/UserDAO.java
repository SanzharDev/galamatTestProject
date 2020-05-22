package qaz.galamat.test.dao;

import qaz.galamat.test.entity.User;

public interface UserDAO {
    User findUserByName(final String name);
}
