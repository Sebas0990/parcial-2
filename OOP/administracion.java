import java.util.ArrayList;


/**
 * Online Retail Store Management
 */
public class administracion extends producto  {
    public static int presupuesto = 3000; // presupuesto

    public administracion(String nombre, int cantidad, int costo_compra, int costo_venta) {
        super(nombre, cantidad, costo_compra, costo_venta);
    }

    public static void setPresupuesto(int presupuesto) {
        administracion.presupuesto = presupuesto;
    }

    public static int getPresupuesto() {
        return presupuesto;
    }
    public static void main(String[] args)  {
        int diasRestantes = 3;
        int J_comprados= 10;
        int L_comprados= 10;
        int C_comprados= 10;
        while(diasRestantes<=3){

            int pv_juego = (int) setprice(30, 110);
            int pc_juego = (int) setprice(15, 60);
            int pv_comida = (int) setprice(10, 100);
            int pc_comida = (int) setprice(5, 50);
            int pv_limpieza = (int) setprice(5, 20);
            int pc_limpieza = (int) setprice(1, 10);


            presupuesto-=((J_comprados*pc_juego)+(L_comprados*pc_limpieza)+(C_comprados*pc_comida));

            System.out.println("el presupuesto actual es:" + presupuesto);

            ArrayList<producto> lista_productos = new ArrayList<>();
            lista_productos.add(new producto("Juego",J_comprados,pc_juego,pv_juego));
            lista_productos.add(new producto("Limpieza",L_comprados,pc_limpieza,pv_limpieza));
            lista_productos.add(new producto("Comida",C_comprados,pc_comida,pv_comida));
            //Set
            Actualizar_inventario(lista_productos, "compra");
            //Get
            System.out.println( "inventario inicial:");
            for (int i = 0; i < InventarioActual().size(); i++) {
                System.out.println(InventarioActual().get(i));
            }
            int cantidadClientes = 5;
            for (int j = 1; j < cantidadClientes+1; j++) {
                int cantidadCompras = (int)(Math.random()*(3-1+1)+1);
                int Total_Gastado=0;
                int Total_Personal_Gastado=0;
                System.out.println("persona " + j + " compro: " + cantidadCompras + " items");
                for (int i = 0; i < cantidadCompras; i++) {
                    int objetoComprado = (int)(Math.random()*(3-1+1)+1);
                    if (objetoComprado == 1){
                        Total_Personal_Gastado = Total_Personal_Gastado + pv_comida;
                        System.out.println("compro un producto alimenticio");
                        System.out.println(Total_Personal_Gastado);
                        Total_Gastado = Total_Gastado+Total_Personal_Gastado;
                        C_comprados = C_comprados-1;
                    }
                    else if (objetoComprado == 2){
                        Total_Personal_Gastado = Total_Personal_Gastado + pv_limpieza;
                        System.out.println("compro un producto de limpieza");
                        System.out.println(Total_Personal_Gastado);
                        Total_Gastado = Total_Gastado+Total_Personal_Gastado;
                        L_comprados = L_comprados-1;
                    }
                    else if (objetoComprado == 3){
                        Total_Personal_Gastado = Total_Personal_Gastado + pv_juego;
                        System.out.println("compro un juego");
                        System.out.println(Total_Personal_Gastado);
                        Total_Gastado = Total_Gastado+Total_Personal_Gastado;
                        J_comprados= J_comprados-1;
                    }
                    presupuesto= presupuesto+Total_Gastado;
                }

            }
            diasRestantes--;
            if (diasRestantes == 0){break;}
        }
    }

}
