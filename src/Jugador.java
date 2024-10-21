public class Jugador {

    private String nombre;
    private double dinero;

    public Jugador(String nombre, double dinero){
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public double getDinero(){ return this.dinero;}
    public String getNombre(){return this.nombre;}

    public void sumarDinero(double dinero){
        this.dinero -= dinero;
    }

    public void restardinero(double dinero){
        this.dinero += dinero;
    }


    public String toString(){
        return "El jugador "+this.nombre+" tiene "+this.dinero+"$";
    }
}
