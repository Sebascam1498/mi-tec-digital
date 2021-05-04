package tec.bd.app.service;

import tec.bd.app.dao.ProfesorDAO;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Profesor;

import java.util.List;
import java.util.Optional;

public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorDAO profesorDAO;

    public ProfesorServiceImpl(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    @Override
    public List<Profesor> getAll() {
        return null;
    }

    @Override
    public Optional<Profesor> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void addNew(ProfesorDAO p) {

    }

    @Override
    public Optional<Curso> updateProfessor(Profesor p) {
        return Optional.empty();
    }

    @Override
    public void deleteProfessor(int id) {

    }
}
