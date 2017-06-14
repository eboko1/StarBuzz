package griffits.fvi.at.ua.starbuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import griffits.fvi.at.ua.starbuzz.Menu.Dessert;

/**
 * Created by Vika on 13.06.2017.
 */

public class DessertCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listDessert = getListView();

       ArrayAdapter<Dessert> listAdapter = new ArrayAdapter<Dessert>(this, android.R.layout.simple_list_item_1, Dessert.desserts);
       listDessert.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
       Intent intent = new Intent(getApplicationContext(), DessertDescriptionActivity.class);
       intent.putExtra(DessertDescriptionActivity.EXTRA_DESSERT, (int) id);
       startActivity(intent);
    }
}
