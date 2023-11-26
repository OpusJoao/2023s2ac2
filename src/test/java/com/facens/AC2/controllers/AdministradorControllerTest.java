package com.facens.AC2.Presentation.Controller;

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

public class AdministradorControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private ListAllAdministradores listAllAdministradores;

    @Mock
    private CreateAdministrador createAdministrador;

    @InjectMocks
    private AdministradorController administradorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(administradorController).build();
    }

    @Test
    public void testGetAllAdministradores() throws Exception {
        List<ListAdministradorDto> administradores = new ArrayList<>();
        administradores.add(new ListAdministradorDto(1L, "João", "joao@gmail.com"));
        administradores.add(new ListAdministradorDto(2L, "Maria", "maria@gmail.com"));

        when(listAllAdministradores.list()).thenReturn(administradores);

        mockMvc.perform(MockMvcRequestBuilders.get("/administrador/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("João"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("joao@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Maria"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("maria@gmail.com"));
    }

    @Test
    public void testCreateAdministrador() throws Exception {
        CreateAdministradorDto administrador = new CreateAdministradorDto("João", "joao@gmail.com");

        when(createAdministrador.create(administrador)).thenReturn(administrador);

        mockMvc.perform(MockMvcRequestBuilders.post("/administrador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"João\",\"email\":\"joao@gmail.com\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@gmail.com"));
    }
}