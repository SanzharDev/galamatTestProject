package qaz.galamat.test.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import qaz.galamat.test.entity.User;

public interface UserService extends UserDetailsService {
    User findUserByName(String name);
}
