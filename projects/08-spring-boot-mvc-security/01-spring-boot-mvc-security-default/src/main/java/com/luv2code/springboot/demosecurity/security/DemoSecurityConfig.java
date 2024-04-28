package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
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
            .logout(config -> config.permitAll());

        return http.build();
    }
}
