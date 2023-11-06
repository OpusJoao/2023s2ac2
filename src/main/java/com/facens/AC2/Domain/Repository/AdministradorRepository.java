package com.facens.AC2.Domain.Repository;

import com.facens.AC2.Domain.Entity.Administrador;
import com.facens.AC2.Domain.Entity.Aluno;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository {
    List<Administrador> getAll();
    Administrador create(Administrador administrador);

}
