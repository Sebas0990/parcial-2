public class producto extends inventario {
    int costo_compra;
    int costo_venta;
    String nombre;
    int cantidad;
    public producto(String nombre, int cantidad, int costo_compra, int costo_venta){
        this.nombre= nombre;
        this.cantidad = cantidad;
        this.costo_compra = costo_compra;
        this.costo_venta = costo_venta;
    }

    @Override
    public String toString() {
        return "producto{" +
                "costo_compra=" + costo_compra +
                ", costo_venta=" + costo_venta +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public static double setprice(double min, double max) {
        int var = (int) (Math.random() * (max - min + 1)+min);
        return var;
    }
}
