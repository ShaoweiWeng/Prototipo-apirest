import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper } from '@mui/material';
import Button from '@mui/material/Button';
import { useState, useEffect } from 'react';

export default function Student() {
    const [id_alumno, setId] = useState('')
    const [nombre, setName] = useState('')
    const [apellido1, setSurname1] = useState('')
    const [apellido2, setSurname2] = useState('')
    const [email, setEmail] = useState('')

    const [alumnos, setStudents] = useState([])

    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const handleClick = (e) => {
        e.preventDefault()
        const student = { id_alumno, nombre, apellido1, apellido2, email }
        fetch("http://localhost:8080/guardar", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(student)

        })
    }
    useEffect(() => {
        fetch("http://localhost:8080/alumnos")
            .then(res => res.json())
            .then((result) => {
                setStudents(result);
            }
            )
    }, [])

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1>Añadir un nuevo alumno</h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1, width: '25ch' },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField id="outlined-basic" label="Numero de matricula" variant="outlined" fullWidth
                        value={id_alumno}
                        onChange={(e) => setId(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Nombre" variant="outlined" fullWidth
                        value={nombre}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Apellido 1" variant="outlined" fullWidth
                        value={apellido1}
                        onChange={(e) => setSurname1(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Apellido 2" variant="outlined" fullWidth
                        value={apellido2}
                        onChange={(e) => setSurname2(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <Button variant="outlined" onClick={handleClick}>Añadir Alumno</Button>
                </Box>
            </Paper>
            <h1>Estudiantes Matriculados</h1>

            <Paper elevation={3} style={paperStyle}>

                {alumnos.map(student => (
                    <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={student.id}>
                        Id:{student.id_alumno}<br />
                        Nombre:{student.nombre}<br />
                        Apellido 1:{student.apellido1}<br />
                        apellido2:{student.apellido2}<br />
                        Email:{student.email}<br />
                    </Paper>
                ))
                }
            </Paper>
        </Container >
    );
}
