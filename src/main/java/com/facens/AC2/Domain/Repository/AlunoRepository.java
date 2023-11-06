package com.facens.AC2.Domain.Repository;

import com.facens.AC2.Domain.Entity.Aluno;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository {
    List<Aluno> getAll();
    Aluno create(Aluno aluno);

}
