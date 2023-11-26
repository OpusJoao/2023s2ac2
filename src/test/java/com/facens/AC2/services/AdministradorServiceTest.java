package com.facens.AC2.services;

import com.facens.AC2.Application.UseCase.Administrador.CreateAdministrador;
import com.facens.AC2.Application.UseCase.Administrador.ListAllAdministradores;
import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Repository.AdministradorRepository;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAdministradorDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AdministradorServiceTest {
    @Mock
    private AdministradorRepository administradorRepository;

    @InjectMocks
    private CreateAdministrador createAdministrador;

    @InjectMocks
    private ListAllAdministradores listAllAdministradores;

    @Test
    public void testCreate() {
        CreateAdministradorDto createAdministradorDto = new CreateAdministradorDto(1, "John Doe", "johndoe@example.com");

        Administrador administrador = new Administrador(1, "John Doe", "johndoe@example.com", "123");

        when(administradorRepository.create(administrador)).thenReturn(administrador);

        CreateAdministradorDto result = createAdministrador.create(createAdministradorDto);

        assertEquals("John Doe", result.getNome());
        assertEquals("johndoe@example.com", result.getEmail());
    }

    @Test
    public void testList() {
        Administrador administrador1 = new Administrador(1, "John Doe", "johndoe@example.com", null);

        Administrador administrador2 = new Administrador(2, "John Doe", "johndoe@example.com", null);

        List<Administrador> administradores = new ArrayList<>();
        administradores.add(administrador1);
        administradores.add(administrador2);

        when(administradorRepository.getAll()).thenReturn(administradores);

        List<ListAdministradorDto> result = listAllAdministradores.list();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getNome());
        assertEquals("johndoe@example.com", result.get(0).getEmail());
        assertEquals("Jane Doe", result.get(1).getNome());
        assertEquals("janedoe@example.com", result.get(1).getEmail());
    }
}