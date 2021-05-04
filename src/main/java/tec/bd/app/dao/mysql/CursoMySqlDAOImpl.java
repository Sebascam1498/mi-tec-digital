package tec.bd.app.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.app.dao.CursoDAO;
import tec.bd.app.database.mysql.DBProperties;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Estudiante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CursoMySqlDAOImpl extends GenericMySqlDAOImpl<Curso, Integer> implements CursoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CursoMySqlDAOImpl.class);

    private static final String SQL_SELECT_CURSOS = "select id, nombre, creditos, departamento from curso;";

    private final DBProperties dbProperties;

    public CursoMySqlDAOImpl(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public List<Curso> findByDepartment(String department) {
        return null;
    }

    @Override
    public List<Curso> findAll() {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_SELECT_CURSOS);
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    try (ResultSet rs = stmt.executeQuery(SQL_SELECT_CURSOS)) {
                        return this.resultSetToList(rs);
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_SELECT_CURSOS, e);
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Curso> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void save(Curso curso) {

    }

    @Override
    public Optional<Curso> update(Curso curso) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    protected Curso resultSetToEntity(ResultSet resultSet) throws SQLException {
        var id = resultSet.getInt("id");
        var nombre = resultSet.getString("nombre");
        var creditos = resultSet.getInt("creditos");
        var departamento = resultSet.getString("departamento");

        return new Curso(id, nombre, creditos, departamento);
    }

    @Override
    protected List<Curso> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        while(resultSet.next()) {
            cursos.add(this.resultSetToEntity(resultSet));
        }
        return cursos;
    }
}
