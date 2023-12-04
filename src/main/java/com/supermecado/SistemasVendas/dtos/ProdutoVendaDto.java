package com.supermecado.SistemasVendas.dtos;

import com.supermecado.SistemasVendas.entities.Produto;
import com.supermecado.SistemasVendas.entities.Venda;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoVendaDto {

    private Long id;

    private int quantidade;

    private String nomeCliente = "Consumidor";

    private String cpf;

    private Double desconto;

    @NotNull
    private long produtoId;

    private Produto produto;

    @NotNull
    private long vendaId;

    private Venda venda;
}
