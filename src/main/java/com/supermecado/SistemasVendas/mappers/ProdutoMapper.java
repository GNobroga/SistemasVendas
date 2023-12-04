package com.supermecado.SistemasVendas.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.supermecado.SistemasVendas.dtos.ProdutoDto;
import com.supermecado.SistemasVendas.entities.Produto;

@Component
public class ProdutoMapper {
    
    public Produto convertDtoToEntity(ProdutoDto source) {
        var produto = new Produto();
        BeanUtils.copyProperties(source, produto);
        return produto;
    }

    public ProdutoDto convertEntityToDto(Produto source) {
        var produto = new ProdutoDto();
        BeanUtils.copyProperties(source, produto);
        return produto;
    }

}
