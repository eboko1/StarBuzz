package griffits.fvi.at.ua.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DessertDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_DESERT = "desert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_description);
    }
}
