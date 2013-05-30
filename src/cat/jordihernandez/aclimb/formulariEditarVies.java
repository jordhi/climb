package cat.jordihernandez.aclimb;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class formulariEditarVies extends formulariVies {
	int idvia;
	item_vies via;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Bundle reicieveParams = getIntent().getExtras();
	    idvia = reicieveParams.getInt("idvia");
	    
	    //recuperar dades de la via idvia provinent del item sel.lecionat
	    manipularDadesVies dvies = new manipularDadesVies(this);
		dvies.obrir();
		
		via = dvies.SeleccioVia(idvia);
		this.txtvia.setText(via.getNomVia());
		this.txtgrau.setText(via.getGrau());
		
		String stipus = via.getTipus().toString();
		if(stipus.equalsIgnoreCase("Clàssica")) {
			//Mostrar camp Descens si la via és clàssica
			this.txtDescens.setVisibility(View.VISIBLE);
            this.lblDescens.setVisibility(View.VISIBLE);
            this.txtDescens.setText(via.getDescens());
            this.tipusClas.setChecked(true);
		}
		this.TopRope.setChecked(via.getTopRope());
		this.rating.setRating(via.getRating());
		this.spOrientacio.setSelection(via.getIdOrientacio());
		
		
		dvies.tancar();
	    
		
	    
	}

	@Override
	public void InserirDades(View view) {
		// TODO Auto-generated method stub
		
		manipularDadesVies dvies = new manipularDadesVies(this);
		
		dvies.obrir();
		// Agafar les dades dels widgets
		item_vies via_nova = new item_vies(txtvia.getText().toString(),txtgrau.getText().toString(),(int)rating.getRating());
		via_nova.setTipus(tipus.getText().toString());
		via_nova.setOrientacio(spOrientacio.getSelectedItem().toString());
		via_nova.setTopRope(TopRope.isChecked());
		via_nova.setDescens(txtDescens.getText().toString());
				
		// Modificar a la base de dades i tancar idvia: via a modificar
		dvies.inserirVia(idvia,via_nova);
		dvies.tancar();
		
		finish();
		
		
	}
	
}
