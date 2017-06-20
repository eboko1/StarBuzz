package griffits.fvi.at.ua.starbuzz.Menu.desserts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import griffits.fvi.at.ua.starbuzz.R;

public class DessertDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_DESSERT = "dessert";

    private TextView name, description;
    private ImageView photoDessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_description);
        init();

        int positionItemClick = (int) getIntent().getExtras().get(EXTRA_DESSERT);
        Dessert desserts = Dessert.desserts[positionItemClick];


        description.setText(Dessert.desserts[positionItemClick].getDescription());
        name.setText(desserts.getName());
        photoDessert.setImageResource(desserts.getIdResImg());

    }


    private void init(){
        name = (TextView)findViewById(R.id.name_dessert);
        description = (TextView)findViewById(R.id.description_dessert);
        photoDessert = (ImageView)findViewById(R.id.image_dessert);
    }


}
