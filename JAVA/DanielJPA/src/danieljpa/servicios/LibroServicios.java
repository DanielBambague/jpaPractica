/*8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.*/
package danieljpa.servicios;


import danieljpa.entidades.Autor;
import danieljpa.entidades.Libro;
import danieljpa.persistencias.LibroDAO;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class LibroServicios {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final LibroDAO DAO;
    private final AutorServicios as;
    private final EditorialServicios es;

    public LibroServicios() {
        this.as = new AutorServicios();
        this.es = new EditorialServicios();
        this.DAO = new LibroDAO();
    }

    public void mostrar(List<Libro> libros) {
        try {

            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearLibro() throws Exception {

        Libro l1 = new Libro();

        System.out.println("Ingrese el nombre del libro");
        l1.setTitulo(leer.next());
        System.out.println("Ingrese el año de publicación del libro");
        l1.setAnio(leer.nextInt());
        System.out.println("Ingrese cantidad de ejemplares");
        l1.setEjemplares(leer.nextInt());
        System.out.println("Ingrese la cantidad de libros prestados");
        l1.setPrestados(leer.nextInt());
        l1.setRestantes(librosRestantes(l1.getEjemplares(), l1.getPrestados()));
        System.out.println("libros restantes: " + l1.getRestantes());

        System.out.println("sección autor del libro\n ingrese el id del autor");
        l1.setAutor(as.DAO.buscarPrId(leer.nextInt()));

        System.out.println("sección Editorial del libro");
        l1.setEditorial(es.DAO.buscarPrId(leer.nextInt()));
        DAO.guardarLibro(l1);
    }

    public void buscarlibroTitulo() {
        try {
            String var;
            System.out.println("Ingrese el nombre del libro");
            var = leer.next();
            Libro libro = DAO.buscarPorTitulo(var);
            if (var.equalsIgnoreCase(libro.getTitulo())) {

                System.out.println(DAO.buscarPorTitulo(var));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void buscarLibroPorAutor() {
        try {
            String var;
           
            System.out.println("****Buscar Libro por Autor****\nIngrese el nombre del Autor");
            var = leer.next();
            List<Libro> libro = DAO.buscarPorAutor(var);
            if (libro.toString().contains(var)&&libro.toString().contains("true")) {
                mostrar(DAO.buscarPorAutor(var));
            }else{
                System.out.println("no existen libros asignados a este autor");
            }
        }catch (Exception e) {
                e.printStackTrace();
                }

        }
    
    public void buscarLibroPorEditorial() {
        try {
            String var;
            mostrar(DAO.listarLibros());
            System.out.println("****Buscar Libro por editorial****\nIngrese el nombre de la editorial");
            var = leer.next();
            List<Libro> libro = DAO.buscarPorEditorial(var);
            if (libro.toString().contains(var)&&libro.toString().contains("true")) {
                mostrar(DAO.buscarPorEditorial(var));
            }else{
                System.out.println("no hay libros asignados a esta editorial");
            }
        }catch (Exception e) {
                e.printStackTrace();
                }

        }
    
    public Integer librosRestantes(Integer e, Integer p) {
        int r;
        r = e - p;
        return r;
    }

    public void buscarPorISBN() {
        try {
            Long isbn;
            System.out.println("****digite el isbn del libro a buscar****");
            isbn = leer.nextLong();
            Libro libro = DAO.buscarPrId(isbn);
            if (isbn == libro.getId()) {
                System.out.println(DAO.buscarPrId(isbn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void darDeBaja() {
        try {
            Long isbn;
            mostrar(DAO.listarLibros());
            System.out.println("****Eliminar  libro****\nDigite el ISBN del libro");
            isbn=leer.nextLong();
            Libro l = DAO.buscarPrId(isbn);
            if (l!=null) {
               l.setAlta(false);
            DAO.modificarLibro(l);
            DAO.guardarLibro(l);
            }
            
            mostrar(DAO.listarLibros());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
