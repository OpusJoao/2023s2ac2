package com.facens.AC2.Application.Mapper.Curso;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import org.mapstruct.Mapper;

@Mapper()
public interface CreateCursoMapper {
    CreateCursoDto cursoToCursoDto(Curso curso);
    Curso cursoDtoToCurso(CreateCursoDto createCursoDto);
}
