import java.util.Scanner;
class Pessoa{

    String nome;
    int idade;

public Pessoa(String nome, int idade) {

    this.nome = nome;
    this.idade = idade;
}

public String toString() { 
    return "Nome: " + nome + " | " + "Idade: " + idade;
}
}

class Motoca{
        
    int potencia;
    int tempo;
    Pessoa pass;

public Motoca(int tempo, int potencia){

    this.tempo = tempo;
    this.pass = null;
    this.potencia = potencia;
}

void subir(Pessoa pessoa){
    if(pass == null) {
        pass = pessoa;
        System.out.println(pessoa.nome+", "+pessoa.idade+" anos, subiu na moto");
    }else{
        System.out.println("Já tem uma pessoa na moto");
    }
}

Pessoa descer(){
    if(pass == null){
        System.out.println("Não há ninguém na moto");
        return null;
    }else{
        Pessoa aux = pass;
        pass = null;
        System.out.println("Moto vazia");
        return aux;
    }
}

void comprarTempo(int tempo){
    this.tempo += tempo;
    System.out.println("Você comprou "+tempo+" minutos");
}
    
void dirigir(int tempo){
    if(this.pass == null){
        System.out.println("Não tem niguém na moto");
    }else if(pass.idade > 10){
        System.out.println("Idade excedida");
    }else if(this.tempo >= tempo){
        this.tempo -= tempo;
        System.out.println("Você andou por "+tempo+" minutos");
    }else if(this.tempo < tempo){
        System.out.println("Você andou por "+this.tempo+" minutos antes de seu tempo acabar");
        this.tempo = 0;
    }else{
        System.out.println("Você precisa comprar mais tempo");
    }
}

public String toString() {
    return "Tempo: "+tempo+" | Ocupante: "+pass+" | Potencia: "+potencia;
}
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Motoca motoca = new Motoca(0, 1);
        
    while(true){

        String line = scanner.nextLine();
        String[] ui = line.split(" ");

            if(line.equals("fim")){
                System.out.println("Você saiu do interativo");
                break;
            }else if(ui[0].equals("status")){
                System.out.println(motoca);
            }else if(ui[0].equals("subir")){
                String nome = ui[1];
                int idade = Integer.parseInt(ui[2]);
                Pessoa humano = new Pessoa(nome, idade);
                motoca.subir(humano);
            }else if(ui[0].equals("descer")){
                motoca.descer();
            }else if(ui[0].equals("+tempo")){
                motoca.comprarTempo(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("dirigir")){
                motoca.dirigir(Integer.parseInt(ui[1]));
            }else{
                System.out.println("Comando inválido");
            }
        }

        scanner.close();

    }
}

