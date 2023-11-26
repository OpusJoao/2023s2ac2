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

public class CursoServiceTest {
    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CreateCurso createCurso;

    @InjectMocks
    private ListAllCursos listAllCursos;

    @Test
    public void testCreate() {
        CreateCursoDto createCursoDto = new CreateCursoDto();
        createCursoDto.setNome("Java");
        createCursoDto.setDescricao("Curso de Java");

        Curso curso = new Curso();
        curso.setNome("Java");
        curso.setDescricao("Curso de Java");

        when(cursoRepository.create(any(Curso.class))).thenReturn(curso);

        Curso result = createCurso.create(createCursoDto);

        assertEquals("Java", result.getNome());
        assertEquals("Curso de Java", result.getDescricao());
    }

    @Test
    public void testList() {
        Curso curso1 = new Curso();
        curso1.setNome("Java");
        curso1.setDescricao("Curso de Java");

        Curso curso2 = new Curso();
        curso2.setNome("Python");
        curso2.setDescricao("Curso de Python");

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);

        when(cursoRepository.getAll()).thenReturn(cursos);

        List<ListCursoDto> result = listAllCursos.list();

        assertEquals(2, result.size());
        assertEquals("Java", result.get(0).getNome());
        assertEquals("Curso de Java", result.get(0).getDescricao());
        assertEquals("Python", result.get(1).getNome());
        assertEquals("Curso de Python", result.get(1).getDescricao());
    }
}
