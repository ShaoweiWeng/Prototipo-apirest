package es.upm.apirest.controladores;

import es.upm.apirest.datos.Alumno;
import es.upm.apirest.servicios.AlmunoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AlumnoControlador {

    @Autowired
    AlmunoServicio almunoServicio; // Inyección de dependencia

    /**
     * Metodo para manejar solicitudes GET en la ruta "/alumnos".
     * @return lista de todos los alumnos.
     */
    @GetMapping("/alumnos")
    public List<Alumno> obtenerAlumnos() {
        return almunoServicio.obtenerLista();
    }
    /**
     * Maneja solicitudes POST en la ruta "/guardar".
     * Aniade un nuevo alumno en la base de datos.
     */
    @PostMapping("/guardar")
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno){
        Alumno nuevoAlumno = almunoServicio.guardar(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    /**
     * Maneja solicitudes GET en la ruta "/alumno/{id}".
     * Busca al alumno dentro del BBDD por su id.
     * @return alumno especifico por su ID.
     */
    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoId(@PathVariable int id){
        Alumno alumnoPorId = almunoServicio.obtenerPorID(id);
        return ResponseEntity.ok(alumnoPorId);
    }

    /**
     * Maneja solicitudes DELETE en la ruta "/alumno/{id}".
     * Elimina a un alumno con un id especifico.
     */
    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarAlumno(@PathVariable int id) {
        almunoServicio.eliminar(id);
        HashMap<String, Boolean> estadoAlumnoEliminado = new HashMap<>();
        estadoAlumnoEliminado.put("eliminado",true);
        return ResponseEntity.ok(estadoAlumnoEliminado);
    }
}
