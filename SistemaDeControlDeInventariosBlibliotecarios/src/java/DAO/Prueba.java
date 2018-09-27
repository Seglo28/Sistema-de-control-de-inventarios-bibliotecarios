
package DAO;

import Modelo.Libros;

public class Prueba {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
       // try{
        Conexion conn = new Conexion();
        LibrosDAO libdao = new LibrosDAO(conn);
        /*Libros  lib;
            lib = libdao.Insertar(lb);
        lib.setNombre("Gloria");
        lib.setFecha_de_publicacion("21 de septiembre de 1947");
        lib.setTomo(6);
        lib.setEdicion("nueve");
        lib.setPaginas(100);
        lib.setGenero("misterio");
        }catch(Exception e){
            System.out.println("Error al insertar libros"+e);
        }*/
        
    }
        
}
