package com.rw.config;

import com.rw.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.rw")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProvider authProvider;

    public SecurityConfig(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //доступ для всех пользователей(включая незарегистрированных)
                .mvcMatchers("/login","/registration").permitAll()
                //доступ для всех зарегистрированных пользователей
                .mvcMatchers("/").authenticated()
                //настройка от взлома
                .and().csrf().disable()
                //настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                //имя параметра username со страницы signin
                .usernameParameter("username")
                //возможность логаута для всех
                .and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}
