package com.supermecado.SistemasVendas.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.supermecado.SistemasVendas.dtos.ProdutoDto;
import com.supermecado.SistemasVendas.entities.Produto;
import com.supermecado.SistemasVendas.helpers.AppException;
import com.supermecado.SistemasVendas.mappers.ProdutoMapper;
import com.supermecado.SistemasVendas.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;

    public Produto findPagamentoById(Long id) {
        if (Objects.isNull(id)) 
            throw new AppException("O Id %d nao existe na tabela produtos".formatted(id));
        
        return produtoRepository
            .findById(id)
            .orElseThrow(() -> new AppException("O Id %d nao existe na tabela produtos".formatted(id)));
    }

    
    public ProdutoDto findOne(Long id) {
        return mapper.convertEntityToDto(findPagamentoById(id));
    }

    public List<ProdutoDto> findAll() {
        return produtoRepository.findAll()  
            .stream()
            .map(p -> mapper.convertEntityToDto(p))
            .toList();
    }

    public ProdutoDto create(ProdutoDto dto) {
        var entity = mapper.convertDtoToEntity(dto);
        return mapper.convertEntityToDto(produtoRepository.save(entity));
    }

    public ProdutoDto update(Long id, ProdutoDto dto) {
        var target = findPagamentoById(id);
        var source = mapper.convertDtoToEntity(dto);

        target.setEstoque(source.getEstoque());
        target.setNome(source.getNome());
        target.setPreco(source.getPreco());

        return mapper.convertEntityToDto(produtoRepository.save(target));
    }

    public void delete(Long id) {
        findPagamentoById(id);
        produtoRepository.deleteById(id);
    }

}
