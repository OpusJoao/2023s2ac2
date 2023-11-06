package com.facens.AC2.Application.Mapper.Administrador;

import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAdministradorDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface CreateAdministradorMapper {
    CreateAdministradorDto administradorToCreateAdministradorDto(Administrador administrador);
    Administrador createAdminsitradorDtoToAdministrador(CreateAdministradorDto createAdministradoresDto);
}
