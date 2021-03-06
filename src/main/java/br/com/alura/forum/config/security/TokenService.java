package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;
    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {

        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date dateNow = new Date();
        Date expirationDate = new Date(dateNow.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API do Fórum da Alura")
                .setSubject(usuarioLogado.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
}
