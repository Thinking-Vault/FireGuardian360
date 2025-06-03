package com.fireguardian.fireguardian360.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * SecurityConfig é uma classe de configuração que define a cadeia de filtros de segurança para a aplicação.
 * <p>
 * Esta configuração atualmente desabilita a proteção CSRF e permite todas as requisições HTTP sem autenticação.
 * </p>
 * 
 * <p>
 * <b>Nota:</b> Esta configuração é destinada para ambientes de desenvolvimento ou teste.
 * Para ambientes de produção, recomenda-se habilitar as medidas de segurança apropriadas.
 * </p>
 * 
 */
@Configuration
public class SecurityConfig {


    /**
     * Configura a cadeia de filtros de segurança para a aplicação.
     * <p>
     * Esta configuração desabilita a proteção CSRF e permite todas as requisições HTTP
     * sem qualquer verificação de autenticação ou autorização. Este cenário é normalmente utilizado
     * durante o desenvolvimento ou para endpoints públicos onde a segurança não é uma preocupação.
     *
     * @param http o {@link HttpSecurity} a ser modificado
     * @return o {@link SecurityFilterChain} configurado
     * @throws Exception se ocorrer um erro ao configurar a cadeia de filtros de segurança
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                    .anyRequest().permitAll() // libera tudo por enquanto
                );
        return http.build();
    }
}
