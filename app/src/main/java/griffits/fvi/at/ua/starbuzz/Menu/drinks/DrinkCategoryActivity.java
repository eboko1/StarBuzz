package griffits.fvi.at.ua.starbuzz.Menu.drinks;

import android.app.ListActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;

import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import griffits.fvi.at.ua.starbuzz.StarbuzzDatabaseHelper;

public class DrinkCategoryActivity extends ListActivity{
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        ListView listDrinks = getListView();

     try {

         db = starbuzzDatabaseHelper.getReadableDatabase();

         cursor = db.query("DRINKS", new String[]{"_id", "NAME"},
                 null, null, null, null, null);

         CursorAdapter listAdapter = new SimpleCursorAdapter(getApplicationContext(),
                 android.R.layout.simple_list_item_1,
                 cursor,
                 new String[]{"NAME"},
                 new int[] {android.R.id.text1},
                 0);
         listDrinks.setAdapter(listAdapter);

     } catch(SQLException e) {
         Toast.makeText(this,"Database unavailable DrinkCategoryActivity", Toast.LENGTH_LONG).show();
     }
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkDescriptionActivity.class);
        intent.putExtra(DrinkDescriptionActivity.EXTRA_DRINK_NUMBER, (int) id);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
