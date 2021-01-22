package pet;
import java.util.Scanner;
public class Tamagotchi{
    int energia;
    int energiaMax;
    int saciedade;
    int saciedadeMax;
    int limpeza;
    int limpezaMax;
    int diamantes;
    int idade;
    boolean vivo;
    
Tamagotchi(int energiaMax, int saciedadeMax, int limpezaMax){
     
    this.energia = energiaMax;
    this.energiaMax = energiaMax;
    this.saciedade = saciedadeMax;
    this.saciedadeMax = saciedadeMax;
    this.limpeza = limpezaMax;
    this.limpezaMax = limpezaMax;
    this.diamantes = 0;
    this.idade = 0;
    this.vivo = true;
      
}
  
void setEnergia (int valor){
    this.energia = valor;
        if(energia <= 0){
            this.energia = 0;
            this.vivo = false;
            System.out.println("O Tamagotchi morreu de cansaço!");
        }if(energia > energiaMax){
            energia = energiaMax;
        }
}
  
void setSaciedade(int valor){
    this.saciedade = valor;
        if(saciedade <= 0){
            this.saciedade = 0;
            this.vivo=false;
            System.out.println("O Tamagotchi morreu de fome!");
        }if(saciedade > saciedadeMax){
            saciedade = saciedadeMax;
        }
}
 
void setLimpeza(int valor){
    this.limpeza = valor;
        if(limpeza <= 0){
            this.limpeza = 0;
            this.vivo = false;
            System.out.println("O Tamagotchi morreu por falta de higiene!");
        }if(limpeza > limpezaMax){
            limpeza = limpezaMax;
        }
}
  
boolean setVivo(){
    if(!vivo){
        System.out.println("O Tamagotchi está morto!");
        return false;
    }
    return true;
}
 
void brincar(){
    if(setVivo()){
        setEnergia(energia - 2);
        setSaciedade(saciedade - 1);
        setLimpeza(limpeza - 3);
        diamantes += 1;
        idade += 1;
    }
}
 
void comer(){
    if(setVivo())
        setEnergia(energia - 1);
        setSaciedade(saciedade + 4);
        setLimpeza(limpeza - 2);
        idade += 1;
}

void banho(){
    if(setVivo()){
        setEnergia(energia - 3);
        setSaciedade(saciedade - 1);
        setLimpeza(limpeza = limpezaMax);
        idade += 2;
    }
}

void dormir(){
    if(tavivo()){
        if(energia > (energiaMax - 5)){
            System.out.println("Tamagotchi sem sono");
        }else{
            setEnergia(energiaMax);
        }
    }
}

public String toString(){
    return "Energia: " + energia + " || " + "Saciedade: " + saciedade + " || " + "Limpeza: " + limpeza + " || " + "Diamantes: " + diamantes + " || " + "Idade: " + idade; 
}
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Tamagotchi juao = new Tamagotchi(0,0,0);
        System.out.println("Digite um comando");

            while(true){
                String line = scanner.nextLine();
                String[]ui=line.split(" ");
                if(ui[0].equals("Sair")){
                    System.out.println("Você saiu do interativo!");
                    break; 
                }else if(ui[0].equals("Resetar")){
                        juao = new Tamagotchi(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));
                } else if(ui[0].equals("Brincar")){
                    juao.brincar(); 
                    System.out.println(juao);
                }else if(ui[0].equals("Comer")){
                    juao.comer(); 
                    System.out.println(juao);
                }else if(ui[0].equals("Banho")){
                    juao.banho(); 
                    System.out.println(juao);
                }else if(ui[0].equals("Dormir")){
                    juao.dormir();
                    System.out.println(juao);
                }else{
                    System.out.println("Comando inválido");
                }
                }   
            scanner.close();
            }
}