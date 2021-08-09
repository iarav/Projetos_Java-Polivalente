/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ISVaneti-InfI181
 */
public class Estado {

    private int CodEstado;
    private String Estado;

    public Estado() {
    }

    public Estado(int CodEstado, String Estado) {
        this.CodEstado = CodEstado;
        this.Estado = Estado;
    }

    public int getCodEstado() {
        return CodEstado;
    }

    public void setCodEstado(int CodEstado) {
        this.CodEstado = CodEstado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ResultSet getRS() {                            //Criando um método para pegar um ResultSet chamado getRS
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * from Estado";

        try {
            st = new Banco().getCon().createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public boolean novo() throws SQLException {
        String sql = "Insert into Estado(nome) values(?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getEstado());
        r = st.executeUpdate();
        return r == 1;

    }
    
    public boolean alterar() throws SQLException{
        String sql = "Update Estado SET Nome=? WHERE CodEstado=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getEstado());
        st.setInt(2, getCodEstado());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean excluir() throws SQLException{
        String sql = "DELETE FROM Estado WHERE CodEstado=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodEstado());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
     public ResultSet Listar() {
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from Estado";
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
   
    public List<Estado> getLista() throws SQLException{
        Statement st = null;
        ResultSet rs = null;
        List<Estado> lista = new ArrayList();
        String sql = "select * from Estado";
        try{
        st = new Banco ().getCon().createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            Estado e = new Estado();
            e.setCodEstado(rs.getInt("CodEstado"));
            e.setEstado(rs.getString("Nome"));
            lista.add(e); 
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
        return getEstado();
     } 
     
}
