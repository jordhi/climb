package cat.jordihernandez.aclimb;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;
	 
public class ContingutsTabHost implements TabContentFactory{
	  private Context mContext;
	 
	  public ContingutsTabHost(Context context){
	        mContext = context;
	  }
	 
	  @Override
	  public View createTabContent(String tag) {
	        View v = new View(mContext);
	        return v;
	  }
}
