package br.com.encom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encom.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {



}
