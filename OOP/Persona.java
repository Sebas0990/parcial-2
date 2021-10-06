import java.util.Random;
//comentario
//Qmas
public class Persona {
    private String name;
    private String order;

    public Persona(String name, String order) {
        this.name = name;
        this.order = order;
    }

    public Persona() {
        String names[] = {"Juan", "Melissa", "Andres",
                "Juanita", "Sebastian", "Natalia"};
        Random r = new Random();
        int num = r.nextInt(names.length);
        name = names[num];
        String orders[] = {"Comida", "Limpieza", "Juego "};
        order = orders[r.nextInt(orders.length)];
    }

    public void setOrder(String order) {
        this.order = order;
    }



    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }
}
