
public class Cliente {
	
	private int cod;
	private String nome;
	private String end;
	private String fone_1;
	private String fone_2;
	private String obs;
	
	public Cliente(int cod, String nome, String end, String fone_1,
			String fone_2, String obs) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.end = end;
		this.fone_1 = fone_1;
		this.fone_2 = fone_2;
		this.obs = obs;
	}
	
	public int getCod() {
		return cod;
	}
	public String getNome() {
		return nome;
	}
	public String getEnd() {
		return end;
	}
	public String getFone_1() {
		return fone_1;
	}
	public String getFone_2() {
		return fone_2;
	}
	public String getObs() {
		return obs;
	}
	
	
}
