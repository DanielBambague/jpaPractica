/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danieljpa.servicios;

import danieljpa.entidades.Autor;
import danieljpa.persistencias.AutorDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class AutorServicios {

    public Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public final AutorDAO DAO;

    public AutorServicios() {
        this.DAO = new AutorDAO();
    }

    public void mostrar(List<Autor> autores) {
        try {

            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Autor crearAutor() {
        Autor edt = new Autor();
        try {

            System.out.println("Ingrese el nombre del Autor");
            edt.setNombre(leer.next());
            DAO.guardarAutor(edt);
            return edt;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Autor modificarA() {

        try {
            DAO.listarAutor();
            System.out.println("Ingrese el nit de la Autor para modificar");
            Autor edt = DAO.buscarPrId(leer.nextInt());
            if (edt == null) {
                throw new Exception("El nit no existe");
            }
            System.out.println("Ingrese el nuevo nombre de la Autor " + edt);
            edt.setNombre(leer.next());
            DAO.modificarAutor(edt);
            return edt;
        } catch (Exception e) {
            System.out.println("La Autor no existe " + e.getMessage());
            return null;
        }

    }

    public void eliminar() {
        try {
            DAO.listarAutor();
            System.out.println("Ingrese el nit de la Autor que desea eliminar");
            Autor autor = DAO.buscarPrId(leer.nextInt());
            if (autor == null) {
                throw new Exception("El nit no existe");
            }
            autor.setAlta(false);
            DAO.modificarAutor(autor);
        } catch (Exception e) {
            System.out.println("La Autor no existe " + e.getMessage());
        }

    }

    public void buscarAutor() {
        try {
            String var;
            System.out.println("Ingrese el nombre del autor");
            var=leer.next();
            Autor autor = DAO.buscarPorNombre(var);
            if (var.equalsIgnoreCase(autor.getNombre())) {

                System.out.println(DAO.buscarPorNombre(var));
             }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
