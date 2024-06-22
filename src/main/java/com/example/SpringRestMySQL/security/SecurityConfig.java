//package com.example.SpringRestMySQL.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    @Autowired
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT ma,passwords,enableds FROM Account where ma=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT ma,authoritys FROM Roles where ma=?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                authorities -> authorities
//                        .requestMatchers(HttpMethod.GET, "api/NhanVien/HienThi").hasAnyRole("ADMIN", "MANAGE", "TEACHER")
//                        .requestMatchers(HttpMethod.GET, "api/NhanVien/**").hasRole("ADMIN")
//        );
//        httpSecurity.httpBasic(Customizer.withDefaults());
//        httpSecurity.csrf(csrf -> csrf.disable());
//        return httpSecurity.build();
//
//    }
//}
//
//
////    @Bean
////    @Autowired
////    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
////        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
////        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT ma,passwords,enableds FROM Account where ma=?");
////        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT ma,authoritys FROM Roles where ma=?");
////        return jdbcUserDetailsManager;
////    }
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests(
////                haha ->haha
////                        .requestMatchers(HttpMethod.GET, "/api/KhachHang/HienThi").hasAnyRole("ADMIN", "MANAGE", "TEACHER")
////                        .requestMatchers(HttpMethod.GET, "/api/KhachHang/**").hasAnyRole("TEACHER", "MANAGE", "ADMIN")
////                        .requestMatchers(HttpMethod.POST, "/api/KhachHang").hasAnyRole("MANAGE", "ADMIN")
////                        .requestMatchers(HttpMethod.PUT, "/api/KhachHang/**").hasAnyRole("MANAGE", "TEACHER")
////                        .requestMatchers(HttpMethod.DELETE, "/api/KhachHang/**").hasRole("ADMIN")
////        );
////        http.httpBasic(Customizer.withDefaults());
////
////        http.csrf(csrf -> csrf.disable());
////        // csrf - cross site request forgery
////
////        return http.build();
////    }