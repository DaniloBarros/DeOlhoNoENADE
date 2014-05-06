package br.unb.deolhonoenade.DAO;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


	public class DataBaseHelper extends SQLiteOpenHelper{
		 
	    //The Android's default system path of your application database.
	    private static String DB_PATH = "/data/data/YOUR_PACKAGE/databases/";
	    // PS: Remember to change the "YOUR_PACKAGE" to your application package namespace (i.e: com.examplename.myapp) in the DB_PATH string.
	 
	    private static String DB_NAME = "myDBName";
	 
	    private SQLiteDatabase myDataBase; 
	 
	    private final Context myContext;
	 
	    /**
	     * Constructor
	     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
	     * @param context
	     */
	    public DataBaseHelper(Context context) {
	 
	    	super(context, DB_NAME, null, 1);
	        this.myContext = context;
	    }	
	 
		 
	    public void openDataBase() throws SQLException{
	 
	    	//Open the database
	        String myPath = DB_PATH + DB_NAME;
	    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	 
	    }
	 
	    @Override
		public synchronized void close() {
	 
	    	    if(myDataBase != null)
	    		    myDataBase.close();
	 
	    	    super.close();
	 
		}
	 
		@Override
		public void onCreate(SQLiteDatabase db) {
	 
		}
	 
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	 
		}
	 
	        // Add your public helper methods to access and get content from the database.
	       // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
	       // to you to create adapters for your views.
	 
	}



