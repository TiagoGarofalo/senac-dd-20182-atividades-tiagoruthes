package aula05.vo;

public class PessoaVO {

	private String nome;
	private int idade;
	private int cpf;
	
	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PessoaVO(String nome, int idade, int cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
}
