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
    
    public String getDescripcion(){
        return this.descripcion;
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
        mArticulo mArticle = new mArticulo();
        // Llenamos la variable con los datos desde el modelo
        ArrayList<String> datos = mArticle.consultar();
        
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        // llenamos la pantalla con los datos del modelo
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        // Devolvemos los datos cargados en el modelo de lista
        return modelLista;
    }
    
    public void actualizar(String newCodigo, String newDescripcion, String newPrecio){
        
        // Generamos la nueva linea del registro
        String nuevaLinea = newCodigo + "|" + newDescripcion + "|" + newPrecio;
        String lineaOriginal = this.codigo + "|" +this.descripcion + "|" + this.precio;
        // Imprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mArticulo mArticule = new mArticulo();
        mArticule.update(lineaOriginal, nuevaLinea, "listado_articulo.txt");
    }
    
    public void eleminar(){
        // Registro a eleminar 
        String lineaOriginal = this.codigo.trim() + "|" +this.descripcion.trim() + "|" + this.precio;
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mArticulo mArticule = new mArticulo();
        mArticule.delete(lineaOriginal, "listado_articulo.txt");
    }
}
