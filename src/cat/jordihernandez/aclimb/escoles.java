package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
    

}
