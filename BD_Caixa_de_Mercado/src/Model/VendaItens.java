
package Model;

import Control.Banco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaItens {

    private int CodVendaItem;
    private int CodVenda;
    private String CodProduto;
    private int Quantidade;
    private float ValorUnitario;

    public VendaItens() {
    }

    public VendaItens(int CodVendaItem, int CodVenda, String CodProduto, int Quantidade, float ValorUnitario) {
        this.CodVendaItem = CodVendaItem;
        this.CodVenda = CodVenda;
        this.CodProduto = CodProduto;
        this.Quantidade = Quantidade;
        this.ValorUnitario = ValorUnitario;
    }

    public int getCodVendaItem() {
        return CodVendaItem;
    }

    public int getCodVenda() {
        return CodVenda;
    }

    public String getCodProduto() {
        return CodProduto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public float getValorUnitario() {
        return ValorUnitario;
    }

    public void setCodVendaItem(int CodVendaItem) {
        this.CodVendaItem = CodVendaItem;
    }

    public void setCodVenda(int CodVenda) {
        this.CodVenda = CodVenda;
    }

    public void setCodProduto(String CodProduto) {
        this.CodProduto = CodProduto;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public void setValorUnitario(float ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public boolean incluir() {
        String sql = "Insert into VendaItens(CodVenda,CodProduto,Quantidade,ValorUnitario) values(?,?,?,?)";
        PreparedStatement st;
        int r = 0;

        try {
            st = new Banco().getCon().prepareStatement(sql);
            st.setInt(1, getCodVenda());
            st.setString(2, getCodProduto());
            st.setInt(3, getQuantidade());
            st.setFloat(4, getValorUnitario());
            r = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r == 1;
    }

    public boolean alterar() throws SQLException {
        String sql = "Update VendaItens SET CodVenda=?,CodProduto=?,Quantidade=?,ValorUnitario=? WHERE CodVendaItem=?";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodVenda());
        st.setString(2, getCodProduto());
        st.setInt(3, getQuantidade());
        st.setFloat(4, getValorUnitario());
        st.setInt(5, getCodVendaItem());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }

    public boolean excluir() throws SQLException {
        String sql = "DELETE FROM VendaItens WHERE CodVendaItem=?";
        PreparedStatement st;
        int r = 0;

        st = new Banco().getCon().prepareStatement(sql);
        st.setInt(1, getCodVendaItem());
        r = st.executeUpdate();
        st.close();
        return r == 1;
    }
}
