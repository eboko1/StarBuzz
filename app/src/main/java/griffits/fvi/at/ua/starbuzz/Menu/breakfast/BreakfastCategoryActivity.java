package griffits.fvi.at.ua.starbuzz.Menu.breakfast;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import griffits.fvi.at.ua.starbuzz.Menu.drinks.DrinkCategoryActivity;
import griffits.fvi.at.ua.starbuzz.Menu.drinks.DrinkDescriptionActivity;
import griffits.fvi.at.ua.starbuzz.StarbuzzDatabaseHelper;

/**
 * Created by Vika on 20.06.2017.
 */

public class BreakfastCategoryActivity extends ListActivity {
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView list = getListView();
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();

            cursor = db.query("TABMENU",
                    new String[]{"_id", "NAME", "CATEGORY"},
                    "CATEGORY = ?", new String[]{"Breakfast"}, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            list.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "BreakfastCategoryActivity Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(getApplication(), BreakfastDescriptionActivity.class);
        intent.putExtra(BreakfastDescriptionActivity.EXTRA_BREAKFAST_NUMBER, (int) id);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
