package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
}
