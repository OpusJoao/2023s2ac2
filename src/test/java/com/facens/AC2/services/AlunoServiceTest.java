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

public class AlunoServiceTest {
    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private CreateAluno createAluno;

    @InjectMocks
    private ListAllAlunos listAllAlunos;

    @Test
    public void testCreate() {
        CreateAlunoDto createAlunoDto = new CreateAlunoDto();
        createAlunoDto.setNome("John Doe");
        createAlunoDto.setEmail("johndoe@example.com");

        Aluno aluno = new Aluno();
        aluno.setNome("John Doe");
        aluno.setEmail("johndoe@example.com");

        when(alunoRepository.create(any(Aluno.class))).thenReturn(aluno);

        Aluno result = createAluno.create(createAlunoDto);

        assertEquals("John Doe", result.getNome());
        assertEquals("johndoe@example.com", result.getEmail());
    }

    @Test
    public void testList() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("John Doe");
        aluno1.setEmail("johndoe@example.com");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Jane Doe");
        aluno2.setEmail("janedoe@example.com");

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);

        when(alunoRepository.getAll()).thenReturn(alunos);

        List<ListAlunoDto> result = listAllAlunos.list();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getNome());
        assertEquals("johndoe@example.com", result.get(0).getEmail());
        assertEquals("Jane Doe", result.get(1).getNome());
        assertEquals("janedoe@example.com", result.get(1).getEmail());
    }
}
