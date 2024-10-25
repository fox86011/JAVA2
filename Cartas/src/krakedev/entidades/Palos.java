package krakedev.entidades;

public class Palos {
    // Atributos privados para los palos
    private String corazonRojo = "CR";
    private String corazonNegro = "CN";
    private String diamante = "DI";
    private String trebol = "TR";

    // Constructor vacío
    public Palos() {}

    // Getters
    public String getCorazonRojo() {
        return corazonRojo;
    }
    // ... otros getters para los demás palos ...

	public String getCorazonNegro() {
		return corazonNegro;
	}

	public void setCorazonNegro(String corazonNegro) {
		this.corazonNegro = corazonNegro;
	}

	public String getDiamante() {
		return diamante;
	}

	public void setDiamante(String diamante) {
		this.diamante = diamante;
	}

	public String getTrebol() {
		return trebol;
	}

	public void setTrebol(String trebol) {
		this.trebol = trebol;
	}

	public void setCorazonRojo(String corazonRojo) {
		this.corazonRojo = corazonRojo;
	}
}



