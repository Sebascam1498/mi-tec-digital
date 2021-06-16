package tec.bd.app.dao.mysql.routine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.app.dao.EstudianteDAO;
import tec.bd.app.dao.mysql.GenericMySqlDAOImpl;
import tec.bd.app.database.mysql.DBProperties;
import tec.bd.app.domain.Estudiante;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EstudianteMySqlDAOImplPro extends GenericMySqlDAOImpl<Estudiante, Integer> implements EstudianteDAO {

    private static final Logger LOG = LoggerFactory.getLogger(tec.bd.app.dao.mysql.CursoMySqlDAOImpl.class);

    private static final String SQL_ALL_STUDENTS = "{call showAllStudents()}";
    private static final String SQL_SORT_STUDENTS = "{call showAllStudentsSort()}";
    private static final String SQL_APELLIDO_STUDENTS = "{call showStudentApellido(?)}";
    private static final String SQL_ID_STUDENTS = "{call showStudentInfo(?)}";
    private static final String SQL_ADD_STUDENTS = "{call addNewStudent(?,?,?,?,?)}";
    private static final String SQL_UPDATE_STUDENTS = "{call updateStudent(?,?,?,?,?)}";
    private static final String SQL_DELETE_STUDENTS = "{call deleteStudent(?)}";

    private final DBProperties dbProperties;

    public EstudianteMySqlDAOImplPro(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public List<Estudiante> findAll(){
        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ALL_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_ALL_STUDENTS);{
                    rs = stat.executeQuery();
                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getString("apellido")+"\t"+rs.getDate("fecha_nacimiento")+"\t"+rs.getInt("total_creditos"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ALL_STUDENTS, e);
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Estudiante> findById(Integer integer){

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ID_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_ID_STUDENTS);{
                    stat.setObject(1,integer);
                    rs = stat.executeQuery();

                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getString("apellido")+"\t"+rs.getDate("fecha_nacimiento")+"\t"+rs.getInt("total_creditos"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ID_STUDENTS, e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Estudiante estudiante) {

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ADD_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_ADD_STUDENTS);
                {
                    stat.setObject(1, estudiante.getId());
                    stat.setObject(2, estudiante.getNombre());
                    stat.setObject(3, estudiante.getApellido());
                    stat.setObject(4, estudiante.getFechaNacimiento());
                    stat.setObject(5, estudiante.getTotalCreditos());
                    stat.executeQuery();
                    System.out.println("Curso agregado");

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ADD_STUDENTS, e);
        }
    }


        @Override
    public Optional<Estudiante> update(Estudiante estudiante) {

            try {
                try (Connection connection = this.dbProperties.getConnection()) {
                    LOG.info(SQL_UPDATE_STUDENTS);
                    CallableStatement stat = connection.prepareCall(SQL_UPDATE_STUDENTS);{
                        stat.setObject(1, estudiante.getId());
                        stat.setObject(2, estudiante.getNombre());
                        stat.setObject(3, estudiante.getApellido());
                        stat.setObject(4, estudiante.getFechaNacimiento());
                        stat.setObject(5, estudiante.getTotalCreditos());
                        stat.executeQuery();
                        System.out.println("Estudiante actualizado");

                    }
                }
            } catch (SQLException e) {
                LOG.error("Error when running {}", SQL_UPDATE_STUDENTS, e);
            }

            return Optional.empty();
        }

    @Override
    public void delete(Integer integer) {
            System.out.println(" eliminado");
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_DELETE_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_DELETE_STUDENTS);{
                    stat.setObject(1,integer);
                    stat.executeQuery();
                    System.out.println("Estudiante eliminado");

                }
            }
            catch (SQLException e) {
                LOG.error("Error when running {}", SQL_DELETE_STUDENTS, e);
            }
        }

    @Override
    public List<Estudiante> findByLastName(String lastName){

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_APELLIDO_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_APELLIDO_STUDENTS);{
                    stat.setObject(1,lastName);
                    rs = stat.executeQuery();

                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getString("apellido")+"\t"+rs.getDate("fecha_nacimiento")+"\t"+rs.getInt("total_creditos"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_APELLIDO_STUDENTS, e);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Estudiante> findAllSortByLastName(){
        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_SORT_STUDENTS);
                CallableStatement stat = connection.prepareCall(SQL_SORT_STUDENTS);{
                    rs = stat.executeQuery();
                    while (rs.next()){
                        System.out.println(rs.getInt("id")+"\t"+ rs.getString("nombre")+"\t"+rs.getString("apellido")+"\t"+rs.getDate("fecha_nacimiento")+"\t"+rs.getInt("total_creditos"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_SORT_STUDENTS, e);
        }

        return Collections.emptyList();
    }

    @Override
    protected Estudiante resultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Estudiante> resultSetToList(ResultSet resultSet) throws SQLException {
        return null;
    }
}
