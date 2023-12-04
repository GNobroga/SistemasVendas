package com.supermecado.SistemasVendas.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.supermecado.SistemasVendas.dtos.PagamentoDto;
import com.supermecado.SistemasVendas.entities.Pagamento;
import com.supermecado.SistemasVendas.helpers.AppException;
import com.supermecado.SistemasVendas.mappers.PagamentoMapper;
import com.supermecado.SistemasVendas.repositories.PagamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoMapper mapper;

    public Pagamento findPagamentoById(Long id) {
        if (Objects.isNull(id)) 
            throw new AppException("O Id %d nao existe na tabela pagamentos".formatted(id));
        
        return pagamentoRepository
            .findById(id)
            .orElseThrow(() -> new AppException("O Id %d nao existe na tabela pagamentos".formatted(id)));
    }

    public List<PagamentoDto> findAll() {
        return pagamentoRepository.findAll()  
            .stream()
            .map(p -> mapper.convertEntityToDto(p))
            .toList();
    }

    public PagamentoDto create(PagamentoDto dto) {
        var entity = mapper.convertDtoToEntity(dto);
        return mapper.convertEntityToDto(pagamentoRepository.save(entity));
    }

    public void delete(Long id) {
        findPagamentoById(id);
        pagamentoRepository.deleteById(id);
    }
    
}
