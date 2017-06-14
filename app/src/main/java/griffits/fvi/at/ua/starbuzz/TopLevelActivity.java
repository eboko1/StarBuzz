package griffits.fvi.at.ua.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {

    private ListView listViewOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        init();


        AdapterView.OnItemClickListener itemClList = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             if(position == 0){
                 Toast.makeText(getApplication(),"Drinks", Toast.LENGTH_LONG).show();
                 startActivity(new Intent(getApplicationContext(), DrinkCategoryActivity.class));
             } else if(position == 1){
                 Toast.makeText(getApplication(),"Desserts ", Toast.LENGTH_LONG).show();
                 startActivity(new Intent(getApplicationContext(), DessertCategoryActivity.class));
             } else if(position == 2){
                  Toast.makeText(getApplication(),"Foods ", Toast.LENGTH_LONG).show();
             }else if(position == 3){
                 Toast.makeText(getApplication(),"Stores ", Toast.LENGTH_LONG).show();
             }
            }
        };

        listViewOption.setOnItemClickListener(itemClList);


    }

    public void  init(){
        listViewOption  = (ListView)findViewById(R.id.list_options);

    }


}
