package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Curso.CreateCurso;
import com.facens.AC2.Application.UseCase.Curso.ListAllCursos;
import com.facens.AC2.Application.UseCase.Pagamento.CreatePagamentos;
import com.facens.AC2.Application.UseCase.Pagamento.ListAllPagamentos;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.CreatePagamentoDto;
import com.facens.AC2.Presentation.Dto.Pagamento.ListPagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    private final ListAllPagamentos listAllPagamentos;
    private final CreatePagamentos createPagamentos;

    @Autowired
    public PagamentoController(
            ListAllPagamentos listAllPagamentos,
            CreatePagamentos createPagamentos
    ) {
        this.listAllPagamentos = listAllPagamentos;
        this.createPagamentos = createPagamentos;
    }

    @GetMapping("/")
    @ResponseBody()
    public List<ListPagamentoDto> getAllAlunos(){
        return this.listAllPagamentos.list();
    }

    @PostMapping("/")
    @ResponseBody()
    public Pagamento createPagamento (@RequestBody CreatePagamentoDto pagamento){
        return this.createPagamentos.create(pagamento);
    }
}
