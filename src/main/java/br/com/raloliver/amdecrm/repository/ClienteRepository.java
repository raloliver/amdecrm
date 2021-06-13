package br.com.raloliver.amdecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raloliver.amdecrm.model.Cliente;

/**
 * Tipos: primeiro a classe que o repositório irá manipular e segundo o tipo de
 * dado do ID
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
