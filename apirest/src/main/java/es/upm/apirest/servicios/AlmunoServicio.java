package es.upm.apirest.servicios;

import es.upm.apirest.datos.Alumno;
import es.upm.apirest.repositorios.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmunoServicio implements IAlumnoServicio {

    @Autowired
    AlumnoRepositorio alumnoRepositorio;

    @Override
    public List<Alumno> obtenerLista() {
        return alumnoRepositorio.findAll();
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    @Override
    public Alumno obtenerPorID(int id) {
        return alumnoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        alumnoRepositorio.deleteById(id);
    }
}
