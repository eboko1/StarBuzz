package griffits.fvi.at.ua.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MakeChangesMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_INFO = "mylog";
    private static final int PICK_NAME = 100;
    Uri imageUri;

    private EditText et_name, et_description, et_category;
    private Button btn_add_data_table, btn_delete_data_table, btn_clean_data_table, btn_show_data_table, btn_load_image ;
    private TextView screen;
    private ImageView image_load;

    String name, description, category;

    SQLiteDatabase sqLiteDatabase;

    StarbuzzDatabaseHelper starbuzzDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_changes_menu);
        init();

        btn_add_data_table.setOnClickListener(this);
        btn_delete_data_table.setOnClickListener(this);
        btn_clean_data_table.setOnClickListener(this);
        btn_show_data_table.setOnClickListener(this);
        btn_load_image.setOnClickListener(this);

        starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
    }



    public void getViewToString(){
        category = et_category.getText().toString();
        name = et_name.getText().toString();
        description = et_description.getText().toString();
    }

    public void init(){
        et_name = (EditText)findViewById(R.id.et_name);
        et_description = (EditText)findViewById(R.id.et_description);
        et_category= (EditText)findViewById(R.id.et_category);
        btn_add_data_table = (Button) findViewById(R.id.btn_add_datatable);
        btn_delete_data_table = (Button)findViewById(R.id.btn_delete_datatable);
        btn_clean_data_table = (Button)findViewById(R.id.btn_clean_datatable);
        btn_show_data_table = (Button)findViewById(R.id.btn_show_datatable);
        screen = (TextView)findViewById(R.id.tv_screen);

        btn_load_image = (Button)findViewById(R.id.btn_load_image);
        image_load = (ImageView)findViewById(R.id.image_load);

    }

    @Override
    public void onClick(View v) {
       getViewToString();
        switch (v.getId()){
            case R.id.btn_add_datatable:
                try{
                    starbuzzDatabaseHelper.insertMenu(name, description, 0, category);
                } catch (SQLiteException e){
                    Toast.makeText(this,"MakeChangesMenuActivity error database", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this, "added to database", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete_datatable:
                    starbuzzDatabaseHelper.delete(name);
                    Toast.makeText(this, name + " delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_clean_datatable:
               int cleanCount = sqLiteDatabase.delete("TABMENU", null, null);
                Log.i(LOG_INFO, "onClick button Add in database cleanCount = " + cleanCount);
                break;
            case R.id.btn_show_datatable:
                starbuzzDatabaseHelper.list_all_table(screen);
                break;
            case R.id.btn_load_image:
                openGallery();
                break;
        }

    }

    private void openGallery(){
        Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intentGallery, PICK_NAME );
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RESULT_OK && requestCode == PICK_NAME){
                imageUri = data.getData();
                image_load.setImageURI(imageUri);
        }
    }

}
