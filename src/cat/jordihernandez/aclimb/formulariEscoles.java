package cat.jordihernandez.aclimb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

public class formulariEscoles extends Activity {
	EditText nomescola, comentaris;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_escoles);
		
		nomescola = (EditText)this.findViewById(R.id.etxtNomEscola);
		comentaris = (EditText)this.findViewById(R.id.etxComentaris);
		
	}
	 
	public void InserirEscola (View view) {
		
		manipularDadesEscoles descoles = new manipularDadesEscoles(this);
		
		descoles.obrir();
		// Agafar les dades dels widgets
		item_escoles escola_nova = new item_escoles(nomescola.getText().toString(),comentaris.getText().toString());
		
		
		// Inserir a la base de dades i tancar
		descoles.inserirEscola(escola_nova);
		descoles.tancar();
		
		finish();
		
	}
	
	public void CancelarNovaEscola (View view) {
		finish();
		
	}
}
