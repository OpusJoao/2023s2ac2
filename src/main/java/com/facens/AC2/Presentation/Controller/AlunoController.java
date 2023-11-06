package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Aluno.CreateAluno;
import com.facens.AC2.Application.UseCase.Aluno.ListAllAlunos;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final ListAllAlunos listAllAlunos;
    private final CreateAluno createAluno;

    @Autowired
    public AlunoController(
            ListAllAlunos listAllAlunos,
            CreateAluno createAluno
    ) {
        this.listAllAlunos = listAllAlunos;
        this.createAluno = createAluno;
    }

    @GetMapping("/")
    @ResponseBody()
    public List<ListAlunoDto> getAllAlunos(){
        return this.listAllAlunos.list();
    }

    @PostMapping("/")
    @ResponseBody()
    public Aluno createAluno(@RequestBody CreateAlunoDto aluno){
        return this.createAluno.create(aluno);
    }
}
