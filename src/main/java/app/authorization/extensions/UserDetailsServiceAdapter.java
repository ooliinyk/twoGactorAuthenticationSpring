package app.authorization.extensions;


import app.common.dao.UserDao;
import app.common.entity.User;
//import com.service.forMySql.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Adapts the {@link } to the {@link UserDetailsService} interface
 * so Spring Security can use it as an authentication source.
 */
@Component
@Primary
public class UserDetailsServiceAdapter implements UserDetailsService {

    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = dao.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        return new UserDetailsAdapter(user);
    }

}
