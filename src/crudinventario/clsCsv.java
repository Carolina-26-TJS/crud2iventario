/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author carol
 */
public class clsCsv {
    //Atributo del objeto CSV2
    String archivo = "Inventario.csv";
    
    //Metodo del objeto CSV2
    public void importarDatos(){
        try(BufferedReader br = new BufferedReader( new FileReader(archivo))){
            br.readLine(); //Salta la primera linea
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                //Asignacion de valores para insertar datos.
                clsArticulo cArticulo = new clsArticulo(
                    datos[0], datos[1], Double.parseDouble(datos[2]));
                //Alamacena en archivo txt
                cArticulo.guardar();
            }
            br.close();
            System.out.println("Se ha terminado con la importacion :");
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());

        } 
    }
    
}
