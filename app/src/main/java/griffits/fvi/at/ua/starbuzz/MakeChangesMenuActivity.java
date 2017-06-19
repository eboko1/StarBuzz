package griffits.fvi.at.ua.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MakeChangesMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_INFO = "mylog";

    private EditText et_name, et_description, et_category;
    private Button btn_add_data_table, btn_delete_data_table, btn_clean_data_table ;


    String name, description, category;

    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_changes_menu);
        init();

        btn_add_data_table.setOnClickListener(this);
        btn_delete_data_table.setOnClickListener(this);
        btn_clean_data_table.setOnClickListener(this);

        sqLiteOpenHelper = new StarbuzzDatabaseHelper(this);

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

    }

    @Override
    public void onClick(View v) {

        try{
           sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        } catch (SQLiteException e){
            Toast.makeText(this,"MakeChangesMenuActivity error database", Toast.LENGTH_SHORT).show();
        }

        getViewToString();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()){
            case R.id.btn_add_datatable:
                contentValues.put("CATEGORY", category);
                contentValues.put("NAME", name);
                contentValues.put("DESCRIPTION", description);
                long numberId = sqLiteDatabase.insert("DRINK", null, contentValues);
                Log.i(LOG_INFO, "onClick button Add in database number id = " + numberId);
                break;

            case R.id.btn_delete_datatable:

                break;
            case R.id.btn_clean_datatable:
               int cleanCount = sqLiteDatabase.delete("DRINK", null, null);
                Log.i(LOG_INFO, "onClick button Add in database cleanCount = " + cleanCount);
                break;
        }


    }
}