package cat.jordihernandez.aclimb;

import java.util.ArrayList;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class formulariVies extends Activity {
	EditText txtvia,txtgrau,txtDescens;
	Spinner spOrientacio, spEscoles, spSectors;
	RadioGroup optTipus;
	RadioButton tipus,tipusEsp,tipusClas;
	TextView lblDescens;
	RatingBar rating;
	CheckBox TopRope;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_vies);
		
		manipularDadesEscoles descoles = new manipularDadesEscoles(this);
		//Arrays per agafar llistat d'escoles i posar-los al spinner d'escoles
		ArrayList<item_escoles> llista_escoles = new ArrayList<item_escoles>();
		ArrayList<String> nom_escoles = new ArrayList<String>();
		//item_escoles per sel.leccionar una escola quan ens recorrem l'Array
		item_escoles item = new item_escoles();
		
		txtgrau = (EditText)this.findViewById(R.id.txtGrau);
		rating = (RatingBar)this.findViewById(R.id.ratQualitat);
		TopRope = (CheckBox)this.findViewById(R.id.chkToprope);
		
		//disseny del spinner Orientacio
		spOrientacio = (Spinner)this.findViewById(R.id.cmbOrientacio);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_orientacio, android.R.layout.simple_spinner_item);
		spOrientacio.setAdapter(adapter);
		
		//Omplir spinner Escoles
		spEscoles = (Spinner)this.findViewById(R.id.frmViescmbEscola);
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
		
		txtDescens = (EditText)this.findViewById(R.id.txtDescens);
		lblDescens = (TextView)this.findViewById(R.id.lblDescens);
		
		//fem que entrar el nom de la via sigui en primer valor a entrar
		txtvia = (EditText)this.findViewById(R.id.txtNomVia);
		txtvia.requestFocus();
		
		//Si sel·leccionem via clàssica mostrem el camp descens
		optTipus = (RadioGroup)this.findViewById(R.id.rgrpEspClas);
		tipus = (RadioButton)this.findViewById(optTipus.getCheckedRadioButtonId());
		tipusEsp = (RadioButton)this.findViewById(R.id.radioEsp);
		tipusClas = (RadioButton)this.findViewById(R.id.radioCla);
		
		optTipus.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				 if (checkedId == R.id.radioEsp){
			            txtDescens.setVisibility(View.GONE);
			            lblDescens.setVisibility(View.GONE);
			        }else if (checkedId == R.id.radioCla){
			        	txtDescens.setVisibility(View.VISIBLE);
			            lblDescens.setVisibility(View.VISIBLE);
			       }
				 tipus = (RadioButton)findViewById(optTipus.getCheckedRadioButtonId());
			}
			
		});
	}

	public void InserirDades (View view) {
			
		manipularDadesVies dvies = new manipularDadesVies(this);
		
		dvies.obrir();
		// Agafar les dades dels widgets
		item_vies via_nova = new item_vies(txtvia.getText().toString(),txtgrau.getText().toString(),(int)rating.getRating());
		via_nova.setTipus(tipus.getText().toString());
		via_nova.setOrientacio(spOrientacio.getSelectedItem().toString());
		via_nova.setTopRope(TopRope.isChecked());
		via_nova.setDescens(txtDescens.getText().toString());
		//via_nova.setSector((int)spSectors.getSelectedItemPosition());
		via_nova.setEscola((int)(spEscoles.getSelectedItemId()));
		
		
		// Inserir a la base de dades i tancar
		dvies.inserirVia(via_nova);
		dvies.tancar();
		
		finish();
		
	}
	
	public void CancelarNovaVia (View view) {
		finish();
		
	}

}
