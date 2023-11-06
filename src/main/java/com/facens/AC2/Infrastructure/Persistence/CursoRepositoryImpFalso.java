package com.facens.AC2.Infrastructure.Persistence;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Repository.AlunoRepository;
import com.facens.AC2.Domain.Repository.CursoRepository;
import org.springframework.boot.SpringBootConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration()
public class CursoRepositoryImpFalso implements CursoRepository {
    private List<Curso> cursoDb = new ArrayList<>();

    @Override
    public List<Curso> getAll() {
        return this.cursoDb;
    }

    @Override
    public Curso create(Curso curso) {
        curso.setId(this.getLastId() + 1);
        this.cursoDb.add(curso);
        return curso;
    }

    private long getLastId(){
        if ( this.cursoDb.size() < 1) {
            return 0;
        }
        return this.cursoDb.get(this.cursoDb.size() - 1).getId();
    }
}
