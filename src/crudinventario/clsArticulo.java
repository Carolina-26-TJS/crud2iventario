/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

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
}
