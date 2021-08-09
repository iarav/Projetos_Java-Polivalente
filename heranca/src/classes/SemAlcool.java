package classes;

 // @autores Madu e Diego

public class SemAlcool extends Bebidas{
    private int Valor_Energetico;
    private String Tipo;

public SemAlcool (){
    super();
    Valor_Energetico=0;
    Tipo=null;
} 

public SemAlcool (String Nome, Double Preco, String Marca, String Sabor, String Composicao, int Valor_Energetico, String Tipo) {
    super(Nome,Preco,Marca,Sabor,Composicao);   //Puxa os atributos da classe principal
    this.Valor_Energetico=Valor_Energetico;
    this.Tipo=Tipo;
}

public int getValor_Energetico(){
    return Valor_Energetico;
}

public String getTipo(){
    return Tipo;
}

public void  setValor_Energetico(int V) {
    Valor_Energetico=V;
}

public void setTipo(String T){
    Tipo=T;
}

public void mostrar_dados(){  //Esse método vai ser usado para criar um objeto na Herenca.java
            System.out.println("Nome: " + getNome());
            System.out.println("Preço: R$" + getPreco());
            System.out.println("Marca: " + getMarca()); 
            System.out.println("Sabor: " + getSabor());
            System.out.println("Composição: " + getComposicao());
            System.out.println("Idade Mínima: " + getValor_Energetico());
            System.out.println("Malefícios: " + getTipo());
    }
}
