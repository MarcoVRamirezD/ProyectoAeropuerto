package cr.ac.ucenfotec.bl.entities.lineaAerea;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.pais.Pais;

/**
 * Esta clase incluye la informacion de linea aerea con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class LineaAerea {
    /*
    Aquí encontramos los atributos
    */
    private String nombreComercial;
    private String cedulaJuridica;
    private String nombreEmpresaDuenna;
    private String codigoPais;

    /*
    Aquí encontramos los constructores
     */
    public LineaAerea() {
    }

    public LineaAerea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuenna, String codigoPais) {
        this.nombreComercial = nombreComercial;
        this.cedulaJuridica = cedulaJuridica;
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
        this.codigoPais = codigoPais;
    }
    /*
    Aquí encontramos los getters and setters
     */

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getNombreEmpresaDuenna() {
        return nombreEmpresaDuenna;
    }

    public void setNombreEmpresaDuenna(String nombreEmpresaDuenna) {
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }
    /*
    Aquí encontramos el toString
     */

    @Override
    public String toString() {
        return "LineaAerea{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", cedulaJuridica='" + cedulaJuridica + '\'' +
                ", nombreEmpresaDuenna='" + nombreEmpresaDuenna + '\'' +
                ", codigoPais='" + codigoPais + '\'' +
                '}';
    }

    /*
        Aquí encontramos el equals
         */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineaAerea that = (LineaAerea) o;

        return cedulaJuridica == that.cedulaJuridica;
    }

}
