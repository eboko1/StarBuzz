package griffits.fvi.at.ua.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import griffits.fvi.at.ua.starbuzz.R;

/**
 * Created by Vika on 14.06.2017.
 */

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_INFO = "mylog";


    private static final String DB_NAME = "Starbuzz";
    private static final int DB_VERSION = 1;  // for update database change  version  --->2

    private static final String TABLE_CREATE_TABMENU = "CREATE TABLE TABMENU (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NAME TEXT, "
            + "DESCRIPTION TEXT, "
            + "IMAGE_RESOURCE_ID BLOG, "
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
            db.execSQL(TABLE_CREATE_TABMENU);
            insertDrink(db, "Latte", "Espresso and steamed milk", R.mipmap.ic_latte, "Drinks");
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.mipmap.ic_cappuccino, "Drinks");
            insertDrink(db, "Filter", "Our best drip coffee", R.mipmap.ic_filter, "Drinks");
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE TABMENU ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    public static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId, String category) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        drinkValues.put("CATEGORY", category);
        db.insert("TABMENU", null, drinkValues);
    }

    public void insertMenu(String name, String description, byte [] imageByte, String category) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("DESCRIPTION", description);
        contentValues.put("IMAGE_RESOURCE_ID", imageByte);
        contentValues.put("CATEGORY", category);
        this.getWritableDatabase().insertOrThrow("TABMENU", null, contentValues);
    }

    public void delete(String name){
        this.getWritableDatabase().delete("TABMENU", "NAME='" + name + "'",null);
    }

    public void update(String oldName, String newName){
        this.getWritableDatabase().execSQL("UPDATE TABMENU SET NAME='" + newName +"' WHERE NAME='" + oldName+"'",  null);
    }

    public void list_all_table(TextView screen){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM TABMENU", null);
        screen.setText(" ");
        while (cursor.moveToNext()){
            screen.append(cursor.getString(1)+ " " +cursor.getString(4)+"\n");
        }
    }


}
