package griffits.fvi.at.ua.starbuzz.Menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import griffits.fvi.at.ua.starbuzz.R;

/**
 * Created by Vika on 14.06.2017.
 */

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz.db";
    private static final int DB_VERSION = 1;


    public final static String TABLE_NAME_DRINKS = "drinks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_IMAGE_RES_ID = "imageResId";

    private static final String CREATE_DATABASE_DRINK = "create table " + TABLE_NAME_DRINKS + " (" +
            COLUMN_ID + " int primary key, " + COLUMN_NAME + " text not null, " +
            COLUMN_DESCRIPTION + " text not null, " + COLUMN_IMAGE_RES_ID + " int not null";

    StarbuzzDatabaseHelper (Context context){
      super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);

    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){

        if(oldVersion < 1){
            db.execSQL(CREATE_DATABASE_DRINK);
            insertDrink(db,"Latte", "A couple of espresso shots with streamed milk", R.mipmap.ic_latte);
            insertDrink(db,"Cappuccino","Espresso, hot milk, and a steamed milk foam", R.mipmap.ic_cappuccino);
            insertDrink(db,"Filter", "Highest quality beans roasted and brewed fresh", R.mipmap.ic_filter);
        }
        if (oldVersion < 2){
            
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            updateMyDatabase(db,oldVersion, newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description, int imageResId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put(COLUMN_NAME, name);
        drinkValues.put(COLUMN_DESCRIPTION, description);
        drinkValues.put(COLUMN_IMAGE_RES_ID, imageResId );
        db.insert(TABLE_NAME_DRINKS, null, drinkValues);
    }
}
