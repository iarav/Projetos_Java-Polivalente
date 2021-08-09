
package Model;

import Control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {
    private String CodProduto;
    private String Descricao;
    private float PrecoVenda;

    public Produto() {
    }
    
    public Produto(String CodProduto, String Descricao, float PrecoVenda) {
        this.CodProduto = CodProduto;
        this.Descricao = Descricao;
        this.PrecoVenda = PrecoVenda;
    }

    public String getCodProduto() {
        return CodProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public float getPrecoVenda() {
        return PrecoVenda;
    }

    public void setCodProduto(String CodProduto) {
        this.CodProduto = CodProduto;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setPrecoVenda(float PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }
    
    
    public boolean incluir() throws SQLException {
        String sql = "Insert into Produto(CodProduto,Descricao,PrecoVenda) values(?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getCodProduto());
        st.setString(2, getDescricao());
        st.setFloat(3, getPrecoVenda());
        r = st.executeUpdate();
        return r == 1;
    }
    
    public boolean alterar() throws SQLException{
        String sql = "Update Produto SET Descricao=?,PrecoVenda=? WHERE CodProduto=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getDescricao());
        st.setFloat(2, getPrecoVenda());
        st.setString(3, getCodProduto());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean excluir() throws SQLException{
        String sql = "DELETE FROM Produto WHERE CodProduto=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getCodProduto());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public ResultSet pesquisar(String CodProduto){
       PreparedStatement st;
       ResultSet rs = null; 
       
       String sql = "select * from Produto WHERE CodProduto=" + CodProduto;
        try {
            st = new Banco ().getCon().prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rs;
    }
    
}
