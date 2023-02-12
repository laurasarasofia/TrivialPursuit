

public class Tekoaly extends Pelaaja{ //tekoäly perii pelaajan ominaisuudet

    boolean vaikea;

    public Tekoaly(boolean vaikea){
        this.vaikea = vaikea;
    }
 
    public boolean onkoAI(){
        return true;
    }
    public boolean onkoVaikea(){
        return vaikea;
    }

    
  
}
