
package Model;

/**
 *
 * @author IARA
 */

import Control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Movimento {
    private int CodMovi;
    private String CodProduto;
    private String Operacao;
    private int Qtde;
    private String Data;

    public Movimento() {
    }

    public Movimento(int CodMovi, String CodProduto, String Operacao, int Qtde, String Data) {
        this.CodMovi = CodMovi;
        this.CodProduto = CodProduto;
        this.Operacao = Operacao;
        this.Qtde = Qtde;
        this.Data = Data;
    }

    public int getCodMovi() {
        return CodMovi;
    }

    public String getCodProduto() {
        return CodProduto;
    }

    public String getOperacao() {
        return Operacao;
    }

    public int getQtde() {
        return Qtde;
    }

    public String getData() {
        return Data;
    }

    public void setCodMovi(int CodMovi) {
        this.CodMovi = CodMovi;
    }

    public void setCodProduto(String CodProduto) {
        this.CodProduto = CodProduto;
    }

    public void setOperacao(String Operacao) {
        this.Operacao = Operacao;
    }

    public void setQtde(int Qtde) {
        this.Qtde = Qtde;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    
    public boolean incluir() throws SQLException {
        String sql = "Insert into Movimento(CodProduto,Operacao,Qtde,Data) values(?,?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getCodProduto());
        st.setString(2, getOperacao());
        st.setInt(3, getQtde());
        st.setString(4, getData());
        r = st.executeUpdate();
        return r == 1;
    }
    
    public boolean excluir() throws SQLException{
        String sql = "DELETE FROM Movimento WHERE CodMovi=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodMovi());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public ResultSet Listar() {
    Statement st = null;
    ResultSet rs = null;
    String sql = "select * from Movimento";
        try {
            st = new Banco ().getCon().createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
    }
    
    public ResultSet pesquisar(String CodProduto){
       PreparedStatement st;
       ResultSet rs = null; 
       
       String sql = "select * from Movimento WHERE CodProduto=" + CodProduto;
        try {
            st = new Banco ().getCon().prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Movimento.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
       return rs;
    }
    
    public ResultSet pesquisarPorData(String DataInicial, String DataFinal) throws Exception{
       PreparedStatement st;
       ResultSet rs = null; 
       
       String sql = "SELECT m.*, p.Descricao FROM " +
"	movimento m " +
"	INNER JOIN produto p ON m.CodProduto=p.CodProduto " +
"	WHERE " +
"	m.Data BETWEEN ? AND ?";
        try {
            st = new Banco ().getCon().prepareStatement(sql);
            st.setString(1, DataInicial);
            st.setString(2, DataFinal);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Movimento.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
       return rs;
    }
    
    public ResultSet pesquisarPorDataEProduto(String CodProduto, String DataInicial, String DataFinal) throws Exception{
       PreparedStatement st;
       ResultSet rs = null; 
       
       String sql = "SELECT m.*, p.Descricao FROM " +
"	movimento m " +
"	INNER JOIN produto p ON m.CodProduto=p.CodProduto " +
"	WHERE m.CodProduto=? AND "+
"	m.Data BETWEEN ? AND ?";
        try {
            st = new Banco ().getCon().prepareStatement(sql);
            st.setString(1, CodProduto);
            st.setString(2, DataInicial);
            st.setString(3, DataFinal);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Movimento.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
       return rs;
    }
    
}
