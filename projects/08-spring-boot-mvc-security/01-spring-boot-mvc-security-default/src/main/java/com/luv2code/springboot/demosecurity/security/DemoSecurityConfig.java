package com.luv2code.springboot.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC, no more hard code for user
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
         *   authenticated() ทุก request ที่เกิดขึ้นจะต้องมีการยืนยันตัวตน
         *   loginPage() ระบุุ url ที่ใช้สำหรับดึงหน้าเข้าสู่ระบบ
         *   loginPrecessingUrl() ระบุ url ที่จะใช้ประมวลผลการเข้าสู่ระบบ
         *   permitAll() ทุกคนสามารถเข้าถึงสิ่งนี้ได้
         *   logout() ทำให้เมื่อมีการเรียกใช้ /logout จะทำการลบ session ของ user ออกและทำการ redirect ไปที่ login page
         * 
         *   requestMatchers() เมื่อ URL Path ของ request ตรงกับที่ระบุ
         *
         *   loginProcessingUrl ไม่จำเป็นต้องมี controller เนื่องจาก spring security จะจัดการให้เราเอง
         * */
    	
    	http.authorizeHttpRequests(config -> 
            config
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated())
    		.formLogin(config -> config.loginPage("/auth/login").loginProcessingUrl("/auth/login-process").permitAll())
            .logout(config -> config.permitAll())
            .exceptionHandling(config -> config.accessDeniedPage("/auth/access-denied"));

        return http.build();
    }
}

// @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    //     UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
    //     UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
    //     UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }