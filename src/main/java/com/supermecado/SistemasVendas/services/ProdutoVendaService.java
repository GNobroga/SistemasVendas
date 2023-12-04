package com.supermecado.SistemasVendas.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.supermecado.SistemasVendas.dtos.ProdutoDto;
import com.supermecado.SistemasVendas.dtos.ProdutoVendaDto;
import com.supermecado.SistemasVendas.helpers.AppException;
import com.supermecado.SistemasVendas.mappers.ProdutoVendaMapper;
import com.supermecado.SistemasVendas.repositories.ProdutoVendaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoVendaService {
    
    private final ProdutoVendaRepository produtoVendaRepository;
    private final ProdutoVendaMapper mapper;

    public ProdutoVendaDto findById(Long id) {
        if (Objects.isNull(id)) 
            throw new AppException("O produto venda com Id %d nao existe".formatted(id));
        
        var entity = produtoVendaRepository.findById(id)
                .orElseThrow(() -> 
                    new AppException("Produto com Id %d nao existe na base dados".formatted(id)));

        return mapper.convertEntityToDto(entity);
    }

    public List<ProdutoVendaDto> findAll() {
        return produtoVendaRepository.findAll()  
            .stream()
            .map(pv -> mapper.convertEntityToDto(pv))
            .toList();
    }

    public ProdutoVendaDto create(ProdutoVendaDto dto) {
        var entity = mapper.convertDtoToEntity(dto);
        return mapper.convertEntityToDto(produtoVendaRepository.save(entity));
    }

    public ProdutoVendaDto update(Long id, ProdutoVendaDto dto) {
        findById(id);
        var target = produtoVendaRepository.findById(id).get();
        var source = mapper.convertDtoToEntity(dto);
        target.setCpf(source.getCpf());
        target.setDesconto(source.getDesconto());
        target.setNomeCliente(source.getNomeCliente());
        target.setProduto(source.getProduto());
        target.setVenda(source.getVenda());
        target.setQuantidade(source.getQuantidade());
        return mapper.convertEntityToDto(produtoVendaRepository.save(target));
    }

    public void delete(Long id) {
        findById(id);
        produtoVendaRepository.deleteById(id);
    }


}
