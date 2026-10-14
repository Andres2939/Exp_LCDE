public class Metodo {
    private Nodo cabeza = null;
    private Nodo actual = null;

    private Nodo buscar(String titulo) {
        Nodo aux = cabeza;
        do {
            if (aux.getDato().getTitulo().equalsIgnoreCase(titulo))
                return aux;
            aux = aux.getSiguiente();
        } while (aux != cabeza);
        return null;
    }

    public String agregarFinal(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion);
        if (cabeza == null) {
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            cabeza = nuevo;
            actual = nuevo;
        } else {
            Nodo ultimo = cabeza.getAnterior();
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
        }
        String agregado = "Agregado correctamente";
        System.out.println(agregado);
        return agregado;
    }

    public boolean agregarSiguiente(String titulo, Cancion cancion) {
        Nodo ref = buscar(titulo);
        Nodo nuevo = new Nodo(cancion);
        Nodo despues = ref.getSiguiente();
        nuevo.setAnterior(ref);
        nuevo.setSiguiente(despues);
        ref.setSiguiente(nuevo);
        despues.setAnterior(nuevo);
        return true;
    }

    public boolean eliminar(String titulo) {
        Nodo nodo = buscar(titulo);
        if (nodo.getSiguiente() == nodo) {
            cabeza = null;
        } else {
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
            if (nodo == cabeza)
                cabeza = nodo.getSiguiente();
        }
        return true;
    }

    public void Mostrar() {
        Nodo aux = cabeza;
        int i = 1;
        do {
            System.out.println(i + ". " + aux.getDato().getTitulo());
            System.out.println(aux.getDato().getAutor());
            aux = aux.getSiguiente();
            i++;
        } while (aux != cabeza);
    }

    public void mostrarActual() {
        System.out.println("Sonando: " + actual.getDato().getTitulo());
        System.out.println("Autor: " + actual.getDato().getAutor());
    }

    public void avanzar() {
        actual = actual.getSiguiente();
        mostrarActual();
    }

    public void retroceder() {
        actual = actual.getAnterior();
        mostrarActual();
    }
}