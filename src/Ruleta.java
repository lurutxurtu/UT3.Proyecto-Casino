public class Ruleta {

    private double beneficio;

    public Ruleta(){
        this.beneficio = 0;
    }

    private int girarRuleta(){
        return (int) (Math.random() * (36+1));
    }

    private void distribuirApuesta(Jugador jugador, double apuesta, boolean jugadorGana){
        if(jugadorGana){
            jugador.sumarDinero(apuesta);
            this.beneficio -= apuesta;
            System.out.println("El jugador "+jugador.getNombre()+" ha ganado "+ apuesta+"$");
        }else{
            jugador.restardinero(apuesta);
            this.beneficio += apuesta;
            System.out.println("El jugador "+jugador.getNombre()+" ha perdido "+ apuesta+"$");

        }
    }

    public void jugarAlColor(Jugador jugador, int color, double apuesta){
        System.out.println("\n----"+jugador.getNombre()+" esta jugando en la ruleta a color-----");
        int numero = girarRuleta();
        System.out.println("Girando......\nNumero ganador: "+numero);
        if ((color == 2)&&(numero % 2 == 0)&&(numero != 0)){
            double ganancia1 = apuesta *2;
            distribuirApuesta(jugador,ganancia1,true);
        }else if ((color == 1)&&(numero % 2 != 0)){
            double ganancia2 = apuesta * 2;
            distribuirApuesta(jugador,ganancia2,true);
        }else {
            distribuirApuesta(jugador,apuesta,false);
        }
    }

    public void jugarAlNumero(Jugador jugador,int numero,double apuesta){
        System.out.println("\n----"+jugador.getNombre()+" esta jugando en la ruleta a numero-----");
        int numero1 = girarRuleta();
        System.out.println("Girando......\nNumero ganador: "+numero1);
        if (numero == numero1){
            double ganancia = apuesta * 35;
            distribuirApuesta(jugador,ganancia,true);
        }else {
            distribuirApuesta(jugador,apuesta,false);
        }
    }

    public double getBeneficio(){
        return this.beneficio;
    }
}
