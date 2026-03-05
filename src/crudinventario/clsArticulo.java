/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author carol
 */
public class clsArticulo {
    
    // Atributo que necesito que tenga mi objeto articulo
    private String codigo;
    private String descripcion;
    private Double precio;

    // Constructor
    public clsArticulo(String codigo, String descripcion, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    // Sobrecarga de metodo constructor
    public clsArticulo(){
    }
    
    
    // Imprimir en consola los datos del articulo
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio;
        return articulo;
    }
    
    // Guardar informacion
    public void guardar(){
        // Instanciando la clase de MODELO
        mArticulo article = new mArticulo();
        // Enviamos la cadena de texto para guardar en el archivo
        article.insertar(this.aTexto());
    
        System.out.print(this.aTexto());
    }
    
    public DefaultListModel llenarLista(){
        // Instancia desde los datos (modelo)
        mArticulo mArticuleArticulo = mArticule.consultar();
        // Llenamos la variable con los datos desde el modelo
        ArrayList<String> datos = mArticuleArticulo.consultar();
        
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        // llenamos la pantalla con los datos del modelo
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        // devolvemos los datos cargados en el modelo de lista
        return modelLista;
    }
}
