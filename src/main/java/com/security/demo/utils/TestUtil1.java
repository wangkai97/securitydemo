package com.security.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestUtil1 {
    //BCryptPasswordEncoder 密码编码及匹配示例
    public static void main(String[] args) {
        String pass = "test";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passHash = encoder.encode(pass);
        System.out.println(passHash);

        final boolean matches = encoder.matches(pass, passHash);
        System.out.println(matches);
    }
}
