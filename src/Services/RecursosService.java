package Services;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class RecursosService {

    private Color colorBoton,colorFondo,colorBordeTabla1,colorBordeTabla2;
    private Font fontTitulo,fontBotones,fontArial;
    private Cursor cMano;
    private Border bordeBoton;

    static private RecursosService servicio;

    private RecursosService() {

        this.generarFuentes();
        this.crearColores();
        this.crearFuentes();
        this.crearCursores();
        this.crearBordes();
    } 


    private void crearColores(){
        colorFondo = new Color(23, 165, 137);
        colorBoton = new Color(0x2C3E50);
        colorBordeTabla1 = new Color(212, 172, 13);
        colorBordeTabla2 = new Color(31, 97, 141 );
        //colorBordeBoton = new Color(26, 82, 118 );
    
    }

    private void generarFuentes(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Copyduck.ttf")));
            
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
    }

    private void crearFuentes(){
        fontTitulo = new Font("Copyduck", Font.PLAIN, 14);
        fontBotones = new Font("Arial", Font.PLAIN, 10);
        fontArial = new Font("Arial", Font.PLAIN, 14);
    }

    private void crearCursores(){
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }

    private void crearBordes(){
        bordeBoton = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,colorBordeTabla1,colorBordeTabla2);
    }

    public static RecursosService getService() {
        if (servicio == null) {
            servicio = new RecursosService();
        }
        return servicio;
    }

    public Color getColorBoton() {
        return colorBoton;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public Color getColorBordeTabla1() {
        return colorBordeTabla1;
    }

    public Color getColorBordeTabla2() {
        return colorBordeTabla2;
    }

    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontBotones() {
        return fontBotones;
    }

    public Font getFontArial() {
        return fontArial;
    }

    public Cursor getcMano() {
        return cMano;
    }

    public Border getBordeBoton() {
        return bordeBoton;
    }

}
