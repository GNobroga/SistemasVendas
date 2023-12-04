package com.supermecado.SistemasVendas.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.supermecado.SistemasVendas.dtos.ProdutoDto;
import com.supermecado.SistemasVendas.dtos.VendaDto;
import com.supermecado.SistemasVendas.entities.Produto;
import com.supermecado.SistemasVendas.entities.Venda;
import com.supermecado.SistemasVendas.services.PagamentoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VendaMapper {

    private final PagamentoService pagamentoService;
    
    public Venda convertDtoToEntity(VendaDto source) {
        var target = new Venda();
        BeanUtils.copyProperties(source, target);
        target.setPagamento(pagamentoService.findPagamentoById(source.getPagamentoId()));
        return target;
    }

    public VendaDto convertEntityToDto(Venda source) {
        var target = new VendaDto();
        BeanUtils.copyProperties(source, target);
        target.setPagamentoId(source.getPagamento().getId());
        return target;
    }
}
