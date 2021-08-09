
package Model;

import control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int CodUsuario;
    private String Nome;
    private String Senha;

    public Usuario() {
    }

    public Usuario(int CodUsuario, String Nome, String Senha) {
        this.CodUsuario = CodUsuario;
        this.Nome = Nome;
        this.Senha = Senha;
    }

    public int getCodUsuario() {
        return CodUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    public boolean inclusao() throws SQLException {
        String sql = "Insert into Usuario(CodUsuario,Nome,Senha) values(?,?,?)";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodUsuario());
        st.setString(2, getNome());
        st.setString(3, getSenha());
        r = st.executeUpdate();
        return r == 1;
    }
    
    public boolean alteracao() throws SQLException{
        String sql = "Update Usuario SET Nome=?,Senha=? WHERE CodUsuario=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getNome());
        st.setString(2, getSenha());
        st.setInt(3,getCodUsuario());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public boolean exclusao() throws SQLException{
        String sql = "DELETE FROM Usuario WHERE Nome=?";
        PreparedStatement st;
        int r = 0;
        
        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getNome());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
    
    public ResultSet consultar() {
    Statement st = null;
    ResultSet rs = null;
    String sql = "select * from usuario";
    try {
        st = new Banco ().getCon().createStatement();
        rs = st.executeQuery(sql);
    } catch (SQLException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
}
