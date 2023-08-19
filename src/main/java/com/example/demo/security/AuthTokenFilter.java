package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Autowired
	private JwtUtils jwtUtils;

	//metodo para autetificar si no es valido security no deja pasar
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {

		String jwt = this.parseJwt(request);
		//retorna un boolean
		if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
			// como es valido el token le voy autenticar
			String nombre = this.jwtUtils.getUsernameFromJwtToken(jwt);

			// Le autentifiamos
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nombre,
					null, new ArrayList<>());
			
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			//seteamos la autentificacion en la session
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		}catch (Exception e) {
			// TODO: handle exception
			LOG.error("No se pudo realizar la auteticación con el token enviado:{}",e.getMessage());
		}
		//procese todo lo que hemos trabajado poniendo una autentificacion en el request
		filterChain.doFilter(request, response);

	}

	// request q me va a amandar para consumir la api de negocio
	private String parseJwt(HttpServletRequest request) {
		String valorCompleto = request.getHeader("Authorization");
		if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer")) {
			return valorCompleto.substring(7, valorCompleto.length());
		}
		return null;
	}

}
