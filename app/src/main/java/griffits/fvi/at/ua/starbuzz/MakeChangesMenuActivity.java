package griffits.fvi.at.ua.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MakeChangesMenuActivity extends AppCompatActivity {
    private EditText et_name, et_description, et_category;
    private Button btn_add_data_table, btn_delete_data_table;

    public static final String EXTRA_MAKE_NUMBER = "make_num" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_changes_menu);
        init();


    }








    public void init(){
        et_name = (EditText)findViewById(R.id.et_name);
        et_description = (EditText)findViewById(R.id.et_description);
        et_category= (EditText)findViewById(R.id.et_category);
        btn_add_data_table = (Button) findViewById(R.id.btn_add_datatable);
        btn_delete_data_table = (Button)findViewById(R.id.btn_delete_datatable);
    }
}
