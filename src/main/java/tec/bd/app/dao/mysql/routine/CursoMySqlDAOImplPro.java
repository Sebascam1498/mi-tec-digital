package tec.bd.app.dao.mysql.routine;

import org.h2.command.dml.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.app.dao.CursoDAO;
import tec.bd.app.dao.mysql.GenericMySqlDAOImpl;
import tec.bd.app.database.mysql.DBProperties;
import tec.bd.app.domain.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CursoMySqlDAOImplPro extends GenericMySqlDAOImpl<Curso,Integer> implements CursoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(tec.bd.app.dao.mysql.CursoMySqlDAOImpl.class);

    private static final String SQL_ALL_CURSOS = "{call showAllCourses()}";
    private static final String SQL_ID_CURSO = "{call showCursoInfo(?)}";
    private static final String SQL_DEPARTAMENTO_CURSO = "{call showCursoDepartamento(?)}";
    private static final String SQL_ADD_CURSO = "{call addNewCurso(?,?,?,?)}";
    private static final String SQL_UPDATE_CURSO = "{call updateCurso(?,?,?,?)}";
    private static final String SQL_DELETE_CURSO = "{call deleteCurso(?)}";



    private final DBProperties dbProperties;

    public CursoMySqlDAOImplPro(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public List<Curso> findByDepartment(String department){

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_DEPARTAMENTO_CURSO);
                CallableStatement stat = connection.prepareCall(SQL_DEPARTAMENTO_CURSO);{
                    stat.setObject(1,department);
                    rs = stat.executeQuery();
                    System.out.println("\n\n");
                    System.out.println("Lista de Cursos");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("ID\t\tNombre\t\tCreditos\tDepartamento");
                    System.out.println("-----------------------------------------------------------------------");

                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getInt("creditos")+"\t"+rs.getString("departamento"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_DEPARTAMENTO_CURSO, e);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Curso> findAll() {
        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ALL_CURSOS);
                CallableStatement stat = connection.prepareCall(SQL_ALL_CURSOS);{
                    rs = stat.executeQuery();
                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getInt("creditos")+"\t"+rs.getString("departamento"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ALL_CURSOS, e);
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Curso> findById(Integer integer) {

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ID_CURSO);
                CallableStatement stat = connection.prepareCall(SQL_ID_CURSO);{
                    stat.setObject(1,integer);
                    rs = stat.executeQuery();

                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getInt("creditos")+"\t"+rs.getString("departamento"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ID_CURSO, e);
        }

        return Optional.empty();
    }



    @Override
    public void save(Curso curso) {

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ADD_CURSO);
                CallableStatement stat = connection.prepareCall(SQL_ADD_CURSO);{
                    stat.setObject(1,curso.getId());
                    stat.setObject(2,curso.getNombre());
                    stat.setObject(3,curso.getNombre());
                    stat.setObject(4,curso.getCreditos());
                    stat.executeQuery();
                    System.out.println("Curso agregado");

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ADD_CURSO, e);
        }

    }

    @Override
    public Optional<Curso> update(Curso curso) {

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_UPDATE_CURSO);
                CallableStatement stat = connection.prepareCall(SQL_UPDATE_CURSO);{
                    stat.setObject(1,curso.getId());
                    stat.setObject(2,curso.getNombre());
                    stat.setObject(3,curso.getNombre());
                    stat.setObject(4,curso.getCreditos());
                    stat.executeQuery();
                    System.out.println("Curso actualizado");

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_UPDATE_CURSO, e);
        }

        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {
        System.out.println(" eliminado");
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_DELETE_CURSO);
                CallableStatement stat = connection.prepareCall(SQL_DELETE_CURSO);{
                    stat.setObject(1,integer);
                    stat.executeQuery();
                    System.out.println("Curso eliminado");

                }
            }
        catch (SQLException e) {
            LOG.error("Error when running {}", SQL_DELETE_CURSO, e);
        }
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
