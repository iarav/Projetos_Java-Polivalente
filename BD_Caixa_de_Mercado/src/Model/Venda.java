
package Model;

import Control.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Venda {

    private int CodVenda;
    private String Data;
    private float ValorTotal;

    public Venda() {
    }

    public Venda(int CodVenda, String Data, float ValorTotal) {
        this.CodVenda = CodVenda;
        this.Data = Data;
        this.ValorTotal = ValorTotal;
    }

    public int getCodVenda() {
        return CodVenda;
    }

    public String getData() {
        return Data;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setCodVenda(int CodVenda) {
        this.CodVenda = CodVenda;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public int incluir() {
        String sql = "Insert into Venda(Data,ValorTotal) values(?,?)";
        PreparedStatement st;
        int r = 0;
        int codVenda = 0;

        try {
            st = new Banco().getCon().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, getData());
            st.setFloat(2, getValorTotal());
            r = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                codVenda = rs.getInt(1);
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codVenda;
    }

    public boolean alterar() throws SQLException {
        String sql = "Update Venda SET Data=?,ValorTotal=? WHERE CodVenda=?";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setString(1, getData());
        st.setFloat(2, getValorTotal());
        st.setInt(3, getCodVenda());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }

    public boolean excluir() throws SQLException {
        String sql = "DELETE FROM Venda WHERE CodVenda=?";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodVenda());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
}
