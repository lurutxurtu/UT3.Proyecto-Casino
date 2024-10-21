public class Main {
    public static void main(String[] args) {


        Jugador jugador1 = new Jugador("Carlos",260);
        Jugador jugador2 = new Jugador("Marcos",200);
        Jugador jugador3 = new Jugador("Maria", 150);


        Casino casino = new Casino();


        System.out.println(jugador1);
        System.out.println(jugador2);
        System.out.println(jugador3);

        casino.jugarAdivinanza(jugador1,35,2);
        casino.jugarAdivinanza(jugador2,40,1);
        casino.jugarAdivinanza(jugador3,20,3);

        casino.jugarRuleta(jugador1,30,20,false);
        casino.jugarRuleta(jugador1,16,2,true);
        casino.jugarRuleta(jugador2,40,1,true);
        casino.jugarRuleta(jugador3,50,9,false);

        casino.jugarTragaperras(jugador1,70);
        casino.jugarTragaperras(jugador2,40);
        casino.jugarTragaperras(jugador3,30);
        casino.jugarTragaperras(jugador1,50);
        casino.jugarTragaperras(jugador2,150);


        System.out.println("**********Fin del dia********\n");
        System.out.println(jugador1);
        System.out.println(jugador2);
        System.out.println(jugador3);
        System.out.println("\n"+casino);

    }
}