package com.supermecado.SistemasVendas.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

    private Long id;

    @NotBlank(message = "O nome do produto nao pode ser null ou vazio")
    private String nome;

    private Double preco;

    private int estoque;
}
