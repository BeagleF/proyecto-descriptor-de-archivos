/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlConsultas;

import EstructurasDeDatosTemporales.DescriptorArchivos;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Alexis
 */
public class LogicaSQL {
    
    private String consulta;
    private String nombreTabla;
    private String[] ClausulasSQL = {"SELECT","FROM","WHERE","I","J"};
    private HashMap<String,Integer> comandosSQL = new HashMap<>();
    private DescriptorArchivos descriptor;

    
    public LogicaSQL(String consulta,String nombreTabla){
        this.consulta = consulta;
        this.nombreTabla = nombreTabla;
        this.comandosSQL.put("SELECT", 1);
        this.comandosSQL.put("FROM", 2);
        this.comandosSQL.put("WHERE", 3);
        this.comandosSQL.put("I", 4);
        this.comandosSQL.put("J", 5);
    }
    
    public String getConsulta() {
        return consulta;
    }
    
    private void limpiarConsulta(){//la consulta que se va a recibir desde la ventana de consultas se adapta a un formato
        //sencillo de manejar, para poder asi ejecutar la consulta especifica que se solicita;
        this.consulta = this.consulta.toUpperCase();
        this.consulta = this.consulta.replaceAll("\\n", ""); 
    }
    
    private String[] comprobarSintaxis(){
        limpiarConsulta();//primero le quito los saltos de linea a la consulta que reciba
        String[] accionesConsulta = this.consulta.split("\\s");//la consulta escrita por el usuario voy a guardar
        //cada palabra que ingreso en un arreglo de cadenas, para poder iterar entre ellas
        int correcto = 0;
        int contador = 0;
        HashMap<String,Integer> auxiliar = new HashMap<>();//defino un hashmap, que me va a servir para escribir
        //las instrucciones SQL que tiene la consulta y sus posiciones, las llaves van a ser las los comandos SQL
        //y el valor asignado a las llaves va a ser su posicion, la posicion de como viene escrita la consulta
        
        if(accionesConsulta[0].equals(ClausulasSQL[0])==false){//en caso de que la primera parte de la consulta no sea un SELECT
            //la consulta esta mal estructurada
            System.out.println("La consulta debe iniciar con la instruccion SELECT");
            System.out.println(ClausulasSQL[0]);
            System.out.println(accionesConsulta[0]);
            
            return null;//el null retornado va a ser mi indicador de error
        }
        
        for(String cadenas: accionesConsulta){//me voy a mover por todas las cadenas que contiene la consulta ingresada
            //para poder verificar las instrucciones SQL que contiene
            
            if(comandosSQL.containsKey(cadenas)){//en caso de que la consulta del usuario contenga las palabras 
                //reservadas de los comandos SQL se guarda la posicion en la que se recibieron, esto es porque se tiene
                //que respetar un cierto, orden, por ejemplo un FROM no puede ir antes que un SELECT y asi
                
                if(auxiliar.containsKey(cadenas)){//esta condicion se ejecuta en caso de que en la consulta del
                    //usuario haya ingresado dos veces un SELECT por ejemplo, lo cual debe arrojar un error
                    System.out.println("ERROR: Se ingreso mas de 1 vez la misma instruccion: " + cadenas);
                    return null;
                }
                
                auxiliar.put(cadenas, contador);
            } 
            contador++;//el contador va a servir para indicar la posicion en la que se encuentra la cadena de la consulta
            //en el arreglo de accionesConsulta, porque se inicio en cero
              
        }
       

        Object[] llavesConsulta = auxiliar.keySet().toArray();//guardo los Comandos SQL encontrados en la consulta del
        //usuario
        int[] ordenInstrucciones = new int[llavesConsulta.length];//con un arreglo de enteros voy a saber en que orden se
        //ingresaron los Comandos SQL, porque como se menciono antes deben respetar un orden
        
//        for(int j=0;j<llavesConsulta.length;j++){//esto es solo para ver en que orden se guardan las llaves de un hashmap
//            //y no se guardan en el orden en el que fueron registradas, parece ser aleatorio, por eso no se va a usar
//            //en el orden de las llaves, porque no serviria
//            System.out.println("hola :" + auxiliar.get(llavesConsulta[j]));
//           
//        }
        
        int control = 0;//la variable control me va a ayudar a ubicar en el orden en que los comandos SQL fueron ingresados
        //en la consulta, inicia en cero porque va a servir para las posiciones del arreglo de enteros llamado
        //ordenInstrucciones, que en su posicion cero tendra en que posicion se escribio el ComandoSQL, pues va a recibir
        //el valor del que tenga almacenado el HashMap auxiliar.
        //Cada iteracion del ciclo siguiente se hace para verificar las posibles de todos los posibles comandos SQL que se 
        //pueden llegar a ingresar, al inicio se pregunta por SELECT, se le pregunta al HashMap de auxiliar si es que 
        //la palabra SELECT esta en el, en caso de tenerlo se va a guardar en la posicion cero de ordenInstrucciones
        //la posicion en la que se escribio el comando. Este arreglo funciona porque las posiciones siguientes de las anteriores
        //deben ser siempre mayores entre si, esto es porque como se esta recorriendo en orden el arreglo de ClausulasSQL este
        //contiene el orden que se debe respetar entre los comandos, entonces si por ejemplo al inicio se guardo en ordenInstrucciones
        //en su posicion cero un valor de "0" significa que la primera palabra de la consulta es SELECT, luego digamos que se 
        //pregunta por FROM en el HashMap auxiliar, y se guarda en ordenInstrucciones en la posicion 1, porque el control aumento
        //1 en valor, el valor de "8", y luego se pregunta por WHERE en el HashMap auxiliar y se guarda en ordenInstrucciones
        //en la posicion 2 un valor de "6", singifica que entonces la consulta por ejemplo seria:
        //"SELECT id,name,department,salary,phone WHERE id==1 FROM employees", lo cual esta mal, porque el FROM debe estar antes
        //que el WHERE siempre.
        //e
        for(int i = 0;i<ClausulasSQL.length;i++){
            if(auxiliar.containsKey(ClausulasSQL[i])){
                System.out.println("Intruccion " + ClausulasSQL[i] + " posicion " + auxiliar.get(ClausulasSQL[i]) );
                ordenInstrucciones[control] = auxiliar.get(ClausulasSQL[i]);
                control++;
            }
        }
        
        
        for(int j=0;j<llavesConsulta.length;j++){//aqui es donde se comprueba que las posiciones en el arreglo de ordenInstrucciones
            //esten ordenadas de menor a mayor, pues esto significa que respetan la jerarquia/orden de Comandos
            System.out.println("numero en " +j+ " es :" + ordenInstrucciones[j]);
            for(int i = j;i<llavesConsulta.length;i++){
                if(ordenInstrucciones[j]>ordenInstrucciones[i]){
                    System.out.println("El orden de las instrucciones no es permitido");
                    return null;
                }
            }
        }
        
        if(auxiliar.containsKey(ClausulasSQL[0]) && auxiliar.containsKey(ClausulasSQL[1])){
        }else{
            System.out.println("La consulta no tiene SELECT Y/O FROM");
            return null;//se comprueba que en la consulta recibida esten las palabras SELECT
            //y FROM pues sin ellas la consulta no podria seleccionar que cosa va a mostrar ni de donde va a sacar
            //su informacion
        }
        
        
        
        
        
        
        

        
        return accionesConsulta;
    }
    
    public void ejecutarConsulta(){//falta agregar lo de comprobar sintaxis
        
        descriptor = new DescriptorArchivos(nombreTabla);
        
        try {
            
            String[] atributos = descriptor.vaciarContenido();//se manda a llamar al metodo que va a leer el archivo especificado, y luego
            //se recibe de ese mismo metodo un arreglo de Strings, que contiene los nombres de los atributos de la tabla para que se puedan poner
            //en las columnas de la tabla
            if (atributos == null){
        
                return;
            }

            Vector<Vector> grande = new Vector<>(); //defino un vector de vectores
            grande = descriptor.contenido(); //voy a guardar dentro de grande el vector de vectores que se obtiene
            //de leer los datos del .txt
            if (grande == null){
                return;
            }
            
            for(Vector vectorcitos: grande){ //se va a iterar en este ciclo a traves de todos los vectores que esten dentro
                //del vector "grande", dentro de estos "vectorcitos" se encuentran 3 cadenas (recordando del ejemplo que esta
                //explicado en la funcion contenido de la clase DescriptorArchivos), es necesario regresarlo asi, porque
                //el metodo addRow añade las cadenas dentro de un Vector, por eso se tiene que entrar de esta forma
                //en este caso, el vectorcito contiene 3 cadenas, por lo que el metodo pone la primera cadena
                //en la primera columna, la segunda en la segunda columna y de esa manera.
                
            }
            
            
            
           
        } catch (IOException ex) {
            return;
        }
    }
    public static void main(String args[]){
        
        LogicaSQL prueba = new LogicaSQL("SELECT \n DE \n PRUEBA  FROM  WHERE j","hola.txt");
        
        System.out.println("prueba = " + prueba.getConsulta());
        
        prueba.limpiarConsulta();
        System.out.println("prueba = " + prueba.getConsulta());
        
        prueba.comprobarSintaxis();
    }
    
}