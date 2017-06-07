package griffits.fvi.at.ua.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

     TextView name, description;
     ImageView photo;
    public static final String EXTRA_DRINKNO = "drinkNo" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        init();

        int  drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        //fill photo
        photo.setImageResource(drink.getImgResId());
      //  photo.setContentDescription(drink.getName());

        //fill text name
        name.setText(drink.getName());

        //fill text  description
        description.setText(drink.getDescription());


    }

    public void init(){
       photo = (ImageView)findViewById(R.id.photo);
       name = (TextView)findViewById(R.id.name);
       description = (TextView)findViewById(R.id.description);
    }
}
