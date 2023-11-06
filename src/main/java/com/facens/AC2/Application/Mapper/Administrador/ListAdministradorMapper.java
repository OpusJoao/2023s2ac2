package com.facens.AC2.Application.Mapper.Administrador;

import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface ListAdministradorMapper {
    List<ListAdministradorDto> administradorToListAdministradorDto(List<Administrador> administradores);
    List<Administrador> listAdminsitradorDtoToAdministrador(List<ListAdministradorDto> listAdministradoresDto);
}
