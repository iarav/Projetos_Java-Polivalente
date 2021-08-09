
package Model;

import control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private int CodCliente;
    private String Nome;
    private String Endereco;
    private String CPF;
    private String RG;
    private String Telefone;
    private String Email;
    private String Sexo;

    public Cliente() {
    }

    public Cliente(int CodCliente, String Nome, String Endereco, String CPF, String RG, String Telefone, String Email, String Sexo) {
        this.CodCliente = CodCliente;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.CPF = CPF;
        this.RG = RG;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Sexo = Sexo;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public String getNome() {
        return Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    public boolean inclusao() throws SQLException {
        String sql = "Insert into Cliente(CodCliente,Nome,Endereco,CPF,RG,Telefone,Email,Sexo) values(?,?,?,?,?,?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodCliente());
        st.setString(2, getNome());
        st.setString(3, getEndereco());
        st.setString(4, getCPF());
        st.setString(5, getRG());
        st.setString(6, getTelefone());
        st.setString(7, getEmail());
        st.setString(8, getSexo());
        r = st.executeUpdate();
        return r == 1;
    }
    
    public boolean alteracao() throws SQLException{
        String sql = "Update Cliente SET Nome=?,Endereco=?,CPF=?,RG=?,Telefone=?,Email=?,Sexo=? WHERE CodCliente=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getNome());
        st.setString(2, getEndereco());
        st.setString(3, getCPF());
        st.setString(4, getRG());
        st.setString(5, getTelefone());
        st.setString(6, getEmail());
        st.setString(7, getSexo());
        st.setInt(8, getCodCliente());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean exclusao() throws SQLException{
        String sql = "DELETE FROM Cliente WHERE CodCliente=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodCliente());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public ResultSet consultar() {
    Statement st = null;
    ResultSet rs = null;
    String sql = "select * from cliente";
    try {
        st = new Banco ().getCon().createStatement();
        rs = st.executeQuery(sql);
    } catch (SQLException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
}
