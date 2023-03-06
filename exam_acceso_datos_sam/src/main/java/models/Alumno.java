package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    int id;
    String nombre;
    String telefono;
    String email;
    double notaAD;
    double notaDI;
    double notaMedia;

    public double  notaGlobal(double notaAD, double notaDI){
        double resultado = (notaAD+notaDI)/2;
        return resultado;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(double notaAD) {
        this.notaAD = notaAD;
    }

    public double getNotaDI() {
        return notaDI;
    }

    public void setNotaDI(double notaDI) {
        this.notaDI = notaDI;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", notaAD=" + notaAD +
                ", notaDI=" + notaDI +
                '}';
    }
}
