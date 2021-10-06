import java.util.ArrayList;

public class inventario {
   public static ArrayList<producto> selling_list;
   public static  ArrayList<producto> temp_list;
   public static void Actualizar_inventario(ArrayList<producto> list, String operation){
         switch (operation){
             case  "compra":
                 //Método de compra
                 temp_list = list;
                 Compra();
                 break;
             case  "venta":
                 //Método de venta
                 temp_list = list;
                 Venta();
                 break;
             default:
         }

    }

    public static  void Compra()
    {
      if(ExisteInventario()){
            for (int i = 0; i < temp_list.size(); i++) {

                //IF: Validar si existe el producto que se va actualizar, si existe se suma la cantidad actual con la cantidad que se ha comprado
                try {
                    InventarioActual().get(i).cantidad = (temp_list.get(i).cantidad + InventarioActual().get(i).cantidad);
                    InventarioActual().get(i).costo_venta = (temp_list.get(i).costo_venta);
                    InventarioActual().get(i).costo_compra = (temp_list.get(i).costo_compra);
                }catch(IndexOutOfBoundsException exception){
                    //aquí se crea el nuevo producto
                    InventarioActual().add(i, temp_list.get(i));
                }
                //ELSE: insertar esa nueva posición con el producto que no existia
            }
        }else{
            selling_list = temp_list;
        }

    }

    public static void Venta()
    {
        if(ExisteInventario()){
            for (int i = 0; i < temp_list.size(); i++) {

                //IF: Validar si existe el producto que se va actualizar, si existe se suma la cantidad actual con la cantidad que se ha comprado
                try {
                    InventarioActual().get(i).cantidad = (-temp_list.get(i).cantidad + InventarioActual().get(i).cantidad);
                }catch(IndexOutOfBoundsException exception){
                    //aquí se crea el nuevo producto
                    InventarioActual().add(i, temp_list.get(i));
                }
                //ELSE: insertar esa nueva posición con el producto que no existia
            }
        }else{
            selling_list = temp_list;
        }
        //Operación de venta: Debita del inventario
        System.out.println("Aquí debo procesar la venta, es decir debitar de la cantidad actual a la nueva cantidad despues de venta. ");
    }

    public static  Boolean ExisteInventario()
    {
        return (selling_list != null)?true:false;
    }
    public static  ArrayList<producto> ObtenerInventario()
    {
        return selling_list;
    }
    public static ArrayList<producto> InventarioActual()
    {
        return ObtenerInventario();
    }

}
