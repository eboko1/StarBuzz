package griffits.fvi.at.ua.starbuzz.Menu.breakfast;

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

import griffits.fvi.at.ua.starbuzz.R;
import griffits.fvi.at.ua.starbuzz.StarbuzzDatabaseHelper;

public class BreakfastDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_BREAKFAST_NUMBER = "breakfastNumber";
    private static final String LOG_INFO = "mylog";

    private TextView name, description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_description);

            init();

            int  breakfastNumber = (Integer)getIntent().getExtras().get(EXTRA_BREAKFAST_NUMBER);
            Log.i(LOG_INFO, " number click Category ListActivity" + EXTRA_BREAKFAST_NUMBER);

            try {
                SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
                SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();

                Cursor cursor = db.query ("TABMENU",
                        new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "CATEGORY"},
                        "_id = ?",
                        new String[] {Integer.toString(breakfastNumber)},
                        null, null, null);

                if (cursor.moveToFirst()) {
                    String nameText = cursor.getString(0);
                    String descriptionText = cursor.getString(1);
                    int photoText = cursor.getInt(2);

                    name.setText(nameText);
                    description.setText(descriptionText);
                    image.setImageResource(photoText);

                    image.setContentDescription(nameText);
                    cursor.close();
                    db.close();
                }

            } catch (SQLException e){
                Toast.makeText(getApplicationContext(), "  BreakfastDescriptionActivity  Database unavailable ", Toast.LENGTH_LONG).show();
            }
        }

    public void init(){
        image = (ImageView)findViewById(R.id.photo);
        name = (TextView)findViewById(R.id.name);
        description = (TextView)findViewById(R.id.description);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

