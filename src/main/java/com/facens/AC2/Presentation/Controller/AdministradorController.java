package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Administrador.CreateAdministrador;
import com.facens.AC2.Application.UseCase.Administrador.ListAllAdministradores;
import com.facens.AC2.Application.UseCase.Aluno.CreateAluno;
import com.facens.AC2.Application.UseCase.Aluno.ListAllAlunos;
import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAdministradorDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    private final ListAllAdministradores listAllAdministradores;
    private final CreateAdministrador createAdministrador;

    @Autowired
    public AdministradorController(
            ListAllAdministradores listAllAdministradores,
            CreateAdministrador createAdministrador
    ) {
        this.listAllAdministradores = listAllAdministradores;
        this.createAdministrador = createAdministrador;
    }

    @GetMapping("/")
    @ResponseBody()
    public List<ListAdministradorDto> getAllAdministradores(){
        return this.listAllAdministradores.list();
    }

    @PostMapping("/")
    @ResponseBody()
    public CreateAdministradorDto createAluno(@RequestBody CreateAdministradorDto aluno){
        return this.createAdministrador.create(aluno);
    }
}
