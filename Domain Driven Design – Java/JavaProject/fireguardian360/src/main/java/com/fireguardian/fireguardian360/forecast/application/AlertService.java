package com.fireguardian.fireguardian360.forecast.application;

import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.forecast.domain.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço responsável por gerenciar alertas.
 * Fornece métodos para criar novos alertas e recuperar alertas dentro de um raio especificado.
 * 
 * <p>Este serviço interage com o {@link AlertRepository} para realizar operações de banco de dados
 * relacionadas aos alertas.</p>
 * 
 * <p>Funcionalidades principais:</p>
 * <ul>
 *   <li>Criar e salvar um novo alerta.</li>
 *   <li>Recuperar alertas dentro de um raio geográfico especificado.</li>
 * </ul>
 * 
 * <p>Anotações:</p>
 * <ul>
 *   <li>{@code @Service} - Indica que esta classe é um componente de serviço do Spring.</li>
 *   <li>{@code @Autowired} - Injeta a dependência {@link AlertRepository}.</li>
 * </ul>
 */
@Service
public class AlertService {
    @Autowired
    private AlertRepository alertRepository;


    /**
     * Cria um novo alerta salvando-o no repositório.
     *
     * @param alert o objeto Alert a ser criado e salvo
     * @return o objeto Alert salvo
     */
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    
    /**
     * Recupera uma lista de alertas que estão dentro de um raio especificado da latitude e longitude fornecidas.
     *
     * @param lat a latitude do ponto central
     * @param lng a longitude do ponto central
     * @param radius o raio (em graus) dentro do qual buscar os alertas
     * @return uma lista de objetos {@link Alert} localizados dentro do raio especificado
     */
    public List<Alert> getNearbyAlerts(double lat, double lng, double radius) {
        return alertRepository.findByLatBetweenAndLngBetween(
                lat - radius, lat + radius,
                lng - radius, lng + radius
        );
    }
}
