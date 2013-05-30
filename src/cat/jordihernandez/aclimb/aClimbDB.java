package cat.jordihernandez.aclimb;

import android.provider.BaseColumns;

public class aClimbDB {
	
	//constructor per evitar instaciar la classe
	private aClimbDB() {}
	public static abstract class COORD implements BaseColumns {
		public static final int NORD = 0;
		public static final int NORDOEST = 1;
		public static final int NORDEST = 2;
		public static final int SUD = 3;
		public static final int SUDOEST = 4;
		public static final int SUDEST = 5;
		public static final int EST = 6;
		public static final int OEST = 7;
		
	}
	
	//Taula de SECTOR
	public static abstract class T_Sectors implements BaseColumns {
		public static final String TABLE_NAME = "sectors";
		public static final String COLUMN_NAME_ID = "id_sector";
		public static final String COLUMN_NAME_NOM_SECTOR = "nom_sector";
		public static final String COLUMN_NAME_COMENTARIS = "comentaris";
		public static final String COLUMN_NAME_ESCOLA = "escola";
    }
	
	// Taula d'ESCOLES
	public static abstract class T_Escoles implements BaseColumns {
		public static final String TABLE_NAME = "escoles";
		public static final String COLUMN_NAME_ID = "id_escola";
		public static final String COLUMN_NAME_NOM_ESCOLA = "nom_escola";
		public static final String COLUMN_NAME_COMENTARIS = "comentaris";
		
    }
	// Taula de VIES
	public static abstract class T_Vies implements BaseColumns {
		public static final String TABLE_NAME = "vies";
		public static final String COLUMN_NAME_ID = "id_via";
		public static final String COLUMN_NAME_NOM_VIA = "nom_via";
		public static final String COLUMN_TIPUS = "tipus";
		public static final String COLUMN_DATA_CREACIO = "data_creacio";
		public static final String COLUMN_GRAU = "grau";
		public static final String COLUMN_TOPROPE = "toperope";
		public static final String COLUMN_ORIENTACIO = "orientacio";
		public static final String COLUMN_OBSERVACIONS = "observacions";
		public static final String COLUMN_DESCENS = "descens";
		public static final String COLUMN_SECTOR = "sector";
		public static final String COLUMN_ESCOLA = "escola";
		public static final String COLUMN_QUALITAT = "qualitat";
    }
	
	// Taula de LLargs		
	public static abstract class T_Llargs implements BaseColumns {
		public static final String TABLE_NAME = "llargs";
		public static final String COLUMN_NAME_ID_LLARG = "id_llarg";
		public static final String COLUMN_NAME_ID_VIA = "id_via";
		public static final String COLUMN_GRAU = "grau";
		public static final String COLUMN_COMENTARIS = "comentaris";
	}
	// Taula d'Ascencions
	public static abstract class T_Ascencions implements BaseColumns {
		public static final String TABLE_NAME = "ascencions";
		public static final String COLUMN_NAME_ID_VIA = "id_via";
		public static final String COLUMN_NAME_DATA_ASC = "data_asc";
		public static final String COLUMN_FITA = "fita";
		public static final String COLUMN_COMENTARIS = "comentaris";
	}
}