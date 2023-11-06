package com.facens.AC2.Application.UseCase.Curso;

import com.facens.AC2.Application.Mapper.Aluno.CreateAlunoMapper;
import com.facens.AC2.Application.Mapper.Curso.CreateCursoMapper;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Domain.Repository.CursoRepository;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;


@SpringBootConfiguration()
public class CreateCurso {
    private final CursoRepository cursoRepository;
    private CreateCursoMapper createCursoMapper = Mappers.getMapper(CreateCursoMapper.class);
    public CreateCurso(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public Curso create(CreateCursoDto createCursoDto) {
        Curso curso = createCursoMapper.cursoDtoToCurso(createCursoDto);
        return cursoRepository.create(curso);
    }
}
