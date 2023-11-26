package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Administrador.CreateAluno;
import com.facens.AC2.Application.UseCase.Administrador.ListAllAlunos;
import com.facens.AC2.Presentation.Dto.Administrador.CreateAlunoDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListAlunoDto;
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

@RunWith(SpringRunner.class)
@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoController alunoController;

    @MockBean
    private ListAllAlunos listAllAlunos;

    @MockBean
    private CreateAluno createAluno;

    @Test
    public void testGetAllAlunos() throws Exception {
        List<ListAlunoDto> alunos = new ArrayList<>();
        alunos.add(new ListAlunoDto(1L, "João", "12345678901", "joao@example.com"));
        alunos.add(new ListAlunoDto(2L, "Maria", "23456789012", "maria@example.com"));

        when(listAllAlunos.list()).thenReturn(alunos);

        mockMvc.perform(get("/aluno/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("João")))
                .andExpect(jsonPath("$[0].cpf", is("12345678901")))
                .andExpect(jsonPath("$[0].email", is("joao@example.com")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Maria")))
                .andExpect(jsonPath("$[1].cpf", is("23456789012")))
                .andExpect(jsonPath("$[1].email", is("maria@example.com")));
    }

    @Test
    public void testCreateAluno() throws Exception {
        CreateAlunoDto alunoDto = new CreateAlunoDto();
        alunoDto.setNome("João");
        alunoDto.setCpf("12345678901");
        alunoDto.setEmail("joao@example.com");

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("João");
        aluno.setCpf("12345678901");
        aluno.setEmail("joao@example.com");

        when(createAluno.create(alunoDto)).thenReturn(aluno);

        mockMvc.perform(post("/aluno/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(alunoDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("João")))
                .andExpect(jsonPath("$.cpf", is("12345678901")))
                .andExpect(jsonPath("$.email", is("joao@example.com")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}