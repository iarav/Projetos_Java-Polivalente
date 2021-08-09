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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISVaneti-InfI181
 */
public class Pessoa {
    private int CodPessoa;
    private String Nome;
    private String Fone;
    private int CodCidade; 
    private int CodEstado; 
    
    public Pessoa() {
    }

    public Pessoa(int CodPessoa, String Nome, String Fone, int CodCidade,int CodEstado) {
        this.CodPessoa = CodPessoa;
        this.Nome = Nome;
        this.Fone = Fone;
        this.CodCidade = CodCidade;
        this.CodEstado = CodEstado;
    }

    public int getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(int CodPessoa) {
        this.CodPessoa = CodPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    public int getCodCidade() {
        return CodCidade;
    }

    public void setCodCidade(int CodCidade) {
        this.CodCidade = CodCidade;
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
        String sql = "SELECT * from Pessoa";
        try {
            st = new Banco().getCon().createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean novo() throws SQLException {
        String sql = "Insert into Pessoa(Nome,Fone,CodCidade,CodEstado) values(?,?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getNome());
        st.setString(2, getFone());
        st.setInt(3,getCodCidade());
        st.setInt(4, getCodEstado());
        r = st.executeUpdate();
        return r == 1;

    }
    
    public boolean alterar() throws SQLException{
        String sql = "Update Pessoa SET Nome=?,fone=?,CodCidade=?,CodEstado=? WHERE CodPessoa=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getNome());
        st.setString(2, getFone());
        st.setInt(3, getCodCidade());
        st.setInt(4, getCodEstado());
        st.setInt(5, getCodPessoa());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean excluir() throws SQLException{
        String sql = "DELETE FROM Pessoa WHERE CodPessoa=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodPessoa());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
     public ResultSet Listar() {
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from Pessoa";
        try {
            st = new Banco ().getCon().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
    
    

