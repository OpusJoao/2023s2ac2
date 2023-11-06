package com.facens.AC2.Application.UseCase.Administrador;

import com.facens.AC2.Application.Mapper.Administrador.ListAdministradorMapper;
import com.facens.AC2.Application.Mapper.Aluno.ListAlunoMapper;
import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AdministradorRepository;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import com.facens.AC2.Presentation.Dto.Aluno.ListAlunoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;

import java.util.List;

@SpringBootConfiguration
public class ListAllAdministradores {
    private final AdministradorRepository administradorRepository;
    private final ListAdministradorMapper listAdministradorMapper = Mappers.getMapper(ListAdministradorMapper.class);
    public ListAllAdministradores(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }

    public List<ListAdministradorDto> list() {
        List<Administrador> administrador = this.administradorRepository.getAll();

        return listAdministradorMapper.administradorToListAdministradorDto(administrador);
    }
}
