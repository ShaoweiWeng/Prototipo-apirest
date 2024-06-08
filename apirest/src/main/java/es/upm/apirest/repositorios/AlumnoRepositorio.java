package es.upm.apirest.repositorios;

import es.upm.apirest.datos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno,Integer> {

}
