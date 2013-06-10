package cat.jordihernandez.aclimb;

import android.os.Bundle;
import android.view.View;

public class formulariEditarEscoles extends formulariEscoles {

	int idEscola;
	item_escoles escola;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Bundle reicieveParams = getIntent().getExtras();
	    idEscola = reicieveParams.getInt("id");
	  
	  //recuperar dades de la via idvia provinent del item sel.lecionat
	    manipularDadesEscoles descoles = new manipularDadesEscoles(this);
		descoles.obrir();
		
		escola = descoles.SeleccioEscola(idEscola);
		this.nomescola.setText(escola.getNomEscola());
		this.comentaris.setText(escola.getComentari());
		
		descoles.tancar();
	    
	}

	@Override
	public void InserirEscola(View view) {
		// TODO Auto-generated method stub
		manipularDadesEscoles descoles = new manipularDadesEscoles(this);
		
		descoles.obrir();
		// Agafar les dades dels widgets
		item_escoles escola_nova = new item_escoles(this.nomescola.getText().toString(),this.comentaris.getText().toString());
		
				
		// Modificar a la base de dades i tancar idvia: via a modificar
		descoles.inserirEscola(idEscola,escola_nova);
		descoles.tancar();
		
		finish();
	}

}
