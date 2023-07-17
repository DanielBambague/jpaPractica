/*/8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.*/
package danieljpa;

import danieljpa.servicios.AutorServicios;
import danieljpa.servicios.EditorialServicios;
import danieljpa.servicios.LibroServicios;



/**
 *
 * @author Usuario
 */
public class PrincipalLibreria {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) throws Exception {
          LibroServicios ls= new LibroServicios();
        //ls.crearLibro();
        /*EditorialServicios es= new EditorialServicios() ;
        es.crearEditorial();
        es.crearEditorial();*/
        //AutorServicios as= new AutorServicios();
        /*as.crearAutor();
        as.crearAutor();*/
        //as.buscarAutor();
        /*ls.crearLibro();
        ls.crearLibro();
        ls.crearLibro();*/
        //ls.buscarLibroPorAutor();
       //ls.buscarlibroTitulo();
       //ls.darDeBaja();
       ls.buscarLibroPorAutor();
       ls.buscarLibroPorEditorial();
    }
    
}
