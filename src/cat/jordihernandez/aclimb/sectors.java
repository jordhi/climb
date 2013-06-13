package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;


public class sectors extends ListFragment {
	
	 ArrayList<item_sectors> llista_sectors = new ArrayList<item_sectors>();
	 private manipularDadesSectors dadesSectors;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	 
	       ObtenirLlistaSectors();
	       return super.onCreateView(inflater, container, savedInstanceState);
	    }
	 
	 public void ObtenirLlistaSectors() {
	    	
	   	 /** Creating array adapter to set data in listview */
	     dadesSectors = new manipularDadesSectors(this.getActivity());
	   	 dadesSectors.obrir();
	   	
	   	 llista_sectors = dadesSectors.getAllSectors();
	     itemSectorsAdapter adapter = new itemSectorsAdapter(this.getActivity(), llista_sectors);
	       
	     /** Setting the array adapter to the listview */
	     setListAdapter(adapter);
	       
	      //tanquem la bbdd
	      dadesSectors.tancar();
	   }
	 
	 @Override
		public void onResume() {
			// TODO Auto-generated method stub
			this.ObtenirLlistaSectors();
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
		    	dadesSectors = new manipularDadesSectors(this.getActivity());
		    	dadesSectors.obrir();
		    	dadesSectors.EsborrarSector(llista_sectors.get(info.position).idsector);
		    	dadesSectors.tancar();
		    	ObtenirLlistaSectors();
		    	return true;
		    	
		    case R.id.editar_item:
		    	
		    	AdapterContextMenuInfo info2 = (AdapterContextMenuInfo) item.getMenuInfo();
		    	Intent intent = new Intent(this.getActivity(), formulariEditarSectors.class);
		    	intent.putExtra("id",llista_sectors.get(info2.position).idsector);
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
