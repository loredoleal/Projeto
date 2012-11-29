import java.util.Date;


public class Equipamento {
	
	private int os;
	private String descricao;
	private String acessorios;
	private String defeitoreclamado;
	private Date data_in;
	private Date data_out;
	private String tecnico;
	private boolean autorizado;
	private boolean pronto;
	private String defeitoencontrado;
	private int fkcliente;
	private float valor;
	private boolean naloja;
	
	public Equipamento(int os, String descricao, String acessorios,
			String defeitoreclamado, Date data_in, Date data_out,
			String tecnico, boolean autorizado, boolean pronto,
			String defeitoencontrado, int fkcliente, float valor, boolean naloja) {
		super();
		this.os = os;
		this.descricao = descricao;
		this.acessorios = acessorios;
		this.defeitoreclamado = defeitoreclamado;
		this.data_in = data_in;
		this.data_out = data_out;
		this.tecnico = tecnico;
		this.autorizado = autorizado;
		this.pronto = pronto;
		this.defeitoencontrado = defeitoencontrado;
		this.fkcliente = fkcliente;
		this.valor = valor;
		this.naloja = naloja;
	}

	public int getOs() {
		return os;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public String getDefeitoreclamado() {
		return defeitoreclamado;
	}

	public Date getData_in() {
		return data_in;
	}

	public Date getData_out() {
		return data_out;
	}

	public String getTecnico() {
		return tecnico;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public boolean isPronto() {
		return pronto;
	}

	public String getDefeitoencontrado() {
		return defeitoencontrado;
	}

	public int getFkcliente() {
		return fkcliente;
	}

	public float getValor() {
		return valor;
	}

	public boolean isNaloja() {
		return naloja;
	}
	
}
