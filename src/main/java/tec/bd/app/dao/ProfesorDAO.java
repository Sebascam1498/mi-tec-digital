package tec.bd.app.dao;

import tec.bd.app.domain.Estudiante;
import tec.bd.app.domain.Profesor;

import java.util.Optional;

public interface ProfesorDAO extends GenericDAO<Profesor, Integer> {

    // un nuevo metodo para buscar por ciudad

    Optional<Profesor> findByCuidad(String cuidad);
}
