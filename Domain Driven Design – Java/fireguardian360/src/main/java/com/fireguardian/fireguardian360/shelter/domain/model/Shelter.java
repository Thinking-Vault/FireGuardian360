package com.fireguardian.fireguardian360.shelter.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * Representa uma entidade de abrigo com informações sobre seu nome, localização (latitude e longitude),
 * capacidade e disponibilidade atual. Fornece métodos para calcular a taxa de ocupação e para
 * gerar uma representação em string do status do abrigo.
 *
 * <p>
 * Campos:
 * <ul>
 *   <li><b>id</b>: Identificador único do abrigo.</li>
 *   <li><b>name</b>: Nome do abrigo.</li>
 *   <li><b>lat</b>: Coordenada de latitude da localização do abrigo.</li>
 *   <li><b>lng</b>: Coordenada de longitude da localização do abrigo.</li>
 *   <li><b>capacity</b>: Capacidade total do abrigo.</li>
 *   <li><b>available</b>: Número de vagas disponíveis no abrigo.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Métodos:
 * <ul>
 *   <li>{@link #getOccupancyRate()} - Calcula e retorna a taxa de ocupação como porcentagem.</li>
 *   <li>{@link #toString()} - Retorna uma representação em string do abrigo, incluindo seu nome e disponibilidade.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Esta classe é anotada como uma entidade JPA e utiliza a anotação {@code @Data} do Lombok para gerar
 * código boilerplate como getters, setters, equals, hashCode e métodos toString.
 * </p>
 */
@Data
@Entity
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double lat;
    private double lng;
    private int capacity;
    private int available;


    /**
     * Calcula e retorna a taxa de ocupação do abrigo como uma porcentagem.
     * A taxa de ocupação é determinada pela proporção de vagas ocupadas
     * em relação à capacidade total.
     *
     * @return a taxa de ocupação como porcentagem (0.0 a 100.0)
     */
    public double getOccupancyRate() {
        return (double) (capacity - available) / capacity * 100;
    }

    /**
     * Retorna uma representação em string do abrigo, incluindo seu nome e a razão de vagas disponíveis para a capacidade total.
     * Formato: "nome [disponível/capacidade]".
     *
     * @return uma string descrevendo o nome e a disponibilidade do abrigo.
     */
    @Override
    public String toString() {
        return name + " [" + available + "/" + capacity + "]";
    }
}