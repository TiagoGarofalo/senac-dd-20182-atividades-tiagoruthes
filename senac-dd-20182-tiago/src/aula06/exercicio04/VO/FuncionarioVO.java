package aula06.exercicio04.VO;

public class FuncionarioVO {

	private int idFuncionario;
	private String nome;
	private String numeroMatricula;
	private String cpf;
	
	public FuncionarioVO() {
		super();
	
	}

	public FuncionarioVO(int idFuncionario, String nome, String numeroMatricula, String cpf) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
		this.cpf = cpf;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
