package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //两个用户admin/123456和test/test密码为hash算法加密可通过TestUtil1生成和匹配
        auth.inMemoryAuthentication()
                .withUser("admin").password("$2a$10$Kwqpqy4N1ZWUlrmYVffdzuZt9tHIE9/FgSk6ORMgeURKUpv.aID.i").roles("admin")
                .and()
                .withUser("test").password("$2a$10$d3k2SmMeebdyFEWajyEGzuTx9p0i4KY1AzaFjIRvxjHxnXkkYfJtK").roles("user");
    }

    @Bean
    // 需要注入否则报错java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}