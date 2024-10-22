public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        // Crear libros
        libroDAO.crear(new Libro(0, "Cien años de soledad", "Gabriel García Márquez", 1967));
        libroDAO.crear(new Libro(0, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

        // Listar libros
        System.out.println("Libros en la colección:");
        for (Libro libro : libroDAO.listar()) {
            System.out.println(libro);
        }

        // Leer un libro
        Libro libroLeido = libroDAO.leer(1);
        System.out.println("\nLibro leído:");
        System.out.println(libroLeido);

        // Actualizar un libro
        libroLeido = new Libro(libroLeido.getId(), "Cien años de soledad", "Gabriel García Márquez", 1970);
        libroDAO.actualizar(libroLeido);

        // Listar libros después de la actualización
        System.out.println("\nLibros después de la actualización:");
        for (Libro libro : libroDAO.listar()) {
            System.out.println(libro);
        }

        // Eliminar un libro
        libroDAO.eliminar(2);
        System.out.println("\nLibros después de eliminar:");
        for (Libro libro : libroDAO.listar()) {
            System.out.println(libro);
        }
    }
}
