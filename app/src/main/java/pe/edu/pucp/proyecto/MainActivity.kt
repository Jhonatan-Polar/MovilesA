package pe.edu.pucp.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.pucp.proyecto.databinding.ActivityMainBinding

var usuarios = mutableListOf<Usuario>()
var libros = mutableListOf<Libro>()

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Crear usuarios y libros
        crearUsuariosLibrosyResenias()

    }

    private fun crearUsuariosLibrosyResenias(){
        usuarios.add(Usuario("Gustavo Rojas" ,"Estudiante"))
        usuarios.add(Usuario("Emerson Muñoz" ,"Docente"))
        usuarios.add(Usuario("Jhonatan Cueva","Estudiante"))
        usuarios.add(Usuario("Leandro Lazo"  ,"Docente"))

        libros.add(Libro("Cálculo en Varias Variables (8.ª ed.)",
            "James Stewart","","Matemática"))
        libros.add(Libro("Física Universitaria Vol. I",
            "Francis W. Sears","","Física"))
        libros.add(Libro("Química (primera edición)",
            "Raymond Chang","","Química"))
        libros.add(Libro("Modern Operating Systems",
            "Andrew Tanenbaum","","Informática"))
        libros.add(Libro("Operating Systems: Design and Implementation",
            "Andrew Tanenbaum","","Informática"))
        libros.add(Libro("The C Programming Language",
            "Brian Kernighan & Dennis Ritchie","","Informática"))
        libros.add(Libro("The C++ Programming Language",
            "Bjarne Stroustrup","","Informática"))
        libros.add(Libro("Estructura de datos y métodos algorítmicos",
            "Narciso Martí Oliet","","Informática"))

        libros[0].agregarResenia(usuarios[0],libros[0],
            "¡Excelente libro! Tiene buenos ejercicios para Cálculo 3.")
        libros[0].agregarResenia(usuarios[1],libros[0],
            "Este libro me ayudó a pasar Cal3.")
        libros[0].agregarResenia(usuarios[2],libros[0],
            "Muy buen libro para Cálculo en Varias Variables.")
        libros[7].agregarResenia(usuarios[3],libros[7],
            "Este libro tiene buenos ejemplos para EDPM.")
        libros[7].agregarResenia(usuarios[0],libros[7],
            "Te explica bien la teoría para EDPM.")
        libros[5].agregarResenia(usuarios[1],libros[5],
            "¡Todo lo que se necesita para LP1 está aquí!")
        libros[1].agregarResenia(usuarios[1],libros[1],
            "Muy buen libro para Fa1 y Fa2. ¡Definitivamente lo recomiendo!")
        libros[1].agregarResenia(usuarios[2],libros[1],
            "Los ejemplos del libro ayudan a entender mucho los temas de Física.")
    }
}