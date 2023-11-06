package com.facens.AC2.Application.Mapper.Aluno;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface ListAlunoMapper {
    List<ListAlunoDto> alunoToListAlunoDto(List<Aluno> aluno);
    List<Aluno> listAlunoDtoToAluno(List<ListAlunoDto> listAlunoDto);
}
