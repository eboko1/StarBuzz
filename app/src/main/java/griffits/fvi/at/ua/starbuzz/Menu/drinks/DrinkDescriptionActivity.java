package griffits.fvi.at.ua.starbuzz.Menu.drinks;

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

import griffits.fvi.at.ua.starbuzz.StarbuzzDatabaseHelper;
import griffits.fvi.at.ua.starbuzz.R;

public class DrinkDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_NUMBER = "drinkNumber" ;
    private static final String LOG_INFO = "mylog";

     private TextView name, description;
     private ImageView photo;

     private Cursor cursor;
     private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_description);

        init();

        int  drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINK_NUMBER);
        Log.i(LOG_INFO, " DrinkDescriptionActivity  drink number click Category ListActivity" + EXTRA_DRINK_NUMBER);

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkNo)},
                    null, null,null);

          if (cursor.moveToFirst()) {
              String nameText = cursor.getString(0);
              String descriptionText = cursor.getString(1);
              int photoText = cursor.getInt(2);

              name.setText(nameText);
              description.setText(descriptionText);
              photo.setImageResource(photoText);

              photo.setContentDescription(nameText);
              cursor.close();
              db.close();
          }


        } catch (SQLException e){
            Toast.makeText(getApplicationContext(), "Database unavailable ", Toast.LENGTH_LONG).show();
        }
    }

    public void init(){
       photo = (ImageView)findViewById(R.id.photo);
       name = (TextView)findViewById(R.id.name);
       description = (TextView)findViewById(R.id.description);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
