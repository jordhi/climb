package cat.jordihernandez.aclimb;

import android.os.Bundle;
import android.view.View;

public class formulariEditarSectors extends formulariSectors {

	int idSector;
	item_sectors sector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Bundle reicieveParams = getIntent().getExtras();
	    idSector = reicieveParams.getInt("id");
	  
	  //recuperar dades de la via idvia provinent del item sel.lecionat
	    manipularDadesSectors dsectors = new manipularDadesSectors(this);
		dsectors.obrir();
		
		sector = dsectors.SeleccioSector(idSector);
		this.nomsector.setText(sector.getNomSector());
		this.comentaris.setText(sector.getComentari());
		this.spEscoles.setSelection(sector.getIdEscola());
		
		dsectors.tancar();
	}

	@Override
	public void InserirSector(View view) {
		// TODO Auto-generated method stub
		manipularDadesSectors dsectors = new manipularDadesSectors(this);
		
		dsectors.obrir();
		// Agafar les dades dels widgets
		item_sectors sector_nou = new item_sectors(this.nomsector.getText().toString(),this.comentaris.getText().toString());
		sector_nou.setIdEscola((int)(this.spEscoles.getSelectedItemId()));
				
		// Modificar a la base de dades i tancar idvia: via a modificar
		dsectors.inserirSector(idSector,sector_nou);
		dsectors.tancar();
		
		finish();
	}

	
	
}
