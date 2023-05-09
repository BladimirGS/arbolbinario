
package arbolbinariofrutas;

public class Frutas {
    String nombre;
    int precio;
    public Frutas(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return nombre +" $" + precio;
    }
}
