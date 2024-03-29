package EstructurasDeDatosTemporales;

import java.util.Vector;

public class MostarEnTabla {

    private Vector<Vector> datos;
    private String[] columnas;

    public MostarEnTabla(Vector<Vector> datos, String[] columnas) {
        this.datos = datos;
        this.columnas = columnas;
    }
    
    public Vector<Vector> getDatos() {
        return datos;
    }

    public String[] getColumnas() {
        return columnas;
    }

}
