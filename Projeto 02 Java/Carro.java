import java.util.Scanner;

public class Carro{

    int tanque;
    int ocupantes;
    int quilometragem;
    int quantidade;

    Carro(int tanque, int ocupantes, int quilometragem, int quantidade){

        this.tanque = tanque;
        this.ocupantes = ocupantes;
        this.quilometragem = quilometragem;
        this.quantidade = quantidade;
    }

        void entrar(){

            if(ocupantes < 2){
                System.out.println("Entrada permitida");
                ocupantes += 1;
            }else{
                System.out.println("Não há vagas");
            }
        }

        void sair(){

            if(ocupantes > 0){
                System.out.println("Passageiro descendo");
                ocupantes -= 1;
            }else{
                System.out.println("Não há passageiros");
            }
        }

        void abastecer(int quantidade){

            if((quantidade > 0) && (quantidade + tanque < 100)){
                System.out.println("Carro abastecido com sucesso!");
                this.tanque += quantidade;
            }else if(quantidade + tanque >= 100){
                System.out.println("Tanque cheio!");
                this.tanque = 100;
            }else{
                System.out.println("Impossível abastecer");
            }
        }

        void dirigir(int quilometragem){
            if((ocupantes > 0) && (tanque > 0)){
                if(tanque >= quilometragem){
                    System.out.println("Viagem completada com sucesso");
                    this.tanque -= quilometragem;
                }else{
                    System.out.println("Ops, não foi possível completar a viagem, acabou a gasolina, seu carro percorreu "+tanque+" quilômetros");
                }

            }else{
                System.out.println("Impossível dirigir");
            }

            }

    public String toString() {
        return "Carro : Tanque:" + tanque + " ocupantes:" + ocupantes + " quilometragem:" + quilometragem;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro(0,0,0,0);
        
        while(true){

            String line = scanner.nextLine();
            String[] ui = line.split(" ");

                if(line.equals("end")){
                    System.out.println("Você saiu do interativo");
                    break;
                }else if(line.equals("status")){
                    System.out.println(carro);
                }else if(ui[0].equals("entrar")){
                    carro.entrar();
                }else if(ui[0].equals("sair")){
                    carro.sair();
                }else if(ui[0].equals("abastecer")){
                    carro.abastecer(Integer.parseInt(ui[1]));
                }else if(ui[0].equals("dirigir")){
                    carro.dirigir(Integer.parseInt(ui[1]));
                }else{
                    System.out.println("Comando inválido");
                }
            }

        scanner.close();

    }
    }




