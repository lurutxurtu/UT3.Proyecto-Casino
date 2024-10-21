public class Adivinanza {

    private double beneficio;

    public Adivinanza(){
        this.beneficio = 0;
    }

    private int obtenerNumero(int min, int max){
        return (int)(Math.random() *(max-min+1)) + min;
    }

    public void jugar(Jugador jugador, double apuesta, int intervalo){
        System.out.println("\n----"+jugador.getNombre()+" esta jugando a la adivinanza-----");
        int min = (int)(Math.random() * 100);
        int max = (int)(Math.random() * 100);
        if (min > max){
            System.out.println("*Min < Max* Has perdido :(");
            distribuirApuesta(jugador,apuesta,false);
        }else {
            int numeroGanador = obtenerNumero(min, max);
            double tamanoIntervalo = (max - min) / 3.00;
            System.out.println("Rango entre: "+min+" y "+max);
            System.out.println("Intervalo 1: " +  min + "-" + (int) (min + tamanoIntervalo) + "\nIntervalo 2: " + (int) (min + tamanoIntervalo) + "-" + (int) (max - tamanoIntervalo) + "\nIntervalo 3: " + (int) (max - tamanoIntervalo) + "-" + max + "\nHa apostado al intervalo: " + intervalo + "\n-----Ha salido el numero: " + numeroGanador);
            if ((min <= numeroGanador && numeroGanador < (min + tamanoIntervalo)) && intervalo == 1) {
                double ganancia1 = apuesta * 2.5;
                distribuirApuesta(jugador, ganancia1, true);
            } else if (((min + tamanoIntervalo) <= numeroGanador && numeroGanador <= (max - tamanoIntervalo)) && intervalo == 2) {
                double ganancia1 = apuesta * 2.5;
                distribuirApuesta(jugador, ganancia1, true);
            } else if (((max - tamanoIntervalo) < numeroGanador && numeroGanador <= (max)) && intervalo == 3) {
                double ganancia1 = apuesta * 2.5;
                distribuirApuesta(jugador, ganancia1, true);
            } else {
                distribuirApuesta(jugador, apuesta, false);
            }
        }
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

    public double getBeneficio(){
        return this.beneficio;
    }
}
