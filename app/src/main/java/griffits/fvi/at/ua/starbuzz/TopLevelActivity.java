package griffits.fvi.at.ua.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

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
                 startActivity( new Intent(getApplicationContext(), DrinkCategoryActivity.class));
             }
            }
        };

        listViewOption.setOnItemClickListener(itemClList);


    }

    public void  init(){
        listViewOption  = (ListView)findViewById(R.id.list_options);

    }


}
