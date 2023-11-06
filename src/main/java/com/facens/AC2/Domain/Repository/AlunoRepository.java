package com.facens.AC2.Domain.Repository;

import com.facens.AC2.Domain.Entity.Aluno;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository {
    public List<Aluno> getAll();
    public Aluno create(Aluno aluno);

}
