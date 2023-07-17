

package danieljpa.persistencias;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAO<T> {
    
   
     protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("danieljpapu");
    protected EntityManager em = EMF.createEntityManager();
  
     protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    // Este método nos permite desconectarnos de la base de datos
    // Se verifica si existe una conexión, y de ser el caso, se
    // cierra la conexión y se desconecta el programa con la base de datos.
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
   
   protected void  guardar(T object){
      conectar();
       em.getTransaction().begin();
       em.persist(object);
       em.getTransaction().commit();
       desconectar();
   }
   
   public void modificar(T object){
       conectar();
       em.getTransaction().begin();
       em.merge(object);
       em.getTransaction().commit();
       desconectar();
       
 }
   
}
