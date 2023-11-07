package com.facens.AC2.Application.UseCase.Pagamento;

import com.facens.AC2.Application.Mapper.Pagamento.CreatePagamentoMapper;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Domain.Repository.PagamentoRepository;
import com.facens.AC2.Presentation.Dto.Pagamento.CreatePagamentoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class CreatePagamentos {
    private final PagamentoRepository pagamentoRepository;
    private final AlunoRepository alunoRepository;
    private final CreatePagamentoMapper createPagamentoMapper = Mappers.getMapper(CreatePagamentoMapper.class);
    public CreatePagamentos(PagamentoRepository pagamentoRepository, AlunoRepository alunoRepository){
        this.pagamentoRepository = pagamentoRepository;
        this.alunoRepository = alunoRepository;
    }

    public Pagamento create(CreatePagamentoDto createPagamentoDto) {
        Aluno alunoFound = this.alunoRepository.getById(createPagamentoDto.getAluno());
        Pagamento pagamento = createPagamentoMapper.pagamentoDtoToPagamento(createPagamentoDto);
        return pagamentoRepository.create(pagamento);
    }
}
