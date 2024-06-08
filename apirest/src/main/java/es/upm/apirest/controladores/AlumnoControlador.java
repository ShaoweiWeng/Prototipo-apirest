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
    AlmunoServicio almunoServicio;
    @GetMapping("/alumnos")
    public List<Alumno> obtenerAlumnos() {
        return almunoServicio.obtenerLista();
    }
    @PostMapping("/guardar")
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno){
        Alumno nuevoAlumno = almunoServicio.guardar(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoId(@PathVariable int id){
        Alumno alumnoPorId = almunoServicio.obtenerPorID(id);
        return ResponseEntity.ok(alumnoPorId);
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarAlumno(@PathVariable int id) {
        almunoServicio.eliminar(id);
        HashMap<String, Boolean> estadoAlumnoEliminado = new HashMap<>();
        estadoAlumnoEliminado.put("eliminado",true);
        return ResponseEntity.ok(estadoAlumnoEliminado);
    }
}
