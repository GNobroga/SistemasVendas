package com.supermecado.SistemasVendas.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.supermecado.SistemasVendas.dtos.ProdutoDto;
import com.supermecado.SistemasVendas.dtos.VendaDto;
import com.supermecado.SistemasVendas.entities.Venda;
import com.supermecado.SistemasVendas.helpers.AppException;
import com.supermecado.SistemasVendas.mappers.VendaMapper;
import com.supermecado.SistemasVendas.repositories.VendaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendaMapper mapper;

     public Venda findPagamentoById(Long id) {
        if (Objects.isNull(id)) 
            throw new AppException("O Id %d nao existe na tabela Vendas".formatted(id));
        
        return vendaRepository
            .findById(id)
            .orElseThrow(() -> new AppException("O Id %d nao existe na tabela produtos".formatted(id)));
    }


    public VendaDto findOne(Long id) {
        return mapper.convertEntityToDto(findPagamentoById(id));
    }

    public List<VendaDto> findAll() {
        return vendaRepository.findAll()  
            .stream()
            .map(p -> mapper.convertEntityToDto(p))
            .toList();
    }

    public VendaDto create(VendaDto dto) {
        var entity = mapper.convertDtoToEntity(dto);
        return mapper.convertEntityToDto(vendaRepository.save(entity));
    }

    public VendaDto update(Long id, VendaDto dto) {
        var target = findPagamentoById(id);
        var source = mapper.convertDtoToEntity(dto);

        target.setData(source.getData());
        target.setPagamento(source.getPagamento());

        return mapper.convertEntityToDto(vendaRepository.save(target));
    }

    public void delete(Long id) {
        findPagamentoById(id);
        vendaRepository.deleteById(id);
    }

}
