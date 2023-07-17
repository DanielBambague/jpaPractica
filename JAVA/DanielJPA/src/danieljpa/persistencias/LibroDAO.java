/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danieljpa.persistencias;

import danieljpa.entidades.Libro;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LibroDAO extends DAO<Libro> {

    
    
    public void guardarLibro(Libro l){
        super.guardar(l);
        
    }
    
    public List<Libro> listarLibros() throws Exception{
        conectar();
        List<Libro> libros= em.createQuery("SELECT l FROM Libro l WHERE l.alta=1").getResultList();
         desconectar();
         return libros;
        
    }
    
    public Libro buscarPorTitulo(String nombre) throws Exception{
       conectar();
       Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo")
                               .setParameter("titulo", nombre).getSingleResult();
       desconectar();
       return libro;
   }
    
    public List<Libro> buscarPorAutor(String nombreAutor) throws Exception{
       conectar();
        

        String jpql = "SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre = :nombreAutor";

        List<Libro> libros = em.createQuery(jpql, Libro.class)
        .setParameter("nombreAutor", nombreAutor)
        .getResultList();
        if (libros.isEmpty()) {
            System.out.println("Este autor no tiene aun libros asignados o el autor no existe");
        }
        listarLibros();
       desconectar();
       
       return libros;
   }
     public List<Libro> buscarPorEditorial(String nombreEditorial) throws Exception{
       conectar();
        

        String jpql = "SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre = :nombreEditorial";

        List<Libro> libros = em.createQuery(jpql, Libro.class)
        .setParameter("nombreEditorial", nombreEditorial)
        .getResultList();
        if (libros.isEmpty()) {
            System.out.println("Esta editorial no tiene libros asignados o la editorial no existe");
        }
       desconectar();
       
       return libros;
   }
    
    public Libro buscarPrId(Long id) throws Exception {
       conectar();
       Libro libro =   em.find(Libro.class, id);
        desconectar();
       return libro;
   }
    
      public Libro modificarLibro(Libro libro){
    conectar();
    super.modificar(libro);
    desconectar();
    return libro;
    }
    
    
}
