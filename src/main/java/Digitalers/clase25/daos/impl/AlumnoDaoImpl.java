package Digitalers.clase25.daos.impl;

import Digitalers.clase25.daos.interfaces.ConexionMySql;
import Digitalers.clase25.daos.interfaces.DAO;
import Digitalers.clase25.entities.Alumno;

import java.sql.*;
import java.util.List;

public class AlumnoDaoImpl implements DAO<Alumno, Long>, ConexionMySql {

    @Override
    public Alumno buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Alumno> buscarTodos() {
        return List.of();
    }

    @Override
    public boolean insertar(Alumno alumno) throws SQLException {
        Connection conn = getConexion();
        try {
            conn.setAutoCommit(false);
            String sqlInsertPersona = "INSERT INTO PERSONAS (NOMBRE, APELLIDO, DOCUMENTO, DIRECCION, TELEFONO, CORREO) VALUES (?,?,?,?,?,?)"; //incompleto
            PreparedStatement preparedStatementPersona = conn.prepareStatement(sqlInsertPersona,  Statement.RETURN_GENERATED_KEYS);
            preparedStatementPersona.setString(1, alumno.getNombre());
            preparedStatementPersona.setString(2, alumno.getApellido());
            preparedStatementPersona.setString(3, alumno.getDocumento());
            preparedStatementPersona.setString(4, alumno.getDireccion());
            preparedStatementPersona.setString(5, alumno.getTelefono());
            preparedStatementPersona.setString(6, alumno.getCorreo());
            preparedStatementPersona.executeUpdate();
            ResultSet personResulser = preparedStatementPersona.getGeneratedKeys();
            Long idPersona = null;
            if (personResulser.next()) {
                idPersona = personResulser.getLong(1);
            } else {
                throw new SQLException("No se pudo obtener el ID generado");
            }
            //Obtener el id de la persona creada
            //            = resultSetPersona.getLong("id");
            //User ese id para el campo persona_fk
            String sqlInsertAlumno = "INSERT INTO ESTUDIANTE (PERSONA_FK, LEGAJO) VALUES (?,?)";
            PreparedStatement preparedStatementAlumno = conn.prepareStatement(sqlInsertAlumno);
            preparedStatementAlumno.setLong(1, (long) idPersona);
            preparedStatementAlumno.setLong(2, alumno.getLegajo());
            //Insertar el alumno
            preparedStatementAlumno.execute();
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            return false;
        }
    }

    @Override
    public boolean eleminar(Alumno entidad) {
        return false;
    }

    @Override
    public boolean eleminarPorId(Long id) {
        return false;
    }

    @Override
    public boolean actualizar(Alumno entidad) {
        return false;
    }

    public Alumno buscarPorLegajo(Long legajo){
        Connection conn = getConexion();

        try {
            //Buscar estudiante
            String sqlSelectEstudiante = "SELECT * FROM ESTUDIANTE WHERE LEGAJO = ?"; //incompleto
            PreparedStatement preparedStatementEstudiante = conn.prepareStatement(sqlSelectEstudiante);
            preparedStatementEstudiante.setLong(1, legajo);
            ResultSet estudianteResulset = preparedStatementEstudiante.executeQuery();
            Alumno alumno = new Alumno();
            Long personaFK = null;
            if (estudianteResulset.next()) {
                // Acá estás parado en la única fila
                personaFK = estudianteResulset.getLong("PERSONA_FK");
                alumno.setLegajo(estudianteResulset.getLong("LEGAJO"));
                alumno.setAlumnoId(estudianteResulset.getLong("ID"));
            }
            // Buscar persona
            String sqlSelectPersona = "SELECT * FROM PERSONAS WHERE id = ?"; //incompleto
            PreparedStatement preparedStatementPersona = conn.prepareStatement(sqlSelectPersona);
            preparedStatementPersona.setLong(1, personaFK);
            ResultSet personaResulset = preparedStatementPersona.executeQuery();
                alumno.setPersonaId(personaFK);
            if (personaResulset.next()) {
                alumno.setNombre(personaResulset.getString("NOMBRE"));
                alumno.setApellido(personaResulset.getString("APELLIDO"));
                alumno.setDocumento(personaResulset.getString("DOCUMENTO"));
                alumno.setDireccion(personaResulset.getString("DIRECCION"));
                alumno.setTelefono(personaResulset.getString("TELEFONO"));
                alumno.setCorreo(personaResulset.getString("CORREO"));
            }
            return alumno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
