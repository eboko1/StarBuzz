package griffits.fvi.at.ua.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import griffits.fvi.at.ua.starbuzz.Menu.dessert.DessertCategoryActivity;
import griffits.fvi.at.ua.starbuzz.Menu.drinks.DrinkCategoryActivity;

public class TopLevelActivity extends AppCompatActivity {

    private ListView listViewOption;

    int [] imagesMenu = {R.drawable.drink,
                            R.drawable.breakfast,
                            R.drawable.sandwich,
                            R.drawable.burger,
                            R.drawable.pizza2,
                            R.drawable.dessert,
                            R.drawable.ic_adding};

    String[] titlesMenu = { "Drinks",
                            "Breakfast",
                            "Sandwiches",
                            "Burgers",
                            "Pizzas",
                            "Desserts",
                            "Add in menu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        init();


        AdapterView.OnItemClickListener itemClList = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             if(position == 0){
                 Toast.makeText(getApplication(),"Drinks", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), DrinkCategoryActivity.class));
             } else if(position == 1){
                  Toast.makeText(getApplication(),"Breakfast", Toast.LENGTH_SHORT).show();
             }else if(position == 2){
                 Toast.makeText(getApplication(),"Sandwiches", Toast.LENGTH_SHORT).show();
             } else if(position == 3){
                 Toast.makeText(getApplication(),"Burgers", Toast.LENGTH_SHORT).show();
             } else if(position == 4){
                 Toast.makeText(getApplication(),"Pizzas", Toast.LENGTH_SHORT).show();
             } else if(position == 5) {
                 Toast.makeText(getApplication(), "Desserts", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), DessertCategoryActivity.class));
             } else if(position == 6){
                 Toast.makeText(getApplication(),"Specials", Toast.LENGTH_SHORT).show();
             } else if(position == 7){
                 Toast.makeText(getApplication(),"Add in menu", Toast.LENGTH_SHORT).show();
                 onClickAddToMenu();
             }
            }
        };

        listViewOption.setOnItemClickListener(itemClList);


    }

    public void  init(){
        listViewOption  = (ListView)findViewById(R.id.list_options);
    }

    public void onClickAddToMenu(){
        startActivity(new Intent(this, MakeChangesMenuActivity.class));
    }

}
