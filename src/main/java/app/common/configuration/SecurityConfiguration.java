package app.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup", "/static/**").permitAll()
                .antMatchers("/code").hasRole("PRE_AUTH_USER")
                .antMatchers("/home").hasRole("USER")
                .anyRequest().authenticated().and().exceptionHandling().accessDeniedPage("/code");

        http.formLogin()
                .loginPage("/login")
                .permitAll()
                        // always use the default success url despite if a protected page had been previously visited
                .defaultSuccessUrl("/home", true)
                .and()
                .logout()
                .permitAll();

    }

    @Autowired
    public void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
