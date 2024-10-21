public class Tragaperras {

    private double beneficio;

    public Tragaperras(){
        this.beneficio = 0;
    }

    private int obtenerNumero(){
        return (int) (Math.random() * 9 + 1);
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


    public void jugar(Jugador jugador, double apuesta){
        System.out.println("\n----"+jugador.getNombre()+" esta jugando a la tragaperras-----");
        int n1 = obtenerNumero();
        int n2 = obtenerNumero();
        int n3 = obtenerNumero();
        System.out.println("Girando......\n*****  "+n1+"-"+n2+"-"+n3+"  *****");
        if(n1==n2 && n2==n3){
            double ganancia1 = apuesta*15;
            distribuirApuesta(jugador, ganancia1,true);
        }else if(n1==n2 || n1==n3 || n2==n3){
            double ganancia2 = apuesta*1.5;
            distribuirApuesta(jugador, ganancia2, true);
        }else if((n2==n1-1 && n3==n1-2)||(n2==n1+1 && n3==n1+2)){
            double ganancia3 = apuesta*10;
            distribuirApuesta(jugador, ganancia3, true);
        } else {
            distribuirApuesta(jugador, apuesta, false);
        }

    }

    public double getBeneficio(){
        return this.beneficio;
    }
}
