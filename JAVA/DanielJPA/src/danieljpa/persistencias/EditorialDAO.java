/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danieljpa.persistencias;

import danieljpa.entidades.Editorial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EditorialDAO extends DAO<Editorial>{

    
    
    public void guardarEditorial(Editorial editorial){
        super.guardar(editorial);
    }
    
    
    
   public List<Editorial > listarEditorial() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.alta = 1")
                .getResultList();
         mostrar(editoriales);
        desconectar();
        return editoriales;
    }
   
   public Editorial buscarPrId(Integer id) throws Exception {
       conectar();
       Editorial editoriales = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id")
                               .setParameter("id", id).getSingleResult();
       desconectar();
       return editoriales;
   }
   
   
    
   public Editorial modificarEditorial(Editorial edt){
       conectar();
       super.modificar(edt);
       desconectar();
       return edt;
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
