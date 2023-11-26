package com.facens.AC2.Application.UseCase;

import com.facens.AC2.Application.UseCase.Administrador.CreateAdministrador;
import com.facens.AC2.Application.UseCase.Administrador.ListAllAdministradores;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAdministradorDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListAdministradorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

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
        CreateAdministradorDto createAdministradorDto = new CreateAdministradorDto();
        createAdministradorDto.setNome("John Doe");
        createAdministradorDto.setEmail("johndoe@example.com");

        Administrador administrador = new Administrador();
        administrador.setNome("John Doe");
        administrador.setEmail("johndoe@example.com");

        when(administradorRepository.create(any(Administrador.class))).thenReturn(administrador);

        CreateAdministradorDto result = createAdministrador.create(createAdministradorDto);

        assertEquals("John Doe", result.getNome());
        assertEquals("johndoe@example.com", result.getEmail());
    }

    @Test
    public void testList() {
        Administrador administrador1 = new Administrador();
        administrador1.setNome("John Doe");
        administrador1.setEmail("johndoe@example.com");

        Administrador administrador2 = new Administrador();
        administrador2.setNome("Jane Doe");
        administrador2.setEmail("janedoe@example.com");

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