package tec.bd.app.service;

import tec.bd.app.dao.ProfesorDAO;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {

    List<Profesor> getAll();

    Optional<Profesor> getById(int id);

    void addNew(ProfesorDAO p);

    Optional<Curso> updateProfessor(Profesor p);

    void deleteProfessor(int id);

    // nuevo metodo para ver los profesores por ciudad
}
