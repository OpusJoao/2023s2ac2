package com.facens.AC2.Infrastructure.Persistence;

import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AdministradorRepository;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import org.springframework.boot.SpringBootConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration()
public class AdministradorRepositoryImpFalso implements AdministradorRepository {
    private List<Administrador> administradorDb = new ArrayList<>();

    @Override
    public List<Administrador> getAll() {
        return this.administradorDb;
    }

    @Override
    public Administrador create(Administrador administrador) {
        administrador.setId(this.getLastId() + 1);
        this.administradorDb.add(administrador);
        return administrador;
    }

    private long getLastId(){
        if ( this.administradorDb.size() < 1) {
            return 0;
        }
        return this.administradorDb.get(this.administradorDb.size() - 1).getId();
    }
}
