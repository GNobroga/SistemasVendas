package com.supermecado.SistemasVendas.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.supermecado.SistemasVendas.dtos.ProdutoVendaDto;
import com.supermecado.SistemasVendas.entities.ProdutoVenda;
import com.supermecado.SistemasVendas.services.ProdutoService;
import com.supermecado.SistemasVendas.services.VendaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoVendaMapper {

    private final ProdutoService produtoService;
    private final VendaService vendaService;

    public ProdutoVenda convertDtoToEntity(ProdutoVendaDto source) {
        var target = new ProdutoVenda();
        BeanUtils.copyProperties(source, target);
        target.setProduto(produtoService.findPagamentoById(source.getProdutoId()));
        target.setVenda(vendaService.findPagamentoById(source.getVendaId()));
        return target;
    }

    public ProdutoVendaDto convertEntityToDto(ProdutoVenda source) {
        var target = new ProdutoVendaDto();
        BeanUtils.copyProperties(source, target);
        target.setProdutoId(source.getProduto().getId());
        target.setVendaId(source.getVenda().getId());
        return target;
    }

}
