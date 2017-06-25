package griffits.fvi.at.ua.starbuzz.Menu.drinks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import griffits.fvi.at.ua.starbuzz.MakeChangesMenuActivity;
import griffits.fvi.at.ua.starbuzz.StarbuzzDatabaseHelper;
import griffits.fvi.at.ua.starbuzz.R;

public class DrinkDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_NUMBER = "drinkNumber" ;
    private static final String LOG_INFO = "mylog";

     private TextView name, description;
     private ImageView photo;
     private CheckBox favorite;



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

            Cursor cursor = db.query ("TABMENU",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "CATEGORY", "FAVORITE"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkNo)},
                    null, null,null);

          if (cursor.moveToFirst()) {
              String nameText = cursor.getString(0);
              String descriptionText = cursor.getString(1);
              int image = cursor.getInt(2);
              boolean isFavorite = (cursor.getInt(3) == 1);

              name.setText(nameText);
              description.setText(descriptionText);
              photo.setImageResource(image);
              photo.setContentDescription(nameText);
              favorite.setChecked(isFavorite);

              cursor.close();
              db.close();
          }

        } catch (SQLException e){
            Toast.makeText(getApplicationContext(), "DrinkDescriptionActivity  Database unavailable ", Toast.LENGTH_LONG).show();
        }
    }

    public void init(){
       photo = (ImageView)findViewById(R.id.photo);
       name = (TextView)findViewById(R.id.name);
       description = (TextView)findViewById(R.id.description);
       favorite = (CheckBox)findViewById(R.id.favorite);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void onClickFavorite(){
        int drinkNumber = (Integer)getIntent().getExtras().get("drinkNumber");
        ContentValues contentValues = new ContentValues();
        contentValues.put("FAVORITE", favorite.isChecked());

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            db.update("TABMENU", contentValues, "_id = ?", new String[]{Integer.toString(drinkNumber)});
            db.close();
        } catch (SQLiteException e){
        } catch (SQLException e){
            Toast.makeText(getApplicationContext(), "DrinkDescriptionActivity onClickFavorite()  Database unavailable ", Toast.LENGTH_LONG).show();
        }
    }

}
