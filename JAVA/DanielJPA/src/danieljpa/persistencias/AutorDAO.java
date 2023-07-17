/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danieljpa.persistencias;

import danieljpa.entidades.Autor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AutorDAO extends DAO<Autor>{

    public AutorDAO() {
    }
    
    public void guardarAutor(Autor autor){
        super.guardar(autor);
    }
    
    
    
   public List<Autor > listarAutor() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autores a WHERE a.alta = 1")
                .getResultList();
         
        desconectar();
        return autores;
    }
   
   public Autor buscarPrId(Integer id) throws Exception {
       conectar();
       Autor autores = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
                               .setParameter("id", id).getSingleResult();
       desconectar();
       return autores;
   }
   
   public Autor buscarPorNombre(String nombre) throws Exception{
       conectar();
       Autor autores = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                               .setParameter("nombre", nombre).getSingleResult();
       desconectar();
       return autores;
   }
    
   public Autor modificarAutor(Autor autor){
       conectar();
       super.modificar(autor);
       desconectar();
       return autor;
   }
    
   
}
