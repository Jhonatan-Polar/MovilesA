package pe.edu.pucp.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pe.edu.pucp.proyecto.databinding.ActivityMainBinding


var usuarios = mutableListOf<Usuario>()
var libros = mutableListOf<Libro>()
var usuarioActual = Usuario("","")

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var REQUEST_CODE = 1234


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtErrorLogin.visibility = TextView.INVISIBLE;
        binding.editTextUsername.requestFocus()

        // Crear usuarios y libros
        crearUsuariosLibrosyResenias()

        // Iniciar Sesión
        binding.btnIniciarSesion.setOnClickListener {
            val nombreUsuario = binding.editTextUsername.text.toString()
            val contrasenia = binding.editTextPassword.text.toString()
            if(loginValido(nombreUsuario, contrasenia)) {
                binding.txtErrorLogin.visibility = TextView.INVISIBLE;
                iniciarSesion()
            }
            else{
                binding.txtErrorLogin.visibility = TextView.VISIBLE;
            }
        }

    }

    private fun iniciarSesion(){
        val inciarSesionIntent = Intent(this,BottomNavigation::class.java)
        startActivityForResult(inciarSesionIntent,REQUEST_CODE)
    }

    private fun crearUsuariosLibrosyResenias(){
        usuarios.add(Usuario("Pablo José Antonio Gálvez Rodríguez" ,"Estudiante", "pablo123"))
        usuarios.add(Usuario("José Luis Vargas García" ,"Estudiante", "jluisv"))
        usuarios.add(Usuario("Emerson Muñoz" ,"Docente"))
        usuarios.add(Usuario("Jhonatan Cueva","Estudiante"))
        usuarios.add(Usuario("Leandro Lazo"  ,"Docente"))

        libros.add(Libro("Cálculo en Varias Variables (8.ª ed.)",
            "James Stewart","Este texto contiene los temas necesarios para que los estudiantes entiendan las ideas fundamentales, sustentándolas en aplicaciones del mundo real y construyan habilidades de razonamiento matemático.","Matemática"))
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

        libros[0].agregarResenia(usuarios[0],
            "¡Excelente libro! Tiene buenos ejercicios para Cálculo 3. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        libros[0].agregarResenia(usuarios[2],
            "Muy buen libro para Cálculo en Varias Variables.")
        libros[7].agregarResenia(usuarios[3],
            "Este libro tiene buenos ejemplos para EDPM.")
        libros[7].agregarResenia(usuarios[0],
            "Te explica bien la teoría para EDPM.")
        libros[5].agregarResenia(usuarios[1],
            "¡Todo lo que se necesita para LP1 está aquí!")
        libros[1].agregarResenia(usuarios[1],
            "Muy buen libro para Fa1 y Fa2. ¡Definitivamente lo recomiendo!")
        libros[1].agregarResenia(usuarios[2],
            "Los ejemplos del libro ayudan a entender mucho los temas de Física.")
    }

    private fun loginValido(username : String, password : String) : Boolean {
        val foundUser = usuarios.find { u -> u.nombreUsuario == username }
        if (foundUser != null && foundUser.contrasenia == password){
            usuarioActual = foundUser
            return true
        }
        return false
    }
}