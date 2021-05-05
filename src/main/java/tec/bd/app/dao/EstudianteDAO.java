package tec.bd.app.dao;

import tec.bd.app.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteDAO extends GenericDAO<Estudiante, Integer> {

    /**
     * Obtener todos los estudiantes por apellido
     * @param lastName
     * @return
     */
    Optional<Estudiante> findByLastName(String lastName);

    /**
     * Listar todos los nombre de los estudiantes ordenados por apellido
     * @return
     */
    List<Estudiante> findAllSortByLastName();


}
