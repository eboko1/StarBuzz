package griffits.fvi.at.ua.starbuzz;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import griffits.fvi.at.ua.starbuzz.Menu.Drink;
import griffits.fvi.at.ua.starbuzz.Menu.StarbuzzDatabaseHelper;

public class DrinkDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_NUMBER = "drinkNo" ;
    private static final String LOG_INFO = "mylog";

     private TextView name, description;
     private ImageView photo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_descriotion);

        init();

        int  drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINK_NUMBER);
        Log.i(LOG_INFO, " DrinkDescriptionActivity  drink number click Category ListActivity" + EXTRA_DRINK_NUMBER);

        try {
            SQLiteOpenHelper starbuzzDatebaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatebaseHelper.getReadableDatabase();

            Cursor cursor = db.query("DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkNo)},
                    null, null, null);

        } catch (SQLException e){
            Toast.makeText(getApplicationContext(),"Database unavailable ",Toast.LENGTH_LONG).show();
        }


     /*   //Get the drink from the intent

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
