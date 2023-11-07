package com.facens.AC2.Domain.Repository;

import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Entity.Pagamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository {
    List<Pagamento> getAll();
    Pagamento create(Pagamento pagamento);

}
