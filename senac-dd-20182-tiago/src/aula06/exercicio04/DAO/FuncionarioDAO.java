package aula06.exercicio04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public boolean temCPFCadastrado(String cpf) {
		String sql = "SELECT COUNT(*) FROM FUNCIONARIO WHERE CPF = ?";
		boolean temFuncionarioComEsseCPF = false;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		try{
			stmt.setString(1, cpf);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				int quantidadeRegistros = resultado.getInt(1);
				temFuncionarioComEsseCPF = (quantidadeRegistros > 0);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar o CPF = " + cpf);
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return temFuncionarioComEsseCPF;
	}

	public boolean atualizar(FuncionarioVO funcionarioVO) {

		boolean sucessoUpdate = false;

		String sql = "UPDATE funcionario SET NOME=?, MATRICULA=?, CPF = ?" + " WHERE CPF = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		
		try {
			
						
			prepStmt.setString(1,  funcionarioVO.getNome());
			prepStmt.setString(2,  funcionarioVO.getNumeroMatricula());
			prepStmt.setString(3,  funcionarioVO.getCpf());
			prepStmt.setString(4,  funcionarioVO.getCpf());
			int codigoRetorno = prepStmt.executeUpdate();
			

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}
			

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar funcionario");
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
	
		return sucessoUpdate;
}
	/*public boolean atualizar(FuncionarioVO f) {
		boolean sucessoUpdate = false;

		String sql = "  UPDATE FUNCIONARIO SET, NOME=?, MATRICULA=?  "
				+ "  WHERE CPF = ?  ";

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
			JOptionPane.showMessageDialog(null,"Erro ao atualizar funcionario");
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;

	}*/
	
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

	public FuncionarioVO pesquisarPorCPF(int cpf){
		String sql = " SELECT * FROM FUNCIONARIO WHERE CPF= ? " ;
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		FuncionarioVO f = null;
		
		try {
			prepStmt.setInt(1, cpf);
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				f = new FuncionarioVO();
				
				//Obtendo valores pelo NOME DA COLUNA
				f.setNome(result.getString("NOME"));
				f.setNumeroMatricula(result.getString("MATRICULA"));
				f.setCpf(result.getString("CPF"));
				
				//JOptionPane.showMessageDialog(null, "Funcionario Pesquisado: " + f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao consultar funcionário. CPF = " + cpf);
		}
		return  f;
	}
	
	
	/*public ArrayList<FuncionarioVO> listarTodos() {
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
	}*/

}
