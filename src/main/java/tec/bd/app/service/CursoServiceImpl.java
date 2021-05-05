package tec.bd.app.service;

import tec.bd.app.dao.CursoDAO;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Estudiante;

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
        //TODO: validar el carne > 0. Si no cumple con eso se devuelve Optional.empty()
        if(id > 0) {
            return this.cursoDAO.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public void addNew(Curso c) {
        Optional<Curso> curso = this.cursoDAO.findById(c.getId());
        if(!curso.isPresent()) {
            this.cursoDAO.save(c);
        }
        else{
            System.out.println("Ya existe ese Id");
        }

    }

    @Override
    public Optional<Curso> updateCourse(Curso c) {
        //TODO: validar que el carne exista en la BD. Si existe se actualiza
        if(this.getById(c.getId()).isPresent()) {
            return this.cursoDAO.update(c);
        }
        return Optional.empty();
    }

    @Override
    public void deleteCourse(int id) {
        //TODO: validar que el carne exista en la BD. Si existe se borra
        if (getById(id).isPresent()){
            this.cursoDAO.delete(id);
        }
        else {
            System.out.println("No existe en la base de datos");
        }

    }

    @Override
    public Optional<Curso> getByDepartment(String department) {
        // validar si department es nulo o vacio. Si NO es nulo o vacio se va a poder llamar al DAO
        // sino, se retorna una lista vacia

        return this.cursoDAO.findByDepartment(department);
    }
}
