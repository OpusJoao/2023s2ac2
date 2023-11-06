package com.facens.AC2.Application.UseCase.Administrador;

import com.facens.AC2.Application.Mapper.Administrador.CreateAdministradorMapper;
import com.facens.AC2.Application.Mapper.Aluno.CreateAlunoMapper;
import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AdministradorRepository;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAdministradorDto;
import com.facens.AC2.Presentation.Dto.Aluno.CreateAlunoDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringBootConfiguration;


@SpringBootConfiguration()
public class CreateAdministrador {
    private final AdministradorRepository administradorRepository;
    private CreateAdministradorMapper createAdministradorMapper = Mappers.getMapper(CreateAdministradorMapper.class);
    public CreateAdministrador(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }

    public CreateAdministradorDto create(CreateAdministradorDto createAdministradorDto) {
        Administrador administrador = createAdministradorMapper.createAdminsitradorDtoToAdministrador(createAdministradorDto);
        administrador = administradorRepository.create(administrador);
        return createAdministradorMapper.administradorToCreateAdministradorDto(administrador);
    }
}
