package com.supermecado.SistemasVendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagamentoDto {

    private Long id;

    private String descricao;
}
