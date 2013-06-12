package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class itemSectorsAdapter extends BaseAdapter {
	protected Activity activity;
	protected ArrayList<item_sectors> items;
	
	public itemSectorsAdapter(Activity activity, ArrayList<item_sectors> items) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	    this.items = items;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
        
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.list_item_view_sectors, null);
	    }
	             
	    item_sectors item = items.get(position);
	         
	    //ImageView image = (ImageView) vi.findViewById(R.id.imgSpinnerOri);
	    //int imageResource = activity.getResources().getIdentifier(item.getRutaImagen(), null, activity.getPackageName());
	    //image.setImageDrawable(activity.getResources().getDrawable(imageResource));
	         
	    TextView nomsector = (TextView) vi.findViewById(R.id.txtNomSector);
	    nomsector.setText(item.getNomSector() + " id:" + item.getId());
	         
	    TextView nomescolasector = (TextView) vi.findViewById(R.id.txtNomEscolaSector);
	    nomescolasector.setText("Escola X");
	       
	    return vi;
	}

}
