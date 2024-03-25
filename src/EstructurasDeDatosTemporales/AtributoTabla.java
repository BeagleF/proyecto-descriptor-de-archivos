/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatosTemporales;

/**
 *
 * @author Alexis
 */
public class AtributoTabla {
    
    private String NombreAtributo;
    private int[] posicionesAtributo = new int[2];
    
    AtributoTabla(){
        this.NombreAtributo = "";
        this.posicionesAtributo[0] = 1;
        this.posicionesAtributo[1] = 2;
    }
    
    AtributoTabla(String nombre,int inicio,int fin){
        super();
        this.NombreAtributo = nombre;
        this.posicionesAtributo[0] = inicio;
        this.posicionesAtributo[1] = fin;
           
    }

    public String getNombreAtributo() {
        return NombreAtributo;
    }

    public void setNombreAtributo(String NombreAtributo) {
        this.NombreAtributo = NombreAtributo;
    }

    public int[] getPosicionesAtributo() {
        return posicionesAtributo;
    }

    public void setPosicionesAtributo(int[] posicionesAtributo) {
        this.posicionesAtributo = posicionesAtributo;
    }
    
}
