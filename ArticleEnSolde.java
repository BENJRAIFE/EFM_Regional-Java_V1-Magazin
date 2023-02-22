package EFMS;

public class ArticleEnSolde extends Article{

	private int remise;

	public  ArticleEnSolde(int code, double prixOrigine,int remise)throws Exception {
		super(code, prixOrigine);
		if (remise<=0 || remise>90) {
			throw new Exception("remise invalide");
		}else {
			this.remise=remise;
		}
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) throws Exception {
		if (remise<=0 || remise>90) {
			throw new Exception("remise invalide");
		}else {
			this.remise=remise;
		}
	}
	@Override
	public String toString() {
		return super.toString()+"; remise= "+getRemise();
	}
	@Override
	public double prixProduit() {
		return super.prixProduit()-getRemise();
	}

	

}
