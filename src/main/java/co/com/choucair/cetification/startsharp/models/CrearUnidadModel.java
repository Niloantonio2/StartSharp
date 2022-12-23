package co.com.choucair.cetification.startsharp.models;

public class CrearUnidadModel {
    private String strNombreUnidad, strUnidadPadre ;

    public CrearUnidadModel(String strNombreUnidad, String strUnidadPadre) {
        this.strNombreUnidad = strNombreUnidad;
        this.strUnidadPadre = strUnidadPadre;
    }

    public String getStrNombreUnidad() {
        return strNombreUnidad;
    }

    public String getStrUnidadPadre() {
        return strUnidadPadre;
    }
}
