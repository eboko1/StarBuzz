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
import android.widget.TextView;
import android.widget.Toast;

public class MakeChangesMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_INFO = "mylog";

    private EditText et_name, et_description, et_category;
    private Button btn_add_data_table, btn_delete_data_table, btn_clean_data_table, btn_show_data_table ;
    private TextView screen;

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
        }


    }
}
