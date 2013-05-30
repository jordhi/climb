package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class itemViesAdapter extends BaseAdapter {
	protected Activity activity;
	protected ArrayList<item_vies> items;
	  
	public itemViesAdapter(Activity activity, ArrayList<item_vies> items) {
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
	      vi = inflater.inflate(R.layout.list_item_view_vies, null);
	    }
	             
	    item_vies item = items.get(position);
	         
	    //ImageView image = (ImageView) vi.findViewById(R.id.imgSpinnerOri);
	    //int imageResource = activity.getResources().getIdentifier(item.getRutaImagen(), null, activity.getPackageName());
	    //image.setImageDrawable(activity.getResources().getDrawable(imageResource));
	         
	    TextView nombre = (TextView) vi.findViewById(R.id.text1);
	    nombre.setText(item.getNomVia() + " id:" + item.getId());
	         
	    TextView tipo = (TextView) vi.findViewById(R.id.text2);
	    tipo.setText(item.getGrau());
	    
	    RatingBar rating = (RatingBar) vi.findViewById(R.id.lblRatQualitat);
	    rating.setRating((float)item.getRating());
	    
	       
	    return vi;
	}

}
