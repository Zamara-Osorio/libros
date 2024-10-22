import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros;
    private int contadorId;

    public LibroDAOImpl() {
        this.libros = new ArrayList<>();
        this.contadorId = 1; // Comenzamos el ID en 1
    }

    @Override
    public void crear(Libro libro) {
        libro = new Libro(contadorId++, libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
        libros.add(libro);
    }

    @Override
    public Libro leer(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }

    @Override
    public List<Libro> listar() {
        return libros;
    }
}
