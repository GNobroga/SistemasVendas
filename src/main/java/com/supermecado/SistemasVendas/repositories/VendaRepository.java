package com.supermecado.SistemasVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermecado.SistemasVendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
}
