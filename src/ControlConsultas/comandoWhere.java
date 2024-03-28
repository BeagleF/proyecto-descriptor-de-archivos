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
    
    public Vector<Vector> aplicacionWhere(){//aqui es donde se va a decidir que funcion se va a ejecutar dependiendo
        //de las condiciones que se le hayan puesto al where
        
        int cantidadParametros = parametros.length;
        
        switch(cantidadParametros){
            case 3://en caso de que sean tres paremtros significa que la estructura del Where es similar a:
                //"WHERE job_id=50", pero el simbolo de comparacion puede cambiar con por ejemplo "<"
                //entonces se debe verificar con cual se esta trabajando
                String[] condicionesWhere = {"=",">","<","<=",">="};//estas son las posibles condiciones que puede
                //llegar a tener el where
                int condicion = 0;
                for(condicion = 0;condicion < condicionesWhere.length;condicion++){
                    if(parametros[1].equals(condicionesWhere[condicion])){//me voy a detener en el valor del arreglo
                        //de condicionesWhere que contenga a la condicion que tiene el arreglo de parametros en su
                        //primera posicion, que es donde debe estar
                        break;
                    }
                }
                
                switch(condicion){
                    case 0 : grande = igualWhere();//en caso de que el segundo parametro de comando Where sea "="
                    //se manda a llamar a esta funcion, y vector de vectores grande ahora contiene solo a quienes 
                    //cumplen con dicha condicion// y asi se va a hacer con todas las funciones
                        break;
                    case 1 :grande = mayorWhere();
                        break;
                    case 2 :grande = menorWhere();
                        break;
                    case 3 :grande = menorIgualWhere();
                        break;
                    case 4:grande = mayorIgualWhere();
                        break;
                    default:System.out.println("ERRORRRRR");
                            return null;
                        
                }
                
                break;
            case 5: grande = betweenWhere();
                break;
        }
        
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
        Double condition = Double.parseDouble(con);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
  
            String dato  = linea.get(ubicacion).toString();
            Double comparar = Double.parseDouble(dato);
            if(comparar > condition){
                revisado.add(linea);
            }  
        }
       
        return revisado;
    }
    
    public Vector<Vector> menorWhere(){
        
        Object condicion = parametros[2];
        String con = condicion.toString();
        Double condition = Double.parseDouble(con);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
  
            String dato  = linea.get(ubicacion).toString();
            Double comparar = Double.parseDouble(dato);
            if(comparar < condition){
                revisado.add(linea);
            }  
        }
       
        return revisado;
    }
    
    public Vector<Vector> mayorIgualWhere(){
        
        Object condicion = parametros[2];
        String con = condicion.toString();
        Double condition = Double.parseDouble(con);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
  
            String dato  = linea.get(ubicacion).toString();
            Double comparar = Double.parseDouble(dato);
            if(comparar >= condition){
                revisado.add(linea);
            }  
        }
       
        return revisado;
    }
    
    public Vector<Vector> menorIgualWhere(){
        
        Object condicion = parametros[2];
        String con = condicion.toString();
        Double condition = Double.parseDouble(con);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
  
            String dato  = linea.get(ubicacion).toString();
            Double comparar = Double.parseDouble(dato);
            if(comparar <= condition){
                revisado.add(linea);
            }  
        }
       
        return revisado;
    }
    
    public Vector<Vector> betweenWhere(){
        
        Object condicion1 = parametros[2];
        String con1 = condicion1.toString();
        Double condition1 = Double.parseDouble(con1);
        
        Object condicion2 = parametros[4];
        String con2 = condicion2.toString();
        Double condition2 = Double.parseDouble(con2);
        
        Vector<Vector> revisado = new Vector<>();
        
        for(Vector linea: grande){
  
            String dato  = linea.get(ubicacion).toString();
            Double comparar = Double.parseDouble(dato);
            if(comparar >= condition1 && comparar <=condition2){
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
