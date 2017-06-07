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

        //add photo
        //photo.setImageResource(drink.getImgResId());
      //  photo.setContentDescription(drink.getName());
        

    }

    public void init(){
        ImageView photo = (ImageView)findViewById(R.id.photo);
        TextView name = (TextView)findViewById(R.id.name);
        TextView description = (TextView)findViewById(R.id.description);
    }
}
