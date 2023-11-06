package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Aluno.CreateAluno;
import com.facens.AC2.Application.UseCase.Aluno.ListAllAlunos;
import com.facens.AC2.Application.UseCase.Curso.CreateCurso;
import com.facens.AC2.Application.UseCase.Curso.ListAllCursos;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final ListAllCursos listAllCursos;
    private final CreateCurso createCurso;

    @Autowired
    public CursoController(
            ListAllCursos listAllCursos,
            CreateCurso createCurso
    ) {
        this.listAllCursos = listAllCursos;
        this.createCurso = createCurso;
    }

    @GetMapping("/")
    @ResponseBody()
    public List<ListCursoDto> getAllAlunos(){
        return this.listAllCursos.list();
    }

    @PostMapping("/")
    @ResponseBody()
    public Curso createAluno(@RequestBody CreateCursoDto curso){
        return this.createCurso.create(curso);
    }
}
