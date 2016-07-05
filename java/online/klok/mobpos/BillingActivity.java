package online.klok.mobpos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class BillingActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        // ActionBar Customisations
        actionBar = getSupportActionBar();
            actionBar.setTitle("Klok Innovations");
            actionBar.setSubtitle("Billing");
            actionBar.setLogo(R.drawable.collection_report);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);


        Button bPayCollect = (Button) findViewById(R.id.bPayCollect);
        bPayCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent billingIntent = new Intent(BillingActivity.this, PayCollectActivity.class);
                BillingActivity.this.startActivity(billingIntent);
            }
        });


    }
}
