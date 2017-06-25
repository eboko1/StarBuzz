package griffits.fvi.at.ua.starbuzz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyFavoriteCategoryActivity extends AppCompatActivity {



    private ListView list_favorite;
    SQLiteDatabase db;
    Cursor favoritesCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite_category);

        list_favorite = (ListView)findViewById(R.id.list_favorite);

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try{
            db = starbuzzDatabaseHelper.getReadableDatabase();
            favoritesCursor = db.query("TABMENU", new String[]{"_id", "NAME"}, "FAVORITE == 1", null, null, null, null);

            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    favoritesCursor, new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            list_favorite.setAdapter(favoriteAdapter);

        } catch (SQLiteException e){
            Toast.makeText(getApplicationContext(), "  MyFavoriteCategoryActivity  Database unavailable ", Toast.LENGTH_LONG).show();

        }


    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }
}
