package online.klok.mobpos;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class PayCollectActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_collect);

        // ActionBar Customisations
        actionBar = getSupportActionBar();
        actionBar.setTitle("Klok Innovations");
        actionBar.setSubtitle("Pay Collect");
        actionBar.setLogo(R.drawable.collection_report);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }
}
