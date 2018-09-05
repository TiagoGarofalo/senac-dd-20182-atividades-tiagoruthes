package aula06.exercicio04.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void setValoresAtributosUpdate(FuncionarioVO entidade, PreparedStatement preparedStmt){
		//Preenche cada interrogação da cláusula SET
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
		
		FuncionarioVO novoFuncionario = null; //retorna null caso o resultado esteja vazio
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

	public FuncionarioVO obterPorId(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean atualizar(FuncionarioVO funcionarioVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
