package com.supermecado.SistemasVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermecado.SistemasVendas.entities.ProdutoVenda;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {
    
}
