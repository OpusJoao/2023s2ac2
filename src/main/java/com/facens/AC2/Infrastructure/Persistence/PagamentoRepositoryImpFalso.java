package com.facens.AC2.Infrastructure.Persistence;

import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Entity.Pagamento;
import com.facens.AC2.Domain.Repository.CursoRepository;
import com.facens.AC2.Domain.Repository.PagamentoRepository;
import org.springframework.boot.SpringBootConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration()
public class PagamentoRepositoryImpFalso implements PagamentoRepository {
    private List<Pagamento> pagamentoDb = new ArrayList<>();

    @Override
    public List<Pagamento> getAll() {
        return this.pagamentoDb;
    }

    @Override
    public Pagamento create(Pagamento pagamento) {
        pagamento.setId(this.getLastId() + 1);
        this.pagamentoDb.add(pagamento);
        return pagamento;
    }

    private long getLastId(){
        if ( this.pagamentoDb.size() < 1) {
            return 0;
        }
        return this.pagamentoDb.get(this.pagamentoDb.size() - 1).getId();
    }
}
