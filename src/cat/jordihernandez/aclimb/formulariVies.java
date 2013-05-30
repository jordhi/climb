package cat.jordihernandez.aclimb;

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
	Spinner spOrientacio;
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
				
		
		txtgrau = (EditText)this.findViewById(R.id.txtGrau);
		rating = (RatingBar)this.findViewById(R.id.ratQualitat);
		TopRope = (CheckBox)this.findViewById(R.id.chkToprope);
		
		//disseny del spinner
		spOrientacio = (Spinner)this.findViewById(R.id.cmbOrientacio);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_orientacio, android.R.layout.simple_spinner_item);
		spOrientacio.setAdapter(adapter);
				
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
		
		
		// Inserir a la base de dades i tancar
		dvies.inserirVia(via_nova);
		dvies.tancar();
		
		finish();
		
	}
	
	public void CancelarNovaVia (View view) {
		finish();
		
	}

}
