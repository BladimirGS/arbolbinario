
package arbolbinariofrutas;

public class Nodo {
    Frutas f ;
    Nodo izq, der;

    public Nodo(Frutas f) {
        this.f = f;
        this.der=this.izq=null;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}
