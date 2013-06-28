package cat.jordihernandez.aclimb;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class manipularDadesSectors {
	private SQLiteDatabase bdClimb;
	private aClimbDBHelper dbHelper;

	public manipularDadesSectors(Context context) {
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

	private ContentValues getValors(item_sectors sector_nou) {
		ContentValues values = new ContentValues();

		values.put(aClimbDB.T_Sectors.COLUMN_NAME_NOM_SECTOR,
				sector_nou.getNomSector());
		values.put(aClimbDB.T_Sectors.COLUMN_NAME_COMENTARIS,
				sector_nou.getComentari());
		values.put(aClimbDB.T_Sectors.COLUMN_ID_ESCOLA,
				sector_nou.getIdEscola());

		return values;
	}

	public void inserirSector(int id, item_sectors nou) {
		ContentValues values = new ContentValues();

		values = getValors(nou);
		values.put(aClimbDB.T_Sectors.COLUMN_NAME_ID, id);
		bdClimb.replace(aClimbDB.T_Sectors.TABLE_NAME, null, values);
	}

	public void inserirSector(item_sectors nou) {
		ContentValues values = new ContentValues();
		values = getValors(nou);
		bdClimb.insert(aClimbDB.T_Sectors.TABLE_NAME, null, values);
	}

	public void EsborrarSector(int id) {
		System.out.println("Sector amb id: " + id + " esborrada");
		bdClimb.delete(aClimbDB.T_Sectors.TABLE_NAME,
				aClimbDB.T_Sectors.COLUMN_NAME_ID + "=" + id, null);
	}

	public ArrayList<item_sectors> getAllSectors() {
		ArrayList<item_sectors> sectors = new ArrayList<item_sectors>();

		Cursor cursor = bdClimb.query(aClimbDB.T_Sectors.TABLE_NAME, null,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			item_sectors sector = cursorToSectors(cursor);
			sectors.add(sector);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return sectors;
	}

	private item_sectors cursorToSectors(Cursor cursor) {
		item_sectors sector = new item_sectors();
		sector.setId(cursor.getInt(0));
		sector.setNomSector(cursor.getString(1));
		sector.setComentari(cursor.getString(2));
		sector.setIdEscola(cursor.getInt(3));
		return sector;
	}

	public item_sectors SeleccioSector(int id) {
		item_sectors sectorsel = new item_sectors();
		String condicio = aClimbDB.T_Sectors.COLUMN_NAME_ID + "=" + id;

		System.out.println("Sel.leccio: " + condicio);
		Cursor cursor = bdClimb.query(aClimbDB.T_Sectors.TABLE_NAME, null,
				condicio, null, null, null, null);

		cursor.moveToFirst();
		sectorsel = cursorToSectors(cursor);
		sectorsel.setId(cursor.getInt(0));
		sectorsel.setNomSector(cursor.getString(1));
		sectorsel.setComentari(cursor.getString(2));
		sectorsel.setIdEscola(cursor.getInt(3));
		cursor.close();

		return sectorsel;
	}
	
	public item_sectors SeleccioSector(int idEscola, String nomSector) {
		item_sectors sectorsel = new item_sectors();
		String condicio = aClimbDB.T_Sectors.COLUMN_ID_ESCOLA + "=" + idEscola
				+ " AND " + aClimbDB.T_Sectors.COLUMN_NAME_NOM_SECTOR + "=" + "'" + nomSector + "'";

		System.out.println("Sel.leccio: " + condicio);
		Cursor cursor = bdClimb.query(aClimbDB.T_Sectors.TABLE_NAME, null,
				condicio, null, null, null, null);

		cursor.moveToFirst();
		sectorsel = cursorToSectors(cursor);
		sectorsel.setId(cursor.getInt(0));
		sectorsel.setNomSector(cursor.getString(1));
		sectorsel.setComentari(cursor.getString(2));
		sectorsel.setIdEscola(cursor.getInt(3));
		cursor.close();

		return sectorsel;
	}
}
