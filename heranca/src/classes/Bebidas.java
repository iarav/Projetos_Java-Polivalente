package classes;
 
 // @autores Madu e Diego
 
public class Bebidas {
    private String Nome;
    private double Preco;
    private String Marca;
    private String Sabor;
    private String Composicao; 
    
public Bebidas() {
    Nome=null;
    Preco=0;
    Marca=null;
    Sabor=null;
    Composicao=null;
}

public Bebidas (String Nome, Double Preco, String Marca, String Sabor, String Composicao) {
    this.Nome=Nome;
    this.Preco=Preco;
    this.Marca=Marca;
    this.Sabor=Sabor;
    this.Composicao=Composicao;
}

public String getNome(){
    return Nome;
}

public double getPreco() {
    return Preco;
}

public String getMarca(){
    return Marca;
}

public String getSabor(){
    return Sabor;
}

public String getComposicao(){
    return Composicao;
}

public void setNome(String N){
    Nome=N;
}

public void setPreco(double P){
    Preco=P;
}

public void setMarca(String M1){
    Marca=M1;
}

public void setSabor(String S){
    Sabor=S;
}

public void setComposicao(String C){
    Composicao=C;
}

}
