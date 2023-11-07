package com.facens.AC2.Infrastructure.Persistence;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import org.springframework.boot.SpringBootConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration()
public class AlunoRepositoryImpFalso implements AlunoRepository {
    private List<Aluno> alunoDb = new ArrayList<>();

    @Override
    public List<Aluno> getAll() {
        return this.alunoDb;
    }

    @Override
    public Aluno getById(long id) {
        for (Aluno aluno : this.alunoDb) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public Aluno create(Aluno aluno) {
        aluno.setId(this.getLastId() + 1);
        this.alunoDb.add(aluno);
        return aluno;
    }

    private long getLastId(){
        if ( this.alunoDb.size() < 1) {
            return 0;
        }
        return this.alunoDb.get(this.alunoDb.size() - 1).getId();
    }
}
