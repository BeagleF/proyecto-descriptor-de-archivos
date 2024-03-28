package Services;

import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;

public class ObjGraficosService {

    private ObjGraficosService() {} // Constructor vacio

    static private ObjGraficosService servicio;

    public static ObjGraficosService getService() {
        if (servicio == null) {
            servicio = new ObjGraficosService();
        }
        return servicio;
    }

    public JPanel construirJPanel(int x, int y, int ancho, int alto, Color colorFondo, Border borde) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, ancho, alto);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        panel.setLayout(null);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        return panel;
    }
    

}
