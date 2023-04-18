package it.prova.gestionetv.model;

public class Televisore {

	private Long idTelevisore;
	private String marca;
	private String modello;
	private Double prezzo;
	private Integer numeroPollici;
	private String codice;

	public Televisore() {
		super();
	}

	public Televisore(String marca, String modello, Double prezzo, Integer numeroPollici, String codice) {
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.numeroPollici = numeroPollici;
		this.codice = codice;
	}

	public Televisore(Long idTelevisore, String marca, String modello, Double prezzo, Integer numeroPollici,
			String codice) {
		this.idTelevisore = idTelevisore;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.numeroPollici = numeroPollici;
		this.codice = codice;
	}

	public Long getIdTelevisore() {
		return idTelevisore;
	}

	public void setIdTelevisore(Long idTelevisore) {
		this.idTelevisore = idTelevisore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getNumeroPollici() {
		return numeroPollici;
	}

	public void setNumeroPollici(Integer numeroPollici) {
		this.numeroPollici = numeroPollici;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
