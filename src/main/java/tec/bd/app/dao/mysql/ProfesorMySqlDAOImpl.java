package tec.bd.app.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.app.dao.ProfesorDAO;
import tec.bd.app.database.mysql.DBProperties;
import tec.bd.app.domain.Estudiante;
import tec.bd.app.domain.Profesor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProfesorMySqlDAOImpl extends GenericMySqlDAOImpl<Profesor, Integer> implements ProfesorDAO {


    private static final Logger LOG = LoggerFactory.getLogger(ProfesorMySqlDAOImpl.class);

    private final DBProperties dbProperties;

    private static final String SQL_SELECT_PROFESOR = "select id, nombre, apellido, sueldo, departamento,cuidad from profesor;";
    private static final String SQL_SELECT_PROFESOR_CUIDAD = "select id, nombre, apellido, sueldo, departamento,cuidad from profesor where cuidad = '%s'";
    private static final String SQL_SELECT_PROFESOR_ID = "select id, nombre, apellido, sueldo, departamento,cuidad from profesor where id = %d";
    private static final String SQL_INSERT_PROFESOR = "insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(%d, '%s', '%s', %d, '%s','%s')";
    private static final String SQL_UPDATE_PROFESOR = "update profesor set nombre = '%s', apellido = '%s', sueldo = %d, departamento = '%s',cuidad = '%s' where id = %d";
    private static final String SQL_DELETE_PROFESOR = "delete from profesor where id = %d";

    public ProfesorMySqlDAOImpl(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public List<Profesor> findAll() {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                LOG.info(SQL_SELECT_PROFESOR);
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    try (ResultSet rs = stmt.executeQuery(SQL_SELECT_PROFESOR)) {
                        return this.resultSetToList(rs);
                    }

                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_SELECT_PROFESOR, e);
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    var sql = String.format(SQL_SELECT_PROFESOR_ID, id);
                    LOG.info(sql);
                    try (ResultSet rs = stmt.executeQuery(sql)) {
                        return this.resultSetToList(rs).stream().findFirst();
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_SELECT_PROFESOR_ID, e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Profesor profesor) {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    var sql = String.format(SQL_INSERT_PROFESOR,
                            profesor.getId(),
                            profesor.getNombre(),
                            profesor.getApellido(),
                            profesor.getSueldo(),
                            profesor.getDeparamento(),
                            profesor.getCuidad()
                    );
                    LOG.info(sql);
                    int rowCount = stmt.executeUpdate(sql);
                    LOG.debug("{} fila agregada", rowCount);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_INSERT_PROFESOR, e);
        }

    }

    @Override
    public Optional<Profesor> update(Profesor profesor) {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    var sql = String.format(SQL_UPDATE_PROFESOR,
                            profesor.getId(),
                            profesor.getNombre(),
                            profesor.getApellido(),
                            profesor.getSueldo(),
                            profesor.getDeparamento(),
                            profesor.getCuidad()
                    );
                    LOG.info(sql);
                    int rowCount = stmt.executeUpdate(sql);
                    LOG.debug("{} fila actualizada", rowCount);
                    if(rowCount == 1) {
                        return Optional.of(profesor);
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_UPDATE_PROFESOR, e);
        }

        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    var sql = String.format(SQL_DELETE_PROFESOR, id);
                    LOG.info(sql);
                    int rowCount = stmt.executeUpdate(sql);
                    LOG.debug("{} fila borrada", rowCount);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_DELETE_PROFESOR, e);
        }

    }

    @Override
    public Optional<Profesor> findByCuidad(String cuidad) {
        try {
            try (Connection connection = this.dbProperties.getConnection()) {
                try (Statement stmt = connection.createStatement()) {
                    //execute query
                    var sql = String.format(SQL_SELECT_PROFESOR_CUIDAD, cuidad);
                    LOG.info(sql);
                    try (ResultSet rs = stmt.executeQuery(sql)) {
                        return this.resultSetToList(rs).stream().findFirst();
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error("Error when running {}", SQL_SELECT_PROFESOR_CUIDAD, e);
        }

        return Optional.empty();
    }

    @Override
    protected Profesor resultSetToEntity(ResultSet resultSet) throws SQLException {
        var id = resultSet.getInt("id");
        var nombre = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var sueldo = resultSet.getInt("sueldo");
        var departamento = resultSet.getString("departamento");
        var cuidad = resultSet.getString("cuidad");
        return new Profesor(id, nombre, apellido, sueldo, departamento,cuidad);
    }

    @Override
    protected List<Profesor> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Profesor> profesor = new ArrayList<>();
        while(resultSet.next()) {
            profesor.add(this.resultSetToEntity(resultSet));
        }
        return profesor;
    }

}
