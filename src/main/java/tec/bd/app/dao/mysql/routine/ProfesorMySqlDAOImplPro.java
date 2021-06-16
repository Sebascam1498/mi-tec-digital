package tec.bd.app.dao.mysql.routine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.app.dao.ProfesorDAO;
import tec.bd.app.dao.mysql.GenericMySqlDAOImpl;
import tec.bd.app.database.mysql.DBProperties;
import tec.bd.app.domain.Profesor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProfesorMySqlDAOImplPro extends GenericMySqlDAOImpl<Profesor, Integer> implements ProfesorDAO {

    private static final Logger LOG = LoggerFactory.getLogger(tec.bd.app.dao.mysql.CursoMySqlDAOImpl.class);

    private static final String SQL_ALL_PROFESORES = "{call showAllProfesores()}";
    private static final String SQL_CUIDAD_PROFESORES = "{call showProfesorCuidad(?)}";
    private static final String SQL_ID_PROFESORES = "{call showProfesorInfo(?)}";
    private static final String SQL_ADD_PROFESORES = "{call addNewProfesor(?,?,?,?,?,?}";
    private static final String SQL_UPDATE_PROFESORES = "{call updateProfesor(?,?,?,?,?,?)}";
    private static final String SQL_DELETE_PROFESORES = "{call deleteProfesor(?)}";

    private final DBProperties dbProperties;

    public ProfesorMySqlDAOImplPro(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
    }


    @Override
    public List<Profesor> findAll() {
        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ALL_PROFESORES);
                CallableStatement stat = connection.prepareCall(SQL_ALL_PROFESORES);
                {
                    rs = stat.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" + rs.getString("apellido") + "\t" + rs.getInt("sueldo")+ "\t" + rs.getString("departamento")+ "\t" + rs.getString("cuidad"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ALL_PROFESORES, e);
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Profesor> findById(Integer integer) {

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ID_PROFESORES);
                CallableStatement stat = connection.prepareCall(SQL_ID_PROFESORES);
                {
                    stat.setObject(1, integer);
                    rs = stat.executeQuery();

                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" + rs.getString("apellido") + "\t" + rs.getInt("sueldo")+ "\t" + rs.getString("departamento")+ "\t" + rs.getString("cuidad"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ID_PROFESORES, e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Profesor profesor) {

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_ADD_PROFESORES);
                CallableStatement stat = connection.prepareCall(SQL_ADD_PROFESORES);
                {
                    stat.setObject(1, profesor.getId());
                    stat.setObject(2, profesor.getNombre());
                    stat.setObject(3, profesor.getApellido());
                    stat.setObject(4, profesor.getSueldo());
                    stat.setObject(5, profesor.getDeparamento());
                    stat.setObject(6, profesor.getCuidad());
                    stat.executeQuery();
                    System.out.println("Curso agregado");

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_ADD_PROFESORES, e);
        }


    }

    @Override
    public Optional<Profesor> update(Profesor profesor) {

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_UPDATE_PROFESORES);
                CallableStatement stat = connection.prepareCall(SQL_UPDATE_PROFESORES);{
                    stat.setObject(1, profesor.getId());
                    stat.setObject(2, profesor.getNombre());
                    stat.setObject(3, profesor.getApellido());
                    stat.setObject(4, profesor.getSueldo());
                    stat.setObject(5, profesor.getDeparamento());
                    stat.setObject(6, profesor.getCuidad());
                    stat.executeQuery();
                    System.out.println("Profesor actualizado");

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_UPDATE_PROFESORES, e);
        }

        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {
        System.out.println(" eliminado");
        try (Connection connection = this.dbProperties.getConnection()) {
            LOG.info(SQL_DELETE_PROFESORES);
            CallableStatement stat = connection.prepareCall(SQL_DELETE_PROFESORES);{
                stat.setObject(1,integer);
                stat.executeQuery();
                System.out.println("Profesor eliminado");

            }
        }
        catch (SQLException e) {
            LOG.error("Error when running {}", SQL_DELETE_PROFESORES, e);
        }
    }

    @Override
    public Optional<Profesor> findByCuidad(String cuidad) {

        ResultSet rs;

        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_CUIDAD_PROFESORES);
                CallableStatement stat = connection.prepareCall(SQL_CUIDAD_PROFESORES);{
                    stat.setObject(1,cuidad);
                    rs = stat.executeQuery();

                    while (rs.next()){
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("nombre") + "\t" + rs.getString("apellido") + "\t" + rs.getInt("sueldo")+ "\t" + rs.getString("departamento")+ "\t" + rs.getString("cuidad"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_CUIDAD_PROFESORES, e);
        }

        return Optional.empty();
    }

    @Override
    protected Profesor resultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Profesor> resultSetToList(ResultSet resultSet) throws SQLException {
        return null;
    }
}