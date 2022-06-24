/*
 * package com.training.security.assignment.jwt_bearer;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.security.core.authority.SimpleGrantedAuthority;
 * import org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service public class JWTUserDetailsService implements UserDetailsService {
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * System.out.println("Called user details service for " + username); return new
 * User("ankita", "user", Arrays.asList(new SimpleGrantedAuthority("USER"))); }
 * }
 */