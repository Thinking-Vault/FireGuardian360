package com.fireguardian.fireguardian360.forecast.infrastructure;

import com.fireguardian.fireguardian360.forecast.application.AlertService;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * Controlador REST responsável por gerenciar operações relacionadas a alertas.
 * <p>
 * Disponibiliza endpoints para criação de novos alertas e para a recuperação de alertas próximos
 * a uma determinada localização geográfica.
 * </p>
 *
 * <ul>
 *   <li><b>POST /alerts</b>: Cria um novo alerta com base nos dados fornecidos no corpo da requisição.</li>
 *   <li><b>GET /alerts/nearby</b>: Recupera uma lista de alertas próximos a uma latitude e longitude especificadas, dentro de um raio determinado.</li>
 * </ul>
 * 
 */
@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;


    /**
     * Lida com a criação de um novo alerta.
     *
     * @param alert O objeto de alerta a ser criado, fornecido no corpo da solicitação.
     * @return O objeto de alerta criado.
     */
    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    /**
     * Recupera uma lista de alertas próximos com base na latitude, longitude e raio fornecidos.
     *
     * @param lat    a latitude da localização para buscar alertas próximos
     * @param lng    a longitude da localização para buscar alertas próximos
     * @param radius o raio (em graus) dentro do qual buscar alertas; padrão é 0.1 se não fornecido
     * @return uma lista de alertas que estão dentro do raio especificado da localização fornecida
     */
    @GetMapping("/nearby")
    public List<Alert> getNearby(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "0.1") double radius) {
        return alertService.getNearbyAlerts(lat, lng, radius);
    }
}
