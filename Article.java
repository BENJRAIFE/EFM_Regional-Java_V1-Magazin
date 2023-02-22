package EFMS;


public class Article {
	private int code;
	private double prixOrigine;


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getPrixOrigine() {
		return prixOrigine;
	}

	public void setPrixOrigine(double prixOrigine) {
		this.prixOrigine = prixOrigine;
	}
	public Article(int code, double prixOrigine) {
		this.code = code;
		this.prixOrigine = prixOrigine;
	}
	
	@Override
	public String toString() {
		return "code=" + code + "; prixOrigine=" + prixOrigine ;
	}
	
	public boolean equals(Article obj) {
		Article art=(Article) obj;
		if (art.code==this.code) {
			return true;
		}else {
			return false;
		}
	}
	
	public double prixProduit() {
		return getPrixOrigine();
	}

	

}
