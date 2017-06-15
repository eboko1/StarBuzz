package griffits.fvi.at.ua.starbuzz;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import griffits.fvi.at.ua.starbuzz.Menu.Drink;
import griffits.fvi.at.ua.starbuzz.Menu.StarbuzzDatabaseHelper;

public class DrinkDescriptionActivity extends AppCompatActivity {

     TextView name, description;
     ImageView photo;

    public static final String EXTRA_DRINKNO = "drinkNo" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_descriotion);

        init();

        try {
            SQLiteOpenHelper starbuzzDatebaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatebaseHelper.getReadableDatabase();

        } catch (SQLException e){

        }


     /*   //Get the drink from the intent
        int  drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        //Populate the drink image
        photo.setImageResource(drink.getImgResId());
      // photo.setContentDescription(drink.getName());

        //fill text name
        name.setText(drink.getName());

        //fill text  description
        description.setText(drink.getDescription());*/




    }

    public void init(){
       photo = (ImageView)findViewById(R.id.photo);
       name = (TextView)findViewById(R.id.name);
       description = (TextView)findViewById(R.id.description);
    }
}
