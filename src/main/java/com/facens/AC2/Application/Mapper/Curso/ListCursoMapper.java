package com.facens.AC2.Application.Mapper.Curso;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface ListCursoMapper {
    List<ListCursoDto> cursoToCursoDto(List<Curso> curso);
    List<Curso> cursoDtoToCurso(List<CreateCursoDto> createCursoDto);
}