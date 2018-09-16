package aula06.exercicio04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import dao.BaseDAO;
import aula06.exercicio04.VO.FuncionarioVO;

public class FuncionarioDAO extends BaseDAO<FuncionarioVO> {

	@Override
	public String getNomeTabela() {
		return "FUNCIONARIO";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "ID";
	}

	@Override
	public String getNomesColunasInsert() {
		return "NOME,MATRICULA,CPF";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?,?,?";
	}

	@Override
	public void setValoresAtributosInsert(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getNumeroMatricula());
			preparedStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValoresClausulaSetUpdate(FuncionarioVO entidade) {
		// SET NOME=func.getNome(), MATRICULA=func.getNumeroMatricula()...
		String clausulaSet = " NOME = ?, MATRICULA = ?, CPF = ?";

		return clausulaSet;
	}

	@Override
	public void setValoresAtributosUpdate(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		// Preenche cada interrogação da cláusula SET
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getNumeroMatricula());
			preparedStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FuncionarioVO construirObjetoDoResultSet(ResultSet resultado) {

		FuncionarioVO novoFuncionario = null; // retorna null caso o resultado esteja vazio
		try {
			novoFuncionario = new FuncionarioVO();
			novoFuncionario.setIdFuncionario(resultado.getInt("ID"));
			novoFuncionario.setNome(resultado.getString("NOME"));
			novoFuncionario.setNumeroMatricula(resultado.getString("MATRICULA"));
			novoFuncionario.setCpf(resultado.getString("CPF"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return novoFuncionario;
	}

	public boolean atualizar(FuncionarioVO f) {
		boolean sucessoUpdate = false;

		String sql = "  UPDATE FUNCIONARIO F SET, NOME=?, MATRICULA=?, CPF=?  "
				+ "  WHERE F.ID = ?  ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			
			prepStmt.setString(1, f.getNome());
			prepStmt.setString(2, f.getNumeroMatricula());
			prepStmt.setString(3, f.getCpf());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar produto");
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;

	}
	
	public boolean excluir(int cpf){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM FUNCIONARIO "
				+ " WHERE CPF = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setInt(1, cpf);

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){//1 - sucesso na execução
				sucessoDelete = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao remover funcionário. CPF = " + cpf);
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}

	public ArrayList<FuncionarioVO> listarTodos() {
		String sql = " SELECT * FROM FUNCIONARIO ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				FuncionarioVO f = new FuncionarioVO();

				// Obtendo valores pelo NOME DA COLUNA
				f.setIdFuncionario(result.getInt("ID"));
				f.setNome(result.getString("NOME"));
				f.setNumeroMatricula(result.getString("MATRICULA"));
				f.setCpf(result.getString("CPF"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

}
