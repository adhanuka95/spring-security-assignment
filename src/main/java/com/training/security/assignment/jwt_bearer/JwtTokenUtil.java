package com.training.security.assignment.jwt_bearer;

import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class JwtTokenUtil {
	final static String secretKey = "aaaabbbbccccddddeeeeeffffgggghhhiiijjjkkkllllmmmmnnnnooooppppqqqqqqrrrrssssttttttuuuuuvvvvvvwwwwwxxxyyyzzz";

	public static boolean isValidToken(String token) {

		Jws<Claims> jws = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(secretKey)).parseClaimsJws(token);
		return jws.getBody().getExpiration().compareTo(new Date()) >= 0;
	}

	public static String parseTokenToGetUser(String token) {

		Jws<Claims> jws = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(secretKey)).parseClaimsJws(token);
		String username = (String) jws.getBody().get("user");
		return username;
	}

	public static String generateToken(String username) {

		Calendar currentTimeNow = Calendar.getInstance();
		currentTimeNow.add(Calendar.MINUTE, 10);
		Date tenMinsFromNow = currentTimeNow.getTime();
		String token = Jwts.builder().setSubject(username).claim("user", username).setExpiration(tenMinsFromNow)
				.signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(secretKey)).compact();
		return token;
	}
}
