package arbolbinariofrutas;

public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(Frutas ff) {
        raiz = insertarRecursivo(raiz, ff);
    }

    private Nodo insertarRecursivo(Nodo nodoActual, Frutas ff) {
        if (nodoActual == null) {
            return new Nodo(ff);
        }

        if (ff.nombre.compareTo(nodoActual.f.nombre) < 0) {
            nodoActual.izq = insertarRecursivo(nodoActual.izq, ff);
        } else if (ff.nombre.compareTo(nodoActual.f.nombre) > 0) {
            nodoActual.der = insertarRecursivo(nodoActual.der, ff);
        }

        return nodoActual;
    }

    public void preOrder() {
        preOrderRecursivo(raiz);
    }

    private void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.f.toString());
            preOrderRecursivo(nodo.izq);
            preOrderRecursivo(nodo.der);
        }
    }
    
    public Frutas buscar(String patron) {
        return buscarRecursivo(raiz, patron);
    }

    private Frutas buscarRecursivo(Nodo nodo, String patron) {
        if (nodo == null) {
            return null;
        }

        if (nodo.f.nombre.matches(patron)) {
            return nodo.f;
        }

        Frutas encontrada = buscarRecursivo(nodo.izq, patron);
        if (encontrada != null) {
            return encontrada;
        }

        encontrada = buscarRecursivo(nodo.der, patron);
        if (encontrada != null) {
            return encontrada;
        }

        return null;
    }

    public boolean actualizar(String nombre, Frutas nuevaFruta) {
        Nodo nodo = buscarNodo(raiz, nombre);
        if (nodo != null) {
            nodo.f = nuevaFruta;
            return true;
        }
        return false;
    }

    public boolean eliminar(String nombre) {
        Nodo padre = null;
        Nodo nodo = raiz;

        while (nodo != null) {
            int comparacion = nombre.compareTo(nodo.f.nombre);

            if (comparacion == 0) {
                eliminarNodo(padre, nodo);
                return true;
            } else if (comparacion < 0) {
                padre = nodo;
                nodo = nodo.izq;
            } else {
                padre = nodo;
                nodo = nodo.der;
            }
        }

        return false;
    }

    private void eliminarNodo(Nodo padre, Nodo nodo) {
        if (nodo.izq == null && nodo.der == null) {
            if (padre == null) {
                raiz = null;
            } else if (padre.izq == nodo) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
        } else if (nodo.izq != null && nodo.der != null) {
            Nodo sucesor = encontrarSucesor(nodo.der);
            nodo.f = sucesor.f;
            eliminarNodo(nodo.der, sucesor);
        } else {
            Nodo hijo = (nodo.izq != null) ? nodo.izq : nodo.der;
            if (padre == null) {
                raiz = hijo;
            } else if (padre.izq == nodo) {
                padre.izq = hijo;
            } else {
                padre.der = hijo;
            }
        }
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    private Nodo buscarNodo(Nodo nodo, String nombre) {
        if (nodo == null || nodo.f.nombre.equals(nombre)) {
            return nodo;
        }

        if (nombre.compareTo(nodo.f.nombre) < 0) {
            return buscarNodo(nodo.izq, nombre);
        } else {
            return buscarNodo(nodo.der, nombre);
        }
    }
}
