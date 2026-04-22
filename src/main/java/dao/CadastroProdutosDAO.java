/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 232.004836
 */
import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.CadastroProdutoModel;

public class CadastroProdutosDAO {

    public boolean salvar(CadastroProdutoModel produto) {
        String sql = "INSERT INTO products"
                + "(codigo_barras, nome_produto, fabricante, marca, data_fabricacao, data_vencimento, quantidade, valor, total)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = connection.ConnectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getCodigoBarras());
            stmt.setString(2, produto.getNomeProduto());
            stmt.setString(3, produto.getFabricante());
            stmt.setString(4, produto.getMarca());
            stmt.setDate(5, java.sql.Date.valueOf(produto.getDataFabricacao()));
            stmt.setDate(6, java.sql.Date.valueOf(produto.getDataVencimento()));
            stmt.setLong(7, produto.getQuantidade());
            stmt.setString(8, produto.getValor());
            stmt.setString(9, produto.getTotal());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<CadastroProdutoModel> listar() {
        List<CadastroProdutoModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CadastroProdutoModel p = new CadastroProdutoModel();

                p.setCodigoBarras(rs.getString("codigoBarras"));
                p.setNomeProduto(rs.getString("nomeProduto"));
                p.setFabricante(rs.getString("fabricante"));
                p.setMarca(rs.getString("marca"));
                p.setFabricante(rs.getString("fabricante"));
                p.setMarca(rs.getString("marca"));
                p.setQuantidade(rs.getLong("quantidade"));
                p.setTotal(rs.getString("valor"));
                p.setStatus(rs.getString("status"));

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}   
