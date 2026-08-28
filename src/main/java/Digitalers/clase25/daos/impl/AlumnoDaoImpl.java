package Digitalers.clase25.daos.impl;

import Digitalers.clase25.daos.interfaces.ConexionMySql;
import Digitalers.clase25.daos.interfaces.DAO;
import Digitalers.clase25.entities.Alumno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public boolean insertar(Alumno entidad) throws SQLException{
        Connection con = getConexion();
        Statement statement = con.createStatement();

        String sqlInsertPersona = "INSERT INTO PERSONAS (NOMBRE, APELLIDO, DOCUMENTO, DIRECCION, TELEFONO, CORREO) VALUES ()";
        ResultSet resultSetPersona = statement.executeQuery(sqlInsertPersona);

        //Obtener el id de la persona creada
        Long idPersona = resultSetPersona.getLong("");
        //User ese id para el campo persona_fk
        String sqlInsertAlumno = "INSERT INTO ESTUDIANTE (PERSONA_FK. LEGAJO)";
        //Insertar el alumno
        ResultSet resultSetEstudiante = statement.executeQuery(sqlInsertAlumno);

        return true;
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
}
