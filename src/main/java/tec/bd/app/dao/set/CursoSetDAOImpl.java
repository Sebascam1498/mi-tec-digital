package tec.bd.app.dao.set;

import tec.bd.app.dao.CursoDAO;
import tec.bd.app.database.set.Row;
import tec.bd.app.database.set.SetDB;
import tec.bd.app.domain.Curso;

import java.util.List;

public class CursoSetDAOImpl extends GenericSetDAOImpl<Curso, Integer> implements CursoDAO {

    public CursoSetDAOImpl(SetDB setDB) {
        super(setDB, Curso.class);
    }

    @Override
    public List<Curso> findByDepartment(String department) {
        return null;
    }

    @Override
    protected Curso rowToEntity(Row row) {
        Curso curso = new Curso();
        curso.setId(row.intAttributeValue("id"));
        curso.setNombre(row.stringAttributeValue("nombre"));
        curso.setDepartamento(row.stringAttributeValue("departamento"));
        curso.setCreditos(row.intAttributeValue("creditos"));
        return curso;
    }

    @Override
    protected Row entityToRow(Curso e) {
        return null;
    }
}
