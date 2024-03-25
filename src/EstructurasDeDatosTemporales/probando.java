/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatosTemporales;

import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class probando {
    private BufferedReader abrirArchivo(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            return new BufferedReader(fr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void vaciarContenido(BufferedReader br) throws IOException {
        if (br != null) {
            String l;
            while ((l = br.readLine()) != null) {
                System.out.println(l);
            }
            // No cierres el BufferedReader aquí
        }
    }

    public static void main(String[] args) throws IOException {
        String prueba = "0123456789";
        String a1,a2;
        a1 = prueba.substring(0, 10);
        System.out.println("a1 = " + a1);
        System.out.println("Longitud "+prueba.length());
        
    }
    
}
