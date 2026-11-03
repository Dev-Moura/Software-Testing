package com.softwareTesting.java.testeDeIntegracao.interfaceExterna;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioDePessoasJdbc implements RepositorioDePessoas {

    private final Connection conexao;

    public RepositorioDePessoasJdbc(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void salvar(Pessoa pessoa) {

        String sql = "INSERT INTO pessoas (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();

            ResultSet chaves = stmt.getGeneratedKeys();
            if (chaves.next()) {
                pessoa.setId(chaves.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar pessoa", e);
        }
    }

    @Override
    public Pessoa buscarPorId(int id) {

        String sql = "SELECT id, nome, email FROM pessoas WHERE id = ?";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pessoa por ID", e);
        }
    }

    @Override
    public List<Pessoa> listarTodas() {
        String sql = "SELECT id, nome, email FROM pessoas";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            List<Pessoa> pessoas = new ArrayList<>();
            while (rs.next()) {
                pessoas.add(new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                ));
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Listar pessoas", e);
        }
    }

    @Override
    public void removerTodas() {
        try (PreparedStatement stmt = conexao.prepareStatement("DELETE FROM pessoas")){
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover pessoas", e);
        }
    }


}
