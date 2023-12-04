package com.supermecado.SistemasVendas.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.supermecado.SistemasVendas.dtos.PagamentoDto;
import com.supermecado.SistemasVendas.entities.Pagamento;

@Component
public class PagamentoMapper {

    public Pagamento convertDtoToEntity(PagamentoDto source) {
        var pagamento = new Pagamento();
        BeanUtils.copyProperties(source, pagamento);
        return pagamento;
    }

    public PagamentoDto convertEntityToDto(Pagamento source) {
        var pagamento = new PagamentoDto();
        BeanUtils.copyProperties(source, pagamento);
        return pagamento;
    }
}
