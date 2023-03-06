package dao;

import models.Alumno;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class AlumnoDao {

    public void insertarAlumno(Alumno a){
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public ArrayList<Alumno> listarTodo(){
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select a from Alumno a",Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        em.close();
        return salida;
    }

    public ArrayList<Alumno> listarSuspensos(){
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select a from Alumno a where a.notaMedia < 5",Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        em.close();
        return salida;
    }

    public ArrayList<Alumno> listarAprobados(){
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select a from Alumno a where a.notaMedia >= 5",Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        em.close();
        return salida;
    }





}
