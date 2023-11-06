package com.facens.AC2.Application.UseCase.Aluno;

import com.facens.AC2.Application.Mapper.Aluno.CreateAlunoMapper;
import com.facens.AC2.Application.Mapper.Aluno.ListAlunoMapper;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;

import java.util.List;

@SpringBootConfiguration
public class ListAllAlunos {
    private final AlunoRepository alunoRepository;
    private ListAlunoMapper listAlunoMapper = Mappers.getMapper(ListAlunoMapper.class);
    public ListAllAlunos(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<ListAlunoDto> list() {
        List<Aluno> aluno = this.alunoRepository.getAll();
        List<ListAlunoDto> listAlunoDto = listAlunoMapper.alunoToListAlunoDto(aluno);

        return listAlunoDto;
    }
}
