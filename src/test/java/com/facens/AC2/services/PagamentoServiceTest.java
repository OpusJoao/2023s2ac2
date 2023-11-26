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

@RunWith(MockitoJUnitRunner.class)
public class PagamentoServiceTest {
    @Mock
    private PagamentoRepository pagamentoRepository;
    @Mock
    private AlunoRepository alunoRepository;
    @InjectMocks
    private PagamentoService pagamentoService;

    @Test
    public void testCreatePagamentos() {
        CreatePagamentoDto createPagamentoDto = new CreatePagamentoDto();
        createPagamentoDto.setAluno(1L);
        createPagamentoDto.setValor(100.0);

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("João");

        when(alunoRepository.getById(1L)).thenReturn(aluno);

        Pagamento pagamento = pagamentoService.create(createPagamentoDto);

        assertEquals(100.0, pagamento.getValor(), 0.001);
        assertEquals("João", pagamento.getAluno().getNome());
    }

    @Test
    public void testListAllPagamentos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        Pagamento pagamento1 = new Pagamento();
        pagamento1.setId(1L);
        pagamento1.setValor(100.0);
        Pagamento pagamento2 = new Pagamento();
        pagamento2.setId(2L);
        pagamento2.setValor(200.0);
        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);

        when(pagamentoRepository.getAll()).thenReturn(pagamentos);

        List<ListPagamentoDto> listPagamentoDtos = pagamentoService.list();

        assertEquals(2, listPagamentoDtos.size());
        assertEquals(1L, listPagamentoDtos.get(0).getId().longValue());
        assertEquals(100.0, listPagamentoDtos.get(0).getValor(), 0.001);
        assertEquals(2L, listPagamentoDtos.get(1).getId().longValue());
        assertEquals(200.0, listPagamentoDtos.get(1).getValor(), 0.001);
    }
}
