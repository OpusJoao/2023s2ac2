package com.facens.AC2.Application.Mapper.Pagamento;

import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Presentation.Dto.Pagamento.CreatePagamentoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.ListPagamentoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface CreatePagamentoMapper {
    ListPagamentoDto pagamentoToPagamentoDto(Pagamento pagamento);
    Pagamento pagamentoDtoToPagamento(CreatePagamentoDto createPagamentoDto);
}