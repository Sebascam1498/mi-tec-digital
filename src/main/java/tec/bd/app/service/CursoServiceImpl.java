package tec.bd.app.service;

import tec.bd.app.dao.CursoDAO;
import tec.bd.app.domain.Curso;

import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService {

    private CursoDAO cursoDAO;

    public CursoServiceImpl(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }


    @Override
    public List<Curso> getAll() {
        return this.cursoDAO.findAll();
    }

    @Override
    public Optional<Curso> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void addNew(Curso c) {

    }

    @Override
    public Optional<Curso> updateCourse(Curso c) {
        return Optional.empty();
    }

    @Override
    public void deleteCourse(int in) {

    }

    @Override
    public List<Curso> getByDepartment(String department) {
        // validar si department es nulo o vacio. Si NO es nulo o vacio se va a poder llamar al DAO
        // sino, se retorna una lista vacia

        return this.cursoDAO.findByDepartment(department);
    }
}
