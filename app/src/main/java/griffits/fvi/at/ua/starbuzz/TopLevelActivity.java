package griffits.fvi.at.ua.starbuzz;

import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import griffits.fvi.at.ua.starbuzz.Menu.dessert.DessertCategoryActivity;
import griffits.fvi.at.ua.starbuzz.Menu.drinks.DrinkCategoryActivity;
import griffits.fvi.at.ua.starbuzz.adapter.MyAdapter;

public class TopLevelActivity extends AppCompatActivity {



    private static final String LOG_INFO = "mylog";

    private Context context;
    private ArrayList<Integer> listId;
    private ArrayList<String> listTitle;

    ListView listViewOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        Log.i(LOG_INFO, "onCreate in TopLevelActivity");

        listViewOption = (ListView)findViewById(R.id.list_options);

        listId = new ArrayList<Integer>();
        listTitle = new ArrayList<String>();

        listId = getListImageId();
        listTitle = getListTitle();

        MyAdapter myAdapter = new MyAdapter(this, listId, listTitle);
        listViewOption.setAdapter(myAdapter);


        listViewOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             if(listTitle.get(position).equals("Drinks")){
                 Toast.makeText(getApplication(),"Drinks", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), DrinkCategoryActivity.class));
             }

             if(listTitle.get(position).equals("Breakfast")){
                 Toast.makeText(getApplication(),"Breakfast", Toast.LENGTH_SHORT).show();
             }

             if(listTitle.get(position).equals("Sandwiches")){
                 Toast.makeText(getApplication(),"Sandwiches", Toast.LENGTH_SHORT).show();
             }

             if(listTitle.get(position).equals("Burgers")){
                 Toast.makeText(getApplication(),"Burgers", Toast.LENGTH_SHORT).show();
             }

             if(listTitle.get(position).equals("Pizzas")){
                 Toast.makeText(getApplication(),"Pizzas", Toast.LENGTH_SHORT).show();
             }

             if(listTitle.get(position).equals("Desserts")){
                 Toast.makeText(getApplication(),"Desserts", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), DessertCategoryActivity.class));
             }

             if(listTitle.get(position).equals("Add in menu")){
                 Toast.makeText(getApplication(),"Add in menu", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), MakeChangesMenuActivity.class));
             }
            }
        });
    }




    public ArrayList<Integer> getListImageId(){

        listId.add(R.drawable.drink);
        listId.add(R.drawable.breakfast);
        listId.add(R.drawable.sandwich);
        listId.add(R.drawable.burger);
        listId.add(R.drawable.pizza2);
        listId.add(R.drawable.dessert);
        listId.add(R.drawable.ic_adding);

        return listId;
    }

    public ArrayList<String> getListTitle(){

        listTitle.add("Drinks");
        listTitle.add("Breakfast");
        listTitle.add("Sandwiches");
        listTitle.add("Burgers");
        listTitle.add("Pizzas");
        listTitle.add("Desserts");
        listTitle.add("Add in menu");

        return listTitle;
    }



}
