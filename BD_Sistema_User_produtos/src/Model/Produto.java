
package Model;

import control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {
    private int CodProduto;
    private String Descricao;
    private String Unidade;
    private int Saldo;
    private double VrCompra;
    private double VrVenda;

    public Produto() {
    }

    public Produto(int CodProduto, String Descricao, String Unidade, int Saldo, double VrCompra, double VrVenda) {
        this.CodProduto = CodProduto;
        this.Descricao = Descricao;
        this.Unidade = Unidade;
        this.Saldo = Saldo;
        this.VrCompra = VrCompra;
        this.VrVenda = VrVenda;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getUnidade() {
        return Unidade;
    }

    public int getSaldo() {
        return Saldo;
    }

    public double getVrCompra() {
        return VrCompra;
    }

    public double getVrVenda() {
        return VrVenda;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public void setVrCompra(double VrCompra) {
        this.VrCompra = VrCompra;
    }

    public void setVrVenda(double VrVenda) {
        this.VrVenda = VrVenda;
    }
    
    public boolean inclusao() throws SQLException {
        String sql = "Insert into Produto(CodProduto,Descricao,Unidade,Saldo,VrCompra,VrVenda) values(?,?,?,?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodProduto());
        st.setString(2, getDescricao());
        st.setString(3, getUnidade());
        st.setInt(4, getSaldo());
        st.setDouble(5, getVrCompra());
        st.setDouble(6, getVrVenda());
        r = st.executeUpdate();
        return r == 1;
    }
    
    public boolean alteracao() throws SQLException{
        String sql = "Update produto SET Descricao=?,Unidade=?,Saldo=?,VrCompra=?,VrVenda=? WHERE CodProduto=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getDescricao());
        st.setString(2, getUnidade());
        st.setInt(3, getSaldo());
        st.setDouble(4, getVrCompra());
        st.setDouble(5, getVrVenda());
        st.setInt(6, getCodProduto());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean exclusao() throws SQLException{
        String sql = "DELETE FROM Produto WHERE CodProduto=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodProduto());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public ResultSet consultar() {
    Statement st = null;
    ResultSet rs = null;
    String sql = "select * from produto";
        try {
            st = new Banco ().getCon().createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
    }
}
