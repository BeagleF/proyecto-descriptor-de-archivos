package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import Services.ObjGraficosService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Consultas extends JFrame{

    private ObjGraficosService sObjGraficos;

    private JPanel pDebajo, pIzquierda,pDerecha;
    private JLabel lTituloVentana,lTablaFinal,lTablaProceso,lAcciones,lFondo;
    private JTextArea tAreaConsulta;
    private JButton bEjecutar,bLimpiar,bSiguiente;
    private Color colorBoton,colorFondo,colorBordeBoton,colorBordeTabla1,colorBordeTabla2;
    private Font fontTitulo,fontSubtitulo,fontBotones;
    private Cursor cMano;
    private Border bordeBoton,bordeTabla;
    //private ImageIcon iFondo;

    public Consultas() {
        super("Generador de consultas");

        //iFondo = new ImageIcon("resources/images/Engranes.jpg");
        

        this.generarFuentes();

        fontTitulo = new Font("Copyduck", Font.PLAIN, 14);

        colorFondo = new Color(23, 165, 137);
        colorBoton = new Color(0x2C3E50);
        //colorBordeBoton = new Color(26, 82, 118 );
        colorBordeTabla1 = new Color(212, 172, 13);
        colorBordeTabla2 = new Color(31, 97, 141 );

        cMano = new Cursor(Cursor.HAND_CURSOR);

        bordeTabla = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,colorBordeTabla1,colorBordeTabla2);
        bordeBoton = BorderFactory.createRaisedBevelBorder();
        //bordeBoton = BorderFactory.createLineBorder(colorBordeBoton,2,true);
        

        

        pDebajo = new JPanel();
        pDebajo.setSize(1000,300);
        pDebajo.setLocation(0,200);
        pDebajo.setBackground(Color.green);
        pDebajo.setLayout(null);
        this.add(pDebajo);

        pIzquierda = new JPanel();
        pIzquierda.setSize(700,200);
        pIzquierda.setLocation(0,0);
        pIzquierda.setBackground(Color.blue);
        pIzquierda.setLayout(null);
        this.add(pIzquierda);

        

        pDerecha = new JPanel();
        pDerecha.setSize(300,200);
        pDerecha.setLocation(700,0);
        pDerecha.setBackground(colorFondo);
        pDerecha.setLayout(null);
        this.add(pDerecha);
        
        //lFondo = new JLabel();
        //lFondo.setBounds(0, 0, 300, 200);
        //lFondo.setIcon(iFondo);
        //pDerecha.add(lFondo);


        lTituloVentana = new JLabel("Generador de consultas");
        lTituloVentana.setBounds(25, 10, 200, 30);
        lTituloVentana.setForeground(Color.white);
        lTituloVentana.setFont(fontTitulo);
        pIzquierda.add(lTituloVentana);

        lTablaProceso = new JLabel("Tabla de proceso");
        lTablaProceso.setBounds(25, 10, 200, 30);
        lTablaProceso.setForeground(Color.white);
        pDebajo.add(lTablaProceso);

        lAcciones = new JLabel("Acciones");
        lAcciones.setBounds(110, 10, 200, 30);
        lAcciones.setForeground(Color.white);
        pDerecha.add(lAcciones);

        tAreaConsulta = new JTextArea("SELECT +  employee_id, + first_name,salary  ,manager_id FROM tabla WHERE salary between 2500 AND 15000;");
        tAreaConsulta.setBounds(25, 40, 650, 145);
        tAreaConsulta.setLineWrap(true);
        tAreaConsulta.setFont(new Font("ARIAL", Font.BOLD, 12));
        tAreaConsulta.setBorder(bordeTabla);
        pIzquierda.add(tAreaConsulta);

        bEjecutar = new JButton("Ejecutar");
        bEjecutar.setBounds(85, 40, 100, 30);
        bEjecutar.setBackground(colorBoton);
        bEjecutar.setForeground(Color.white);
        bEjecutar.setFocusable(false);
        bEjecutar.setBorder(bordeBoton);
        pDerecha.add(bEjecutar);

        bLimpiar = new JButton("Limpiar");
        bLimpiar.setBounds(85, 80, 100, 30);
        bLimpiar.setBackground(colorBoton);
        bLimpiar.setForeground(Color.white);
        bLimpiar.setFocusable(false);
        bLimpiar.setBorder(bordeBoton);
        pDerecha.add(bLimpiar);

        bSiguiente = new JButton("Siguiente");
        bSiguiente.setBounds(85, 120, 100, 30);
        bSiguiente.setBackground(colorBoton);
        bSiguiente.setForeground(Color.white);
        bSiguiente.setFocusable(false);
        bSiguiente.setBorder(bordeBoton);
        pDerecha.add(bSiguiente);

        bEjecutar.setCursor(cMano);
        bLimpiar.setCursor(cMano);
        bSiguiente.setCursor(cMano);
        



        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(this);
        setVisible(true);

        

    }

    private void generarFuentes(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Copyduck.ttf")));
            
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                Consultas consulta = new Consultas();
                consulta.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }

}
