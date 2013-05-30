package cat.jordihernandez.aclimb;

public class item_escoles {
	int id;
	String NomEscola, Comentaris;
		
	public item_escoles() {
		// TODO Auto-generated constructor stub
		NomEscola = "";
		Comentaris = "";
	}

	public item_escoles(String nom) {
		NomEscola=nom;
		Comentaris="";
	}
	
	public item_escoles(String nom, String comentari) {
		NomEscola=nom;
		Comentaris=comentari;
	}
	
	public void setId(int idEscola) {
		id=idEscola;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNomEscola(String nom) {
		NomEscola=nom;
	}
	
	public String getNomEscola() {
		return NomEscola;
	}
	
	
	public void setComentari(String comentari) {
		Comentaris = comentari;
	}
	public String getComentari() {
		return Comentaris;
	}
	
}
