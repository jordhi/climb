package cat.jordihernandez.aclimb;

import java.util.ArrayList;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class formulariSectors extends Activity {
	EditText nomsector, comentaris;
	Spinner spEscoles;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_sectors);
		
		manipularDadesEscoles descoles = new manipularDadesEscoles(this);
		//Arrays per agafar llistat d'escoles i posar-los al spinner d'escoles
		ArrayList<item_escoles> llista_escoles = new ArrayList<item_escoles>();
		ArrayList<String> nom_escoles = new ArrayList<String>();
		//item_escoles per sel.leccionar una escola quan ens recorrem l'Array
		item_escoles item = new item_escoles();
		
		nomsector = (EditText)this.findViewById(R.id.etxtNomSector);
		comentaris = (EditText)this.findViewById(R.id.etxComentarisSector);
		
		//Omplir spinner Escoles
		spEscoles = (Spinner)this.findViewById(R.id.spEscolesfrmSectors);
		descoles.obrir();
		llista_escoles = descoles.getAllEscoles();
		ListIterator<item_escoles> it = llista_escoles.listIterator();
		//Recórrer escoles i omplir array<string> amb el nom de les escoles
		while(it.hasNext()) {
			item = (item_escoles)it.next();
			nom_escoles.add(item.getNomEscola());
		}
				
		//adaptar l'spinner a l'array dels noms escoles
		ArrayAdapter<String> adapter_escoles = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, nom_escoles);
		adapter_escoles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spEscoles.setAdapter(adapter_escoles);
		descoles.tancar();
	}
	
	public void InserirSector (View view) {
		
		manipularDadesSectors dsectors = new manipularDadesSectors(this);
		
		dsectors.obrir();
		// Agafar les dades dels widgets
		item_sectors sector_nou = new item_sectors(nomsector.getText().toString(),comentaris.getText().toString());
		sector_nou.setIdEscola((int)(spEscoles.getSelectedItemId()));
		
		// Inserir a la base de dades i tancar
		dsectors.inserirSector(sector_nou);
		dsectors.tancar();
		
		finish();
		
	}
	
	public void CancelarNouSector (View view) {
		finish();
		
	}
}
