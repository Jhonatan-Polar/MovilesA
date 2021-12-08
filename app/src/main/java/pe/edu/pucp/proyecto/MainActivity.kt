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
        usuarios.add(1,Usuario("Gustavo Rojas" ,"Estudiante"))
        usuarios.add(2,Usuario("Emerson Muñoz" ,"Docente"))
        usuarios.add(3,Usuario("Jhonatan Cueva","Estudiante"))
        usuarios.add(4,Usuario("Leandro Lazo"  ,"Docente"))

        libros.add(1,Libro("Cálculo en Varias Variables (8.ª ed.)",
            "James Stewart","","Matemática"))
        libros.add(2,Libro("Física Universitaria Vol. I",
            "Francis W. Sears","","Física"))
        libros.add(3,Libro("Química (primera edición)",
            "Raymond Chang","","Química"))
        libros.add(4,Libro("Modern Operating Systems",
            "Andrew Tanenbaum","","Informática"))
        libros.add(5,Libro("Operating Systems: Design and Implementation",
            "Andrew Tanenbaum","","Informática"))
        libros.add(6,Libro("The C Programming Language",
            "Brian Kernighan & Dennis Ritchie","","Informática"))
        libros.add(7,Libro("The C++ Programming Language",
            "Bjarne Stroustrup","","Informática"))
        libros.add(8,Libro("Estructura de datos y métodos algorítmicos",
            "Narciso Martí Oliet","","Informática"))

        libros[1].agregarResenia(usuarios[1],libros[1],
            "¡Excelente libro! Tiene buenos ejercicios para Cálculo 3.")
        libros[1].agregarResenia(usuarios[2],libros[1],
            "Este libro me ayudó a pasar Cal3.")
        libros[1].agregarResenia(usuarios[3],libros[1],
            "Muy buen libro para Cálculo en Varias Variables.")
        libros[8].agregarResenia(usuarios[4],libros[8],
            "Este libro tiene buenos ejemplos para EDPM.")
        libros[8].agregarResenia(usuarios[1],libros[8],
            "Te explica bien la teoría para EDPM.")
        libros[6].agregarResenia(usuarios[2],libros[6],
            "¡Todo lo que se necesita para LP1 está aquí!")
        libros[2].agregarResenia(usuarios[2],libros[2],
            "Muy buen libro para Fa1 y Fa2. ¡Definitivamente lo recomiendo!")
        libros[2].agregarResenia(usuarios[3],libros[2],
            "Los ejemplos del libro ayudan a entender mucho los temas de Física.")

    }
}