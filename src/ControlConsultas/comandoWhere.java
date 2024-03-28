/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlConsultas;

import java.util.Vector;

/**
 *
 * @author Alexis
 */
public class comandoWhere {
    
    private Vector<Vector> grande;
    private Object[] parametros;
    private int ubicacion;

    public comandoWhere(Vector<Vector> grande,Object[] parametros,int ubicacion) {
        this.grande = grande;
        this.parametros = parametros;
        this.ubicacion = ubicacion;
    }
    
    public Vector<Vector> aplicacionWhere(){
        
        return grande;
    }
    
  
    
    public Vector<Vector> igualWhere(){
        
        Object condicion = parametros[2];
        Vector<Vector> revisado = new Vector<>();
       
        
        for(Vector linea: grande){
            
//            System.out.println("mira:" + linea.get(ubicacion));
//            System.out.println("aqui" + condicion);//esto era para comprobar el comportamiento
            if(linea.get(ubicacion).equals(condicion)){
                revisado.add(linea);
            }
            
        }
        
//        System.out.println("Regreso a:");
//        for(Vector linea: grande){
//            
//            
//            for(Object columna: linea){
//                System.out.print(columna);
//            }
//            System.out.println(" ");
//        }
        
        return revisado;
    }
    
    public Vector<Vector> mayorWhere(){
        
        Object condicion = parametros[2];
        String con = condicion.toString();
        int condition = Integer.parseInt(con);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
            
            
            String dato  = linea.get(ubicacion).toString();
            int comparar = Integer.parseInt(dato);
            
            if(comparar > condition){
                revisado.add(linea);
            }
            
        }
        

        
        return revisado;
    }
    
    public static void main(String args[]){
        
        String p = "123";
        String pa = "hola";
        System.out.println("1: " + (Double.parseDouble(p) + 2));
        //System.out.println("1: " + Integer.parseInt(pa));
        
        
    }
}
