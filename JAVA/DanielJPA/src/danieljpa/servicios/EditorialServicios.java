/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danieljpa.servicios;


import danieljpa.entidades.Editorial;

import danieljpa.persistencias.EditorialDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EditorialServicios  {
    
    public Scanner leer = new Scanner(System.in).useDelimiter("\n"); 
    public final EditorialDAO DAO ;

    public EditorialServicios() {
        this.DAO =  new EditorialDAO();
    }
    
    public Editorial crearEditorial(){
        Editorial edt= new Editorial();
        try {
            DAO.listarEditorial();
            System.out.println("Ingrese el nombre");
            edt.setNombre(leer.next());
            DAO.guardarEditorial(edt);
            return edt;
        } catch (Exception e) {
           System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public Editorial modificarEditorial(){
        
        try {
            DAO.listarEditorial();
            System.out.println("Ingrese el nit de la editorial para modificar");
            Editorial edt= DAO.buscarPrId(leer.nextInt());
            if (edt==null) {
                throw new Exception("El nit no existe");
            }
            System.out.println("Ingrese el nuevo nombre de la editorial "+ edt);
                edt.setNombre(leer.next());
                DAO.modificarEditorial(edt);
                return edt;
        } catch (Exception e) {
            System.out.println("La editorial no existe " + e.getMessage());
            return null;
        }
        
    }
    
    public void eliminar(){
        try {
           DAO.listarEditorial();
            System.out.println("Ingrese el nit de la editorial que desea eliminar");
            Editorial edt = DAO.buscarPrId(leer.nextInt());
            if (edt==null) {
               throw new Exception("El nit no existe");
            }
             edt.setAlta(false);
                DAO.modificarEditorial(edt);
        } catch (Exception e) {
            System.out.println("La editorial no existe " + e.getMessage());
        }
        
        
    }
    
    public void mostrar(List<Editorial> editoriales){
       try {
           
           for (Editorial editorial : editoriales) {
               System.out.println(editorial);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
}
