package app.authorization.extensions;


import app.authorization.TOTP.TimeBasedOneTimePassword;
import app.common.entity.Role;
import app.common.entity.User;
import app.authorization.twilio.SendSMS_Twilio;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Set;

/**
 * Adapts the {@link User} to the {@link UserDetails}.
 * This way the {@link User} can be used for core user information.
 */
    public class UserDetailsAdapter implements UserDetails {

    private User user;


    public String getTfa() {
        return user.getTfa();
    }
    public Set<Role> getRoles() {
        return user.getRoles();
    }


    public UserDetailsAdapter(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getTfa().equals("N")){
          return   AuthorityUtils.createAuthorityList("ROLE_USER");
        }
        try {
            SendSMS_Twilio.sendSMS("" + TimeBasedOneTimePassword.getCode(TimeBasedOneTimePassword.SHARED_SECRET, TimeBasedOneTimePassword.getTimeIndex()), user.getUserInfo().getMobile());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return AuthorityUtils.createAuthorityList("ROLE_PRE_AUTH_USER");
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
