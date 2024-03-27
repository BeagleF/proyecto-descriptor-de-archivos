/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatosTemporales;

import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Alexis
 */
public class ParametrosConsulta {
    
    private HashMap<String,Object[]> parametrosConsulta;
    private HashMap<String,Integer> posicionesAtributos;
    private Vector<Vector> grande;
    private String[] ordenImpresion;
    
    public ParametrosConsulta(HashMap<String,Object[]> parametrosConsulta,HashMap<String,Integer> posicionesAtributos,Vector<Vector> grande,String[] ordenImpresion){
        this.parametrosConsulta = parametrosConsulta;
        this.posicionesAtributos = posicionesAtributos;
        this.grande = grande;
        this.ordenImpresion = ordenImpresion;  
    }

    public HashMap<String, Object[]> getParametrosConsulta() {
        return parametrosConsulta;
    }


    public HashMap<String, Integer> getPosicionesAtributos() {
        return posicionesAtributos;
    }


    public Vector<Vector> getGrande() {
        return grande;
    }


    public String[] getOrdenImpresion() {
        return ordenImpresion;
    }

    
}
