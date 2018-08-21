package aula05.vo;

public class GarrafaAguaVO {

	private double litros;
	private double peso;
	private boolean retornavel;
	private String gas;
	
	public GarrafaAguaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GarrafaAguaVO(double litros, double peso, boolean retornavel, String gas) {
		super();
		this.litros = litros;
		this.peso = peso;
		this.retornavel = retornavel;
		this.gas = gas;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public boolean isRetornavel() {
		return retornavel;
	}
	public void setRetornavel(boolean retornavel) {
		this.retornavel = retornavel;
	}
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
	}
	
	
}
