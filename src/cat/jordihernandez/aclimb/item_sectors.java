package cat.jordihernandez.aclimb;

public class item_sectors {
	int idsector, idescola;
	String NomSector, Comentaris;
		
	public item_sectors() {
		// TODO Auto-generated constructor stub
		NomSector = "";
		Comentaris = "";
	}

	public item_sectors(String nom) {
		NomSector=nom;
		Comentaris="";
	}
	
	public item_sectors(String nom, String comentari) {
		NomSector=nom;
		Comentaris=comentari;
	}
	
	public void setId(int ids) {
		idsector=ids;
	}
	
	public int getId() {
		return idsector;
	}
	
	public void setNomSector(String nom) {
		NomSector=nom;
	}
	
	public String getNomSector() {
		return NomSector;
	}
	
	
	public void setComentari(String comentari) {
		Comentaris = comentari;
	}
	public String getComentari() {
		return Comentaris;
	}
	
	public void setIdEscola(int ide) {
		idescola = ide;
	}
	
	public int getIdEscola() {
		return idescola;
	}
	

}
