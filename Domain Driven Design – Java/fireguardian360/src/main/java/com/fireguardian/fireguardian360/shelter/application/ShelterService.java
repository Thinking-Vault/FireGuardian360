package com.fireguardian.fireguardian360.shelter.application;

import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import com.fireguardian.fireguardian360.shelter.domain.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável por gerenciar operações relacionadas a abrigos ({@link Shelter}),
 * incluindo criação e busca de abrigos disponíveis próximos a uma localização.
 * 
 * Esta classe utiliza o {@link ShelterRepository} para persistência e recuperação de dados.
 * 
 * Funcionalidades principais:
 * <ul>
 *   <li>Criar um novo abrigo.</li>
 *   <li>Buscar abrigos disponíveis dentro de um raio específico a partir de uma coordenada geográfica.</li>
 * </ul>
 * 
 */
@Service
public class ShelterService {
    @Autowired
    private ShelterRepository shelterRepository;


    /**
     * Cria um novo abrigo salvando a entidade {@link Shelter} fornecida no repositório.
     *
     * @param shelter a entidade {@link Shelter} a ser criada e persistida
     * @return a entidade {@link Shelter} persistida
     */
    public Shelter createShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }


    /**
     * Recupera uma lista de abrigos disponíveis dentro de um raio especificado a partir da latitude e longitude fornecidas.
     *
     * @param lat a latitude do ponto central
     * @param lng a longitude do ponto central
     * @param radius o raio (em graus) para buscar abrigos disponíveis
     * @return uma lista de abrigos que estão disponíveis e localizados dentro do raio especificado
     */
    public List<Shelter> getAvailableShelters(double lat, double lng, double radius) {
        return shelterRepository.findAvailableNearby(
                lat - radius, lat + radius,
                lng - radius, lng + radius
        );
    }
}
