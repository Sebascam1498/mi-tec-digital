package tec.bd.app.service;

import tec.bd.app.dao.ProfesorDAO;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Estudiante;
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
        return this.profesorDAO.findAll();
    }

    @Override
    public Optional<Profesor> getById(int id) {
        //TODO: validar el carne > 0. Si no cumple con eso se devuelve Optional.empty()
        if(id > 0) {
            return this.profesorDAO.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public void addNew(Profesor p) {
        Optional<Profesor> profesor = this.profesorDAO.findById(p.getId());
        if(!profesor.isPresent()) {
            this.profesorDAO.save(p);
        }
        else{
            System.out.println("Ya existe ese Id");
        }

    }

    @Override
    public Optional<Profesor> updateProfessor(Profesor p) {
        if(this.getById(p.getId()).isPresent()) {
            return this.profesorDAO.update(p);
        }
        return Optional.empty();
    }


    @Override
    public void deleteProfessor(int id) {
        //TODO: validar que el carne exista en la BD. Si existe se borra
        if (getById(id).isPresent()){
            this.profesorDAO.delete(id);
        }
        else {
            System.out.println("No existe en la base de datos");
        }

    }

    @Override
    public Optional<Profesor> getProfesorByCuidad(String cuidad) {
        return this.profesorDAO.findByCuidad(cuidad);
    }
}
