/* Classe per fer operacions sobre la taula de vies */

package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class manipularDadesVies {
	
	private SQLiteDatabase bdClimb;
	private aClimbDBHelper dbHelper;
	
	
	public manipularDadesVies(Context context) {
		// TODO Auto-generated constructor stub
		dbHelper = new aClimbDBHelper(context);
	}
	
	public void obrir() throws SQLException {
		//obrim la bd en mode escriptura
	    bdClimb = dbHelper.getWritableDatabase();
	}

	public void tancar() {
	    dbHelper.close();
	}
	
	private ContentValues getValors(item_vies via_nova) {
		ContentValues values = new ContentValues();
		
		values.put(aClimbDB.T_Vies.COLUMN_NAME_NOM_VIA, via_nova.getNomVia());
	    values.put(aClimbDB.T_Vies.COLUMN_GRAU, via_nova.getGrau());
	    values.put(aClimbDB.T_Vies.COLUMN_QUALITAT, via_nova.getRating());
	    values.put(aClimbDB.T_Vies.COLUMN_TIPUS, via_nova.getTipus());
	    values.put(aClimbDB.T_Vies.COLUMN_ORIENTACIO, via_nova.getOrientacio());
	    values.put(aClimbDB.T_Vies.COLUMN_TOPROPE, via_nova.getTopRope());
	    values.put(aClimbDB.T_Vies.COLUMN_DESCENS, via_nova.getDescens());
		
		return values;
	}
	
	public void inserirVia(int id, item_vies via_nova) {
		ContentValues values = new ContentValues();
	     
	    values = getValors(via_nova);
	    values.put(aClimbDB.T_Vies.COLUMN_NAME_ID, id);
	    bdClimb.replace(aClimbDB.T_Vies.TABLE_NAME, null, values);
	}
	
	public void inserirVia(item_vies via_nova) {
		    ContentValues values = new ContentValues();
		    		    
		    values = getValors(via_nova);
		    bdClimb.insert(aClimbDB.T_Vies.TABLE_NAME, null, values);
		   		    
		   /* Cursor cursor = bdClimb.query(aClimbDB.T_Vies.TABLE_NAME,
		        null, aClimbDB.T_Vies.COLUMN_NAME_ID + " = " + insertId, null,
		        null, null, null);
		    cursor.moveToFirst();
		    item_vies viaNova = cursorToVies(cursor);
		    cursor.close();
		    return viaNova;*/
		  }
	
	public void EsborrarVia (int id) {
		System.out.println("Via amb id: " + id + " esborrada");
		bdClimb.delete(aClimbDB.T_Vies.TABLE_NAME, aClimbDB.T_Vies.COLUMN_NAME_ID + "=" + id, null);
	}
	
	public ArrayList<item_vies> getAllVies() {
	    ArrayList<item_vies> vies = new ArrayList<item_vies>();

	    Cursor cursor = bdClimb.query(aClimbDB.T_Vies.TABLE_NAME,
	        null , null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      item_vies via = cursorToVies(cursor);
	      vies.add(via);
	      cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return vies;
	  }
	
	 private item_vies cursorToVies(Cursor cursor) {
		    item_vies via = new item_vies();
		    via.setId(cursor.getInt(0));
		    via.setNomVia(cursor.getString(1));
		    via.setGrau(cursor.getString(4));
		    via.setRating(cursor.getInt(8));
		    return via;
	}
	 
	public item_vies SeleccioVia(int id) {
		item_vies viasel = new item_vies();
		String condicio = aClimbDB.T_Vies.COLUMN_NAME_ID + "=" + id;
		
		System.out.println("Sel.leccio: " + condicio);
		Cursor cursor = bdClimb.query(aClimbDB.T_Vies.TABLE_NAME,
		        null , condicio, null, null, null, null);

		cursor.moveToFirst();
		viasel = cursorToVies(cursor);
		viasel.setId(cursor.getInt(0));
	    viasel.setNomVia(cursor.getString(1));
	    viasel.setTipus(cursor.getString(2));
	    viasel.setGrau(cursor.getString(4));
	    viasel.setTopRope(IntToBool(cursor.getInt(5)));
	    viasel.setOrientacio(cursor.getString(6));
	    viasel.setDescens(cursor.getString(7));
	    viasel.setRating(cursor.getInt(8));
	    
//		while (!cursor.isAfterLast()) {
//		      item_vies via = cursorToVies(cursor);
//		      vies.add(via);
//		      cursor.moveToNext();
//		 }
		    // Make sure to close the cursor
		    cursor.close();
		return viasel;
	}
	
	public boolean IntToBool(int b) {
	    if(b != 0) return true;
	    else return false;
	}

}
