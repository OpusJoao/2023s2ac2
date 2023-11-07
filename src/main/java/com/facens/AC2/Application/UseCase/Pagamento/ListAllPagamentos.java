package com.facens.AC2.Application.UseCase.Pagamento;

import com.facens.AC2.Application.Mapper.Curso.ListCursoMapper;
import com.facens.AC2.Application.Mapper.Pagamento.ListPagamentoMapper;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Domain.Repository.CursoRepository;
import com.facens.AC2.Domain.Repository.PagamentoRepository;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.ListPagamentoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;

import java.util.List;

@SpringBootConfiguration
public class ListAllPagamentos {
    private final PagamentoRepository pagamentoRepository;
    private final ListPagamentoMapper listPagamentoMapper = Mappers.getMapper(ListPagamentoMapper.class);
    public ListAllPagamentos(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<ListPagamentoDto> list() {
        List<Pagamento> pagamentos = this.pagamentoRepository.getAll();

        return listPagamentoMapper.pagamentoToPagamentoDto(pagamentos);
    }
}
