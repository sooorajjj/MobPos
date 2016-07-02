package online.klok.mobpos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class UserAreaActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Button bChangeStock = (Button) findViewById(R.id.bSettings);
        bChangeStock.setVisibility(View.GONE);

        Button bMasters = (Button) findViewById(R.id.bMasters);
        bMasters.setVisibility(View.GONE);
    }
}