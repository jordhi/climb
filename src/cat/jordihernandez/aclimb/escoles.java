package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.AdapterContextMenuInfo;


public class escoles extends ListFragment {

	
	 ArrayList<item_escoles> llista_escoles = new ArrayList<item_escoles>();
	 private manipularDadesEscoles dadesEscoles;
	 
	 /** An array of items to display in ArrayList */
    
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
       ObtenirLlistaEscoles();
       return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    public void ObtenirLlistaEscoles() {
    	
   	 /** Creating array adapter to set data in listview */
     dadesEscoles = new manipularDadesEscoles(this.getActivity());
   	 dadesEscoles.obrir();
   	
   	 llista_escoles = dadesEscoles.getAllEscoles();
     itemEscolesAdapter adapter = new itemEscolesAdapter(this.getActivity(), llista_escoles);
       
     /** Setting the array adapter to the listview */
     setListAdapter(adapter);
       
      //tanquem la bbdd
      dadesEscoles.tancar();
   }
	

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		this.ObtenirLlistaEscoles();
		super.onResume();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = this.getActivity().getMenuInflater();
	    inflater.inflate(R.menu.mcont_vies, menu);
	}
    
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) {
	    case R.id.esborrar_item:
	    	
	    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    	
	    	//Obrir el manipulador de la base de dades, obrir-la, eliminar l'element i actualitzar el listview	    	
	    	dadesEscoles = new manipularDadesEscoles(this.getActivity());
	    	dadesEscoles.obrir();
	    	dadesEscoles.EsborrarEscola(llista_escoles.get(info.position).id);
	    	dadesEscoles.tancar();
	    	ObtenirLlistaEscoles();
	    	return true;
	    	
	    case R.id.editar_item:
	    	
	    	AdapterContextMenuInfo info2 = (AdapterContextMenuInfo) item.getMenuInfo();
	    	Intent intent = new Intent(this.getActivity(), formulariEditarEscoles.class);
	    	intent.putExtra("id",llista_escoles.get(info2.position).id);
	    	startActivity(intent);
	    	return true;
	        
	    default:
	    	return super.onContextItemSelected(item);
	    	
	    }
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		registerForContextMenu(getListView());
	}
}
