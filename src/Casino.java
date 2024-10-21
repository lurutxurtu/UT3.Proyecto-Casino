public class Casino {

    public static final int APUESTA_MAXIMA = 50;
    private Ruleta ruleta;
    private Adivinanza adivinanza;
    private Tragaperras tragaperras;


    public Casino(){
        this.adivinanza = new Adivinanza();
        this.tragaperras = new Tragaperras();
        this.ruleta= new Ruleta();
    }

    public void jugarRuleta(Jugador jugador,double apuesta,int numero,boolean jugarAlColor){
        if(!alertaMorosos(jugador,apuesta) && !alertaTemerarios(jugador, apuesta)) {
            if (jugarAlColor) {
                this.ruleta.jugarAlColor(jugador, numero, apuesta);
            } else {
                this.ruleta.jugarAlNumero(jugador, numero, apuesta);
            }
        }
    }

    public void jugarTragaperras(Jugador jugador,double apuesta){
        if(!alertaMorosos(jugador,apuesta) && !alertaTemerarios(jugador, apuesta)) {
            this.tragaperras.jugar(jugador, apuesta);
        }
    }

    public void jugarAdivinanza(Jugador jugador,double apuesta,int intervalo){
        if(!alertaMorosos(jugador,apuesta) && !alertaTemerarios(jugador, apuesta)){
            this.adivinanza.jugar(jugador,apuesta,intervalo);
        }
    }

    private boolean alertaMorosos(Jugador jugador,double apuesta){
        if(jugador.getDinero() < apuesta){
            System.out.println("******ALERTA MOROSOS******\n*EL JUGADOR "+jugador.getNombre()+" NO TIENE DINERO PARA APOSTAR*");
            return true;
        }else{
            return false;
        }
    }

    private boolean alertaTemerarios(Jugador jugador,double apuesta){
        if(apuesta > APUESTA_MAXIMA){
            System.out.println("*******ALERTA TEMERARIOS*********\n*EL JUGADOR "+jugador.getNombre()+" ESTA INTENTANDO APOSTAR MUCHO DINERO*");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "El casino ha obtenido un beneficio total de "+(adivinanza.getBeneficio()+ruleta.getBeneficio()+tragaperras.getBeneficio())+"$";
    }
}
