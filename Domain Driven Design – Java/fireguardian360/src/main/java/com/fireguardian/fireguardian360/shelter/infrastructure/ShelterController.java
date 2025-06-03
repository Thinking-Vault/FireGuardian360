package com.fireguardian.fireguardian360.shelter.infrastructure;

import com.fireguardian.fireguardian360.shelter.application.ShelterService;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * ShelterController é um controlador REST responsável por manipular requisições relacionadas a abrigos (Shelter).
 * 
 * Fornece endpoints para:
 * <ul>
 *   <li>Criar um novo abrigo via requisição HTTP POST.</li>
 *   <li>Recuperar uma lista de abrigos próximos a uma localização específica via requisição HTTP GET.</li>
 * </ul>
 * 
 * Os métodos deste controlador utilizam o serviço ShelterService para realizar operações de negócio relacionadas a abrigos.
 * 
 * Endpoints expostos:
 * <ul>
 *   <li><b>POST /shelters</b>: Cria um novo abrigo.</li>
 *   <li><b>GET /shelters/nearby</b>: Lista abrigos disponíveis próximos a uma latitude e longitude informadas.</li>
 * </ul>
 * 
 * @author SeuNome
 */
@RestController
@RequestMapping("/shelters")
public class ShelterController {
    @Autowired
    private ShelterService shelterService;


    /**
     * Manipula requisições HTTP POST para criar um novo Shelter.
     *
     * @param shelter o objeto Shelter a ser criado, fornecido no corpo da requisição
     * @return o objeto Shelter criado
     */
    @PostMapping
    public Shelter create(@RequestBody Shelter shelter) {
        return shelterService.createShelter(shelter);
    }


    /**
     * Recupera uma lista de abrigos próximos dentro de um raio especificado a partir da latitude e longitude fornecidas.
     *
     * @param lat    a latitude da localização de busca
     * @param lng    a longitude da localização de busca
     * @param radius o raio de busca em graus (padrão é 0.1)
     * @return uma lista de abrigos disponíveis dentro do raio especificado
     */
    @GetMapping("/nearby")
    public List<Shelter> getNearby(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "0.1") double radius) {
        return shelterService.getAvailableShelters(lat, lng, radius);
    }
}
