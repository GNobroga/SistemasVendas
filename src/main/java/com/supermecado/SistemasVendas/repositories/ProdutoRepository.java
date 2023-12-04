package com.supermecado.SistemasVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermecado.SistemasVendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
