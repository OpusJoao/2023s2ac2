package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Curso.CreateCurso;
import com.facens.AC2.Application.UseCase.Curso.ListAllCursos;
import com.facens.AC2.Presentation.Dto.Curso.CreateCursoDto;
import com.facens.AC2.Presentation.Dto.Curso.ListCursoDto;
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
@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CursoController cursoController;

    @MockBean
    private ListAllCursos listAllCursos;

    @MockBean
    private CreateCurso createCurso;

    @Test
    public void testGetAllCursos() throws Exception {
        List<ListCursoDto> cursos = new ArrayList<>();
        cursos.add(new ListCursoDto(1L, "Engenharia de Software", "2022-08-01", "2026-07-31"));
        cursos.add(new ListCursoDto(2L, "Ciência da Computação", "2022-08-01", "2026-07-31"));

        when(listAllCursos.list()).thenReturn(cursos);

        mockMvc.perform(get("/curso/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Engenharia de Software")))
                .andExpect(jsonPath("$[0].dataInicio", is("2022-08-01")))
                .andExpect(jsonPath("$[0].dataFim", is("2026-07-31")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Ciência da Computação")))
                .andExpect(jsonPath("$[1].dataInicio", is("2022-08-01")))
                .andExpect(jsonPath("$[1].dataFim", is("2026-07-31")));
    }

    @Test
    public void testCreateCurso() throws Exception {
        CreateCursoDto cursoDto = new CreateCursoDto();
        cursoDto.setNome("Engenharia de Software");
        cursoDto.setDataInicio("2022-08-01");
        cursoDto.setDataFim("2026-07-31");

        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Engenharia de Software");
        curso.setDataInicio(LocalDate.parse("2022-08-01"));
        curso.setDataFim(LocalDate.parse("2026-07-31"));

        when(createCurso.create(cursoDto)).thenReturn(curso);

        mockMvc.perform(post("/curso/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cursoDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Engenharia de Software")))
                .andExpect(jsonPath("$.dataInicio", is("2022-08-01")))
                .andExpect(jsonPath("$.dataFim", is("2026-07-31")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}