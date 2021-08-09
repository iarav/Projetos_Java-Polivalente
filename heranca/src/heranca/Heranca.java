package heranca;

import classes.Alcoolicas;  

// @author medgoncalez-infi171

public class Heranca {

    public static void main(String[] args) {  //Precisa ter isso no começo para o resto do código funcionar
        
        Alcoolicas Alcoolica1, Alcoolica2;    //Criação do objeto
            Alcoolica1 = new Alcoolicas("Licor",59.90,"Shinsei","Cereja","açúcar, xarope, álcool, frutas, plantas e ervas",18,"Dependência");
            Alcoolica2 = new Alcoolicas("Cachaça",62.58,"Schermann","Neutro","Água, açúcares, fibras, compostos nitrogenados, lipídeos, ácidos orgânicos, substâncias pécticas e gomas",18,"Embriaguez");
            
            /*
            System.out.println("Nome: " + Alcoolica1.getNome());
            System.out.println("Preço: R$" + Alcoolica1.getPreco());
            System.out.println("Marca: " + Alcoolica1.getMarca()); 
            System.out.println("Sabor: " + Alcoolica1.getSabor());
            System.out.println("Composição: " + Alcoolica1.getComposicao());
            System.out.println("Idade Mínima: " + Alcoolica1.getIdade_minima());
            System.out.println("Malefícios: " + Alcoolica1.getMaleficios());
            */
            
            Alcoolica1.mostrar_dados();
            System.out.println("");
            Alcoolica2.mostrar_dados();
            //Se houvesse 10 objetos, teria que colocar o método mostrar dados pra cada um, ou usar ou para(for)
            
            
          
    }
}
