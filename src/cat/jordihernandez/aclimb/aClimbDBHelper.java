package cat.jordihernandez.aclimb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class aClimbDBHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "aClimb.db";
    
	private static final String SQL_CREATE_SECTORS =
	    "CREATE TABLE IF NOT EXISTS " + aClimbDB.T_Sectors.TABLE_NAME + " (" +
	    aClimbDB.T_Sectors.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
	    aClimbDB.T_Sectors.COLUMN_NAME_NOM_SECTOR + " VARCHAR" + "," +
	    aClimbDB.T_Sectors.COLUMN_NAME_COMENTARIS + " TEXT" + "," +
	    aClimbDB.T_Sectors.COLUMN_NAME_ESCOLA + " INTEGER" + " );";
	private static final String SQL_CREATE_ESCOLES =
		    "CREATE TABLE IF NOT EXISTS " + aClimbDB.T_Escoles.TABLE_NAME + " (" +
		    aClimbDB.T_Escoles.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
		    aClimbDB.T_Escoles.COLUMN_NAME_NOM_ESCOLA + " VARCHAR" + "," +
		    aClimbDB.T_Escoles.COLUMN_NAME_COMENTARIS + " TEXT" +  " );";
	private static final String SQL_CREATE_VIES =
			"CREATE TABLE IF NOT EXISTS " + aClimbDB.T_Vies.TABLE_NAME + " (" +
			aClimbDB.T_Vies.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			aClimbDB.T_Vies.COLUMN_NAME_NOM_VIA + " VARCHAR," +
			aClimbDB.T_Vies.COLUMN_TIPUS + " VARCHAR, " +
			aClimbDB.T_Vies.COLUMN_DATA_CREACIO + " DATETIME DEFAULT(DATETIME('NOW'))," +
			aClimbDB.T_Vies.COLUMN_GRAU + " VARCHAR," +
			aClimbDB.T_Vies.COLUMN_TOPROPE + " BOOL," + 
			aClimbDB.T_Vies.COLUMN_ORIENTACIO + " VARCHAR," +
			aClimbDB.T_Vies.COLUMN_DESCENS + " VARCHAR," +
			aClimbDB.T_Vies.COLUMN_QUALITAT + " INTEGER," +
			aClimbDB.T_Vies.COLUMN_SECTOR + " INTEGER REFERENCES " +
				aClimbDB.T_Sectors.TABLE_NAME + "(" + aClimbDB.T_Sectors.COLUMN_NAME_ID + "), " + 
			aClimbDB.T_Vies.COLUMN_ESCOLA + " INTEGER REFERENCES " + 
				aClimbDB.T_Escoles.TABLE_NAME + "(" + aClimbDB.T_Escoles.COLUMN_NAME_ID + ")" +
			");";
	private static final String SQL_CREATE_ASCENCIONS =
			"CREATE TABLE IF NOT EXISTS " + aClimbDB.T_Ascencions.TABLE_NAME + " (" +
			aClimbDB.T_Ascencions.COLUMN_NAME_ID_VIA + " INTEGER NOT NULL REFERENCES " + 
					aClimbDB.T_Vies.TABLE_NAME + "(" + aClimbDB.T_Vies.COLUMN_NAME_ID + "), " +
			aClimbDB.T_Ascencions.COLUMN_NAME_DATA_ASC + " DATETIME NOT NULL," +
			aClimbDB.T_Ascencions.COLUMN_FITA   + " VARCHAR, " +
			aClimbDB.T_Ascencions.COLUMN_COMENTARIS + " TEXT, " + 
			"PRIMARY KEY (" + aClimbDB.T_Ascencions.COLUMN_NAME_ID_VIA + "," + aClimbDB.T_Ascencions.COLUMN_NAME_DATA_ASC + "));";
	private static final String SQL_CREATE_LLARGS =
			"CREATE TABLE IF NOT EXISTS " + aClimbDB.T_Llargs.TABLE_NAME + " (" +
			aClimbDB.T_Llargs.COLUMN_NAME_ID_LLARG + " INTEGER NOT NULL, " +
			aClimbDB.T_Llargs.COLUMN_NAME_ID_VIA + " INTEGER NOT NULL REFERENCES " + 
				aClimbDB.T_Vies.TABLE_NAME + "(" + aClimbDB.T_Vies.COLUMN_NAME_ID + "), " +
			aClimbDB.T_Llargs.COLUMN_GRAU + " VARCHAR," +
			aClimbDB.T_Llargs.COLUMN_COMENTARIS + " TEXT, " + 
			"PRIMARY KEY (" + aClimbDB.T_Llargs.COLUMN_NAME_ID_LLARG + "," + aClimbDB.T_Vies.COLUMN_NAME_ID + "));";
			
	
	public aClimbDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_ESCOLES);
		db.execSQL(SQL_CREATE_SECTORS);
		db.execSQL(SQL_CREATE_VIES);
		db.execSQL(SQL_CREATE_ASCENCIONS);
		db.execSQL(SQL_CREATE_LLARGS);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
