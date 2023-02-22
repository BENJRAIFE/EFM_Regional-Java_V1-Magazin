package EFMS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;


public class Magazin {

	private ArrayList<Article> articles=new ArrayList<>();
	public Magazin() {
		
	}
	public int indiceDe(int code) {
		int indice=0;
			for(Article arts:articles) {
				if (arts.getCode()==code) {
					indice=articles.indexOf(arts);
				}else {
					indice=-1;
				}
			}
			return indice;
		}
		public void ajouter(Article arts) throws Exception {
			if (articles.contains(arts)) {
				throw new Exception("l'article déja existe");
			}else {
				articles.add(arts);
			}
		}
		public boolean supprimer(int code)throws Exception {
			boolean etat = false;
			for(Article arts:articles) {
				if (arts.getCode()==code) {
					articles.remove(arts);
					etat= true;
				}else {
					throw new Exception("l'article n'existe pas");
				}
			}
			return etat;
			
		}
		public boolean supprimer(Article art)throws Exception {
			boolean etat = false;
			if (articles.contains(art)) {
				articles.remove(art);
				etat= true;
			}else {
				throw new Exception("l'article n'existe pas");
			}
			return etat;
		}
		public int nombreArticlesEnSolde() {
			int nmbr=0;
			for(Article arts:articles) {
				if (arts instanceof ArticleEnSolde) {
					nmbr=nmbr+1;
				}
			}
			return nmbr;
		}
		public void enregistrer(String chemin) throws IOException {
			File file=new File(chemin);
			FileOutputStream outputStreamWriter=new FileOutputStream(file);
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStreamWriter);
			objectOutputStream.writeObject(articles);
			objectOutputStream.close();
			outputStreamWriter.close();
		}
public static void main(String[] args) throws Exception {
	Magazin magazin=new Magazin();
	magazin.ajouter(new Article(2,400.0));
	magazin.ajouter(new Article(3,500.0));
	magazin.ajouter(new ArticleEnSolde(1, 200.0, 3));
	System.out.println(magazin.articles.size());
	magazin.supprimer(new ArticleEnSolde(1, 200.0, 3));
	System.out.println(magazin.articles.size());
	
	

	
}
}

