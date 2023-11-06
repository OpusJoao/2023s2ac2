package com.facens.AC2.Application.UseCase.Aluno;

import com.facens.AC2.Application.Mapper.Aluno.CreateAlunoMapper;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;


@SpringBootConfiguration()
public class CreateAluno {
    private final AlunoRepository alunoRepository;
    private CreateAlunoMapper createAlunoMapper = Mappers.getMapper(CreateAlunoMapper.class);
    public CreateAluno(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno create(CreateAlunoDto createAlunoDto) {
        Aluno aluno = createAlunoMapper.alunoDtoToAluno(createAlunoDto);
        return alunoRepository.create(aluno);
    }
}
