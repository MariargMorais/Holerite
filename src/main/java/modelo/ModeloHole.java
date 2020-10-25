package modelo;

public class ModeloHole {

	// vari�veis e m�todos getters e setters
	private int id;
	private String nome;
	private float INSS;
	private float salario;
	private String depto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
		this.INSS = (salario/100)*9;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getINSS() {
		return INSS;
	}}

