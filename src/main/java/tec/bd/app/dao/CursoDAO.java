package tec.bd.app.dao;

import tec.bd.app.domain.Curso;

import java.util.Optional;

public interface CursoDAO extends GenericDAO<Curso, Integer> {

    Optional<Curso> findByDepartment(String department);

}
