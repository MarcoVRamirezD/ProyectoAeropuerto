package cr.ac.ucenfotec.bl.entities.avion;

/*
Aquí se pueden encontrar los imports
 */
import java.util.Objects;

/**
 * Esta clase incluye la informacion de avion con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Avion {
    /*
    Aquí encontramos los atributos
    */
    private String placa;
    private String marcaFabricante;
    private String modelo;
    private int capacidad;

    /*
    Aquí encontramos los constructores
     */
    public Avion() {
    }

    public Avion(String placa, String marcaFabricante, String modelo, int capacidad) {
        this.placa = placa;
        this.marcaFabricante = marcaFabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    /*
    Aquí encontramos los getters and setters
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(String marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Avion{" +
                "placa='" + placa + '\'' +
                ", marcaFabricante='" + marcaFabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avion avion = (Avion) o;

        return Objects.equals(placa, avion.placa);
    }
}
