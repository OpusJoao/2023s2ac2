package com.facens.AC2.Application.UseCase.Curso;

import com.facens.AC2.Application.Mapper.Aluno.ListAlunoMapper;
import com.facens.AC2.Application.Mapper.Curso.CreateCursoMapper;
import com.facens.AC2.Application.Mapper.Curso.ListCursoMapper;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Domain.Repository.CursoRepository;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;

import java.util.List;

@SpringBootConfiguration
public class ListAllCursos {
    private final CursoRepository cursoRepository;
    private final ListCursoMapper listCursoMapper = Mappers.getMapper(ListCursoMapper.class);
    public ListAllCursos(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public List<ListCursoDto> list() {
        List<Curso> curso = this.cursoRepository.getAll();

        return listCursoMapper.cursoToCursoDto(curso);
    }
}
