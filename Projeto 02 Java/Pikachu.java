public class Pikachu{
    int integridade;
    int eletricidade;
    boolean estaVivo;
    boolean eletricidadeReserva;

    Pikachu(int integridade, int eletricidade){
        this.integridade = integridade;
        this.eletricidade = eletricidade;
        this.estaVivo = true;
        this.eletricidadeReserva = true;
    }

    void ataque(){
        if(integridade < 2){
            System.out.println("Não consigo mais lutar.");
            return;
        }
        if(eletricidade > 1){
            System.out.println("Choque do trovão!");
            eletricidade -= 2;
        }else{
            System.out.println("Preciso da eletricidade reserva.");
        }
    }
    
    void defesa(){
        if(integridade > 1){
            integridade -= 2;
            System.out.println("Sofri um ataque, estou mais fraco.");
        }else{
            estaVivo = false;
            System.out.println("Acho que morri, adeus Ash.");
        }
    }

    void pokebola(){
        if(!estaVivo){
            System.out.println("Tarde demais, amigo.");
            return;
        }
        if(eletricidadeReserva){
            eletricidadeReserva = false;
            System.out.println("Recarregando a eletricidade");
            eletricidade += 6;
        }else if(integridade < 5){
            integridade += 6;
            System.out.println("Fiquei forte como um touro");
        }else{
            System.out.println("Não preciso voltar a pokebola, quero lutar!");
        }
    }

    public String toString() {
        return "Pikachu : integridade:" + integridade + " eletricidade:" + eletricidade + " eletricidade reserva:" + eletricidadeReserva;
    }

    public static void main (String[] args) { 
        Pikachu juao = new Pikachu(10, 10);
        for(int i = 0; i < 6; i++){
            juao.ataque();
            System.out.println(juao);
        }

        for(int i = 0; i < 2; i++){
            juao.pokebola();
            System.out.println(juao);
        }
        for(int i = 0; i < 6; i++){
            juao.defesa();
            System.out.println(juao);
        }
        
    }
}