package com.facens.AC2.Application.Mapper.Pagamento;

import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.CreatePagamentoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.ListPagamentoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface ListPagamentoMapper {
    List<ListPagamentoDto> pagamentoToPagamentoDto(List<Pagamento> pagamento);
    List<Pagamento> pagamentoDtoToPagamento(List<CreatePagamentoDto> createPagamentoDto);
}