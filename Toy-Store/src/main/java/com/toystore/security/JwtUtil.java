package com.toystore.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Esta clase nos ayudará a generar el token JWT y también lo verifica
 * @author TuX3
 *
 */
public class JwtUtil {
	
	static final String secretTxt = "bc3562bcd57e480c802202c79f14add2802202c79f14add2802202c79f14add2802202c79f14add2"; 
	
	//Método para generar el token
	static void addAuthentication(HttpServletResponse response,  String username ) {
		
		@SuppressWarnings("deprecation")
		String token = Jwts.builder()
					.setSubject(username)
					//Agregamos un tiempo de expiración de 5 minutos
					.setExpiration(new Date(System.currentTimeMillis() + 300_000) )
					.signWith(SignatureAlgorithm.HS256, secretTxt  )
					.compact();
		// agregamos el token al encabezado de la solicitud http
		response.addHeader("Authorization", "Bearer "+token);
	}

}
