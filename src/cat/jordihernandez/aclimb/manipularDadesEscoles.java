/* Classe per fer operacions sobre la taula ESCOLES */

package cat.jordihernandez.aclimb;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class manipularDadesEscoles {

	private SQLiteDatabase bdClimb;
	private aClimbDBHelper dbHelper;

	public manipularDadesEscoles(Context context) {
		// TODO Auto-generated constructor stub
		dbHelper = new aClimbDBHelper(context);
	}

	public void obrir() throws SQLException {
		// obrim la bd en mode escriptura
		bdClimb = dbHelper.getWritableDatabase();
	}

	public void tancar() {
		dbHelper.close();
	}

	private ContentValues getValors(item_escoles escola_nova) {
		ContentValues values = new ContentValues();

		values.put(aClimbDB.T_Escoles.COLUMN_NAME_NOM_ESCOLA,
				escola_nova.getNomEscola());
		values.put(aClimbDB.T_Escoles.COLUMN_NAME_COMENTARIS,
				escola_nova.getComentari());

		return values;
	}

	public void inserirEscola(int id, item_escoles nova) {
		ContentValues values = new ContentValues();

		values = getValors(nova);
		values.put(aClimbDB.T_Escoles.COLUMN_NAME_ID, id);
		bdClimb.replace(aClimbDB.T_Escoles.TABLE_NAME, null, values);
	}

	public void inserirEscola(item_escoles nova) {
		ContentValues values = new ContentValues();
		values = getValors(nova);
		bdClimb.insert(aClimbDB.T_Escoles.TABLE_NAME, null, values);
	}

	public void EsborrarEscola(int id) {
		System.out.println("Escola amb id: " + id + " esborrada");
		bdClimb.delete(aClimbDB.T_Escoles.TABLE_NAME,
				aClimbDB.T_Escoles.COLUMN_NAME_ID + "=" + id, null);
	}

	public ArrayList<item_escoles> getAllEscoles() {
		ArrayList<item_escoles> escoles = new ArrayList<item_escoles>();

		Cursor cursor = bdClimb.query(aClimbDB.T_Escoles.TABLE_NAME, null,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			item_escoles escola = cursorToEscoles(cursor);
			escoles.add(escola);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return escoles;
	}

	private item_escoles cursorToEscoles(Cursor cursor) {
		item_escoles escola = new item_escoles();
		escola.setId(cursor.getInt(0));
		escola.setNomEscola(cursor.getString(1));
		escola.setComentari(cursor.getString(2));
		return escola;
	}

	public item_escoles SeleccioEscola(int id) {
		item_escoles escolasel = new item_escoles();
		String condicio = aClimbDB.T_Escoles.COLUMN_NAME_ID + "=" + id;

		System.out.println("Sel.leccio: " + condicio);
		Cursor cursor = bdClimb.query(aClimbDB.T_Escoles.TABLE_NAME, null,
				condicio, null, null, null, null);

		cursor.moveToFirst();
		escolasel = cursorToEscoles(cursor);
		escolasel.setId(cursor.getInt(0));
		escolasel.setNomEscola(cursor.getString(1));
		escolasel.setComentari(cursor.getString(2));
		cursor.close();

		return escolasel;
	}
}
