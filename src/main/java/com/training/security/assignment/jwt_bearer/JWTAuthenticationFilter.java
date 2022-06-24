/*
 * package com.training.security.assignment.jwt_bearer;
 * 
 * import java.io.IOException; import java.util.ArrayList;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * @Service public class JWTAuthenticationFilter extends OncePerRequestFilter {
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException { String authorizationHeader =
 * request.getHeader("Authorization"); if (authorizationHeader != null &&
 * authorizationHeader.startsWith("Bearer ")) { String token =
 * authorizationHeader.substring(7); System.out.println("Token obtained is : " +
 * token); if (JWTUtils.isValidToken(token)) { String userName =
 * JWTUtils.parseTokenToGetUser(token);
 * System.out.println("Obtained username = " + userName);
 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
 * UsernamePasswordAuthenticationToken( userName, null, new ArrayList<>());
 * SecurityContextHolder.getContext().setAuthentication(
 * usernamePasswordAuthenticationToken); } else {
 * System.out.println("Invalid token"); } } else {
 * System.out.println("No auth token"); } filterChain.doFilter(request,
 * response); } }
 */