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
public class clsCliente {
    
    // Atributo que necesito que tenga mi objeto atributo
    private String NoCliente;
    private String Nombre;
    private String TipoCliente;
    private String RazonSocial;

    // Constructor
    public clsCliente(String NoCliente, String Nombre, String TipoCliente, String RazonSocial){
        this.NoCliente = NoCliente;
        this.Nombre = Nombre;
        this.TipoCliente = TipoCliente;
        this.RazonSocial = RazonSocial;
    }
    
    // Sobrecarga de metodo constructor
    public clsCliente(){
    }
    
    
    // Imprimir en consola los datos del cliente
    public String aTexto(){
        String cliente = this.NoCliente + "|" + this.Nombre + "|" + this.TipoCliente + "|" + this.RazonSocial;
        return cliente;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    // Guardar informacion
    public void guardar(){
        // Instanciando la clase de MODELO
        mCliente cliente = new mCliente();
        // Enviamos la cadena de texto para guardar en el archivo
        cliente.insertar(this.aTexto());
    
        System.out.print(this.aTexto());
    }
    
    public DefaultListModel llenarLista(){
        // Instancia desde los datos (modelo)
        mCliente mclient = new mCliente();
        // Llenamos la variable con los datos desde el modelo
        ArrayList<String> datos = mclient.consultar();
        
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        // llenamos la pantalla con los datos del modelo
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        // Devolvemos los datos cargados en el modelo de lista
        return modelLista;
    }
        
    public void actualizar(String newNoCliente, String newNombre, String newTipoCliente, String newRazonSocial){
        
        // Generamos la nueva linea del registro
        String nuevaLinea = newNoCliente + "|" + newNombre + "|" + newTipoCliente + "|" + newRazonSocial;
        String lineaOriginal = this.NoCliente + "|" + this.Nombre + "|" + this.TipoCliente + "|" + this.RazonSocial;
        // Imprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mCliente mClient = new mCliente();
        mClient.update(lineaOriginal, nuevaLinea, "listado_cliente.txt");
    }
    
    public void eliminar(){
        // Registro a eleminar 
        String lineaOriginal = this.NoCliente.trim() + "|" +this.Nombre.trim() + "|" + this.TipoCliente.trim() + "|" + this.RazonSocial.trim();
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mCliente mClient = new mCliente();
        mClient.delete(lineaOriginal, "listado_cliente.txt");
    }
}