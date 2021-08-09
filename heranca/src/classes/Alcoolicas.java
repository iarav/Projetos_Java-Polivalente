package classes;

 // @autores Madu e Diego

public class Alcoolicas extends Bebidas{
    private int Idade_minima;
    private String Maleficios;

public Alcoolicas (){
    super();                   //Mesma coisa que colocar só Public Alunos (){ };  
    Idade_minima=0;            //Só que desse jeito remove todo lixo possivel
    Maleficios=null;
} 

public Alcoolicas (String Nome, Double Preco, String Marca, String Sabor, String Composicao, int Idade_Minima, String Maleficios) {
    super(Nome,Preco,Marca,Sabor,Composicao);  //Puxa os atributos da classe ancestral
    this.Idade_minima=Idade_Minima;
    this.Maleficios=Maleficios;
}

public int getIdade_minima(){
    return Idade_minima;
}

public String getMaleficios(){
    return Maleficios;
}

public void  setIdade_minima(int I) {
    Idade_minima=I;
}

public void setMaleficios(String Male){
    Maleficios=Male;
}

    public void mostrar_dados(){   //Esse método vai ser usado para criar um objeto na Herenca.java
            System.out.println("Nome: " + getNome());
            System.out.println("Preço: R$" + getPreco());
            System.out.println("Marca: " + getMarca()); 
            System.out.println("Sabor: " + getSabor());
            System.out.println("Composição: " + getComposicao());
            System.out.println("Idade Mínima: " + getIdade_minima());
            System.out.println("Malefícios: " + getMaleficios());
    }
}

