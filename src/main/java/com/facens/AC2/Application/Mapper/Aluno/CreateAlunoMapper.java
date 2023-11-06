package com.facens.AC2.Application.Mapper.Aluno;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import org.mapstruct.Mapper;

@Mapper()
public interface CreateAlunoMapper {
    CreateAlunoDto alunoToAlunoDto(Aluno aluno);
    Aluno alunoDtoToAluno(CreateAlunoDto createAlunoDto);
}
