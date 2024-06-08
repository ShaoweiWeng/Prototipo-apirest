package es.upm.apirest.servicios;

import es.upm.apirest.datos.Alumno;

import java.util.List;

public interface IAlumnoServicio {
    public List<Alumno> obtenerLista();
    public Alumno guardar(Alumno alumno);
    public Alumno obtenerPorID(int id);
    public void eliminar(int id);
}
