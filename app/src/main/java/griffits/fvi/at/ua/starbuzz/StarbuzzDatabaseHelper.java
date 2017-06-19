package griffits.fvi.at.ua.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import griffits.fvi.at.ua.starbuzz.R;

/**
 * Created by Vika on 14.06.2017.
 */

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_INFO = "mylog";


    private static final String DB_NAME = "Starbuzz";
    private static final int DB_VERSION = 1;  // for update database change  version  --->2

    private static final String TABLE_CREATE_DRINK = "CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NAME TEXT, "
            + "DESCRIPTION TEXT, "
            + "IMAGE_RESOURCE_ID INTEGER, "
            + "CATEGORY TEXT);";

     public StarbuzzDatabaseHelper(Context context){
      super(context,DB_NAME, null, DB_VERSION);
        Log.i(LOG_INFO, "StarbuzzDatabaseHelper constructor ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       updateMyDatabase(db, 0, DB_VERSION);


        Log.i(LOG_INFO, "StarbuzzDatabaseHelper start onCreate " + " name database " + DB_NAME
                + " version database " + DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
        Log.i(LOG_INFO, "StarbuzzDatabaseHelper onUpgrade " + " oldVersion| " + oldVersion + " newVersion| " + newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1) {
            db.execSQL(TABLE_CREATE_DRINK);
            insertDrink(db, "Latte", "Espresso and steamed milk", R.mipmap.ic_latte, "drinks");
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.mipmap.ic_cappuccino, "drinks");
            insertDrink(db, "Filter", "Our best drip coffee", R.mipmap.ic_filter, "drinks");
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId, String category) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        drinkValues.put("CATEGORY", category);
        db.insert("DRINK", null, drinkValues);
    }

}
