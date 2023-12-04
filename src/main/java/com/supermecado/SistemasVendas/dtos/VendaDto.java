package com.supermecado.SistemasVendas.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDto {

    private Long id;

    private Date data;

    @NotNull
    private Long pagamentoId;
}
