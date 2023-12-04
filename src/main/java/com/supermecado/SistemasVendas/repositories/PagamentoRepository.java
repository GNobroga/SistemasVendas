package com.supermecado.SistemasVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermecado.SistemasVendas.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
