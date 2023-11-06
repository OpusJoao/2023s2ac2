package com.facens.AC2.Domain.Repository;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository {
    List<Curso> getAll();
    Curso create(Curso curso);

}
