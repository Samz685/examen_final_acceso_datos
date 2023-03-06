package org.example;

import dao.AlumnoDao;
import models.Alumno;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello worl.!");


        AlumnoDao alumnoDao = new AlumnoDao();

        //creación alumnos prueba
        Alumno a1 = new Alumno();
        a1.setId(1);
        a1.setNombre("Sam");
        a1.setEmail("sam@sam.com");
        a1.setNotaAD(10.00);
        a1.setNotaDI(10.00);
        a1.setNotaMedia(a1.notaGlobal(a1.getNotaAD(),a1.getNotaDI()));
        alumnoDao.insertarAlumno(a1);

        Alumno a2= new Alumno();
        a2.setId(2);
        a2.setNombre("Javi");
        a2.setEmail("javi@javi.com");
        a2.setNotaAD(5.00);
        a2.setNotaDI(10.00);
        a2.setNotaMedia(a2.notaGlobal(a2.getNotaAD(),a2.getNotaDI()));
        alumnoDao.insertarAlumno(a2);

        Alumno a3= new Alumno();
        a3.setId(3);
        a3.setNombre("Ismael");
        a3.setEmail("ismael@ismael.com");
        a3.setNotaAD(9.00);
        a3.setNotaDI(8.00);
        a3.setNotaMedia(a3.notaGlobal(a3.getNotaAD(),a3.getNotaDI()));
        alumnoDao.insertarAlumno(a3);

        Alumno a4= new Alumno();
        a4.setId(4);
        a4.setNombre("Pepito");
        a4.setEmail("pepito@pepito.com");
        a4.setNotaAD(4.00);
        a4.setNotaDI(2.00);
        a4.setNotaMedia(a4.notaGlobal(a4.getNotaAD(),a4.getNotaDI()));
        alumnoDao.insertarAlumno(a4);

        Alumno a5= new Alumno();
        a5.setId(5);
        a5.setNombre("Juanito");
        a5.setEmail("juanito@juanito.com");
        a5.setNotaAD(4.00);
        a5.setNotaDI(3);
        a5.setNotaMedia(a5.notaGlobal(a5.getNotaAD(),a5.getNotaDI()));
        alumnoDao.insertarAlumno(a5);



        //imprimiendo TODOS alumnos por consola
        System.out.println((""));
        System.out.println(("--------------Todos los alumnos--------------"));
        for(Alumno a : alumnoDao.listarTodo()){

            var alumnoInfo = "Nombre: "+a.getNombre()+" -- Email: "+a.getEmail()+" -- Nota AD: "+a.getNotaAD()+" -- Nota DI: "+a.getNotaDI()+ " -- Nota Global: "+a.getNotaMedia();
            System.out.println((alumnoInfo));
        }
        //------------------------------------------
        //imprimiendo alumnos SUSPENSOS por consola

        System.out.println((""));
        System.out.println(("--------------Alumnos Suspensos--------------"));
        for(Alumno a : alumnoDao.listarSuspensos()){

            var alumnoInfo = "Nombre: "+a.getNombre()+" -- Email: "+a.getEmail()+" -- Nota AD: "+a.getNotaAD()+" -- Nota DI: "+a.getNotaDI()+ " -- Nota Global: "+a.getNotaMedia();
            System.out.println((alumnoInfo));
        }

        //------------------------------------------
        //imprimiendo alumnos APROBADOS por consola

        System.out.println((""));
        System.out.println(("--------------Alumnos APROBADOS--------------"));
        for(Alumno a : alumnoDao.listarAprobados()){

            var alumnoInfo = "Nombre: "+a.getNombre()+" -- Email: "+a.getEmail()+" -- Nota AD: "+a.getNotaAD()+" -- Nota DI: "+a.getNotaDI()+ " -- Nota Global: "+a.getNotaMedia();
            System.out.println((alumnoInfo));
        }

        //------------------------------------------
        //mostrar por consulta nota media del alumnado
        System.out.println((""));
        System.out.println(("--------------Alumnos Nota Media--------------"));
        double notaMedia_alumnado = 0;
        for (Alumno a : alumnoDao.listarTodo()){
            notaMedia_alumnado += a.getNotaMedia();
        }
        notaMedia_alumnado /=5;
        System.out.println(("Nota media Alumnado: "+ notaMedia_alumnado));


        //------------------------------------------
        //mostrar por ratio aprobados
        System.out.println((""));
        System.out.println(("--------------Ratio aprobados--------------"));
        double numAlumnosTotal = 0;
        double numAprobados = 0;
        double ratioAprobados = 0;

        for(Alumno a : alumnoDao.listarTodo()){
            numAlumnosTotal++;
        }

        for(Alumno a : alumnoDao.listarAprobados()){
            numAprobados++;
        }

        ratioAprobados = (numAprobados/numAlumnosTotal);

        System.out.println(("Ratio Aprobados: " + ratioAprobados));






    }
}