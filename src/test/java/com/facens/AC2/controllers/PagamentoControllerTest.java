package com.facens.AC2.Presentation.Controller;

import com.facens.AC2.Application.UseCase.Pagamento.CreatePagamentos;
import com.facens.AC2.Application.UseCase.Pagamento.ListAllPagamentos;
import com.facens.AC2.Presentation.Dto.Pagamento.CreatePagamentoDto;
import com.facens.AC2.Presentation.Dto.Administrador.ListPagamentoDto;
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
@WebMvcTest(PagamentoController.class)
public class PagamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PagamentoController pagamentoController;

    @MockBean
    private ListAllPagamentos listAllPagamentos;

    @MockBean
    private CreatePagamentos createPagamentos;

    @Test
    public void testGetAllPagamentos() throws Exception {
        List<ListPagamentoDto> pagamentos = new ArrayList<>();
        pagamentos.add(new ListPagamentoDto(1L, "12345678901", "2022-08-01", 1000.0));
        pagamentos.add(new ListPagamentoDto(2L, "23456789012", "2022-08-01", 2000.0));

        when(listAllPagamentos.list()).thenReturn(pagamentos);

        mockMvc.perform(get("/pagamento/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].cpf", is("12345678901")))
                .andExpect(jsonPath("$[0].data", is("2022-08-01")))
                .andExpect(jsonPath("$[0].valor", is(1000.0)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].cpf", is("23456789012")))
                .andExpect(jsonPath("$[1].data", is("2022-08-01")))
                .andExpect(jsonPath("$[1].valor", is(2000.0)));
    }

    @Test
    public void testCreatePagamento() throws Exception {
        CreatePagamentoDto pagamentoDto = new CreatePagamentoDto();
        pagamentoDto.setCpf("12345678901");
        pagamentoDto.setData("2022-08-01");
        pagamentoDto.setValor(1000.0);

        Pagamento pagamento = new Pagamento();
        pagamento.setId(1L);
        pagamento.setCpf("12345678901");
        pagamento.setData(LocalDate.parse("2022-08-01"));
        pagamento.setValor(1000.0);

        when(createPagamentos.create(pagamentoDto)).thenReturn(pagamento);

        mockMvc.perform(post("/pagamento/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(pagamentoDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.cpf", is("12345678901")))
                .andExpect(jsonPath("$.data", is("2022-08-01")))
                .andExpect(jsonPath("$.valor", is(1000.0)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}