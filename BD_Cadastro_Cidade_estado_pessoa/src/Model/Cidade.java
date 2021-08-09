
package Model;

import Control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cidade {
    private int CodCidade;
    private String Cidade;
    private int CodEstado;

    public Cidade() {
    }

    public Cidade(int CodCidade, String Cidade, int CodEstado) {
        this.CodCidade = CodCidade;
        this.Cidade = Cidade;
        this.CodEstado = CodEstado;
    }

    public int getCodCidade() {
        return CodCidade;
    }

    public void setCodCidade(int CodCidade) {
        this.CodCidade = CodCidade;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public int getCodEstado() {
        return CodEstado;
    }

    public void setCodEstado(int CodEstado) {
        this.CodEstado = CodEstado;
    }
    
    
    public ResultSet getRS() {                            //Criando um método para pegar um ResultSet chamado getRS
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * from Cidade";

        try {
            st = new Banco().getCon().createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Cidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

      public boolean novo() throws SQLException {
        String sql = "Insert into Cidade(Nome,CodEstado) values(?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getCidade());
        st.setInt(2, getCodEstado());
        r = st.executeUpdate();
        return r == 1;

    }
    
    public boolean alterar() throws SQLException{
        String sql = "Update Cidade SET Nome=?,CodEstado=? WHERE CodCidade=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getCidade());
        st.setInt(2, getCodEstado());
        st.setInt(3, getCodCidade());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean excluir() throws SQLException{
        String sql = "DELETE FROM Cidade WHERE CodCidade=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodCidade());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
     public ResultSet Listar() {
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from Cidade";
        try {
            st = new Banco ().getCon().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     
     public List<Cidade> getLista() throws SQLException{
        Statement st = null;
        ResultSet rs = null;
        List<Cidade> lista = new ArrayList();
        String sql = "select * from Cidade";
        try{
        st = new Banco ().getCon().createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            Cidade c = new Cidade();
            c.setCodCidade(rs.getInt("CodCidade"));
            c.setCidade(rs.getString("Nome"));
            c.setCodEstado(rs.getInt("CodEstado"));
            lista.add(c); 
        }
        } catch (SQLException ex) {
            Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            rs.close();
            st.close();
        }
        return lista;
     }
    
     public String toString(){
        return getCidade();
     }
}
    
     
    
    

