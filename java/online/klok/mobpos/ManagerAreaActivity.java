package online.klok.mobpos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ManagerAreaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        Button bBilling = (Button) findViewById(R.id.bBilling);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Billing");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        bBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(ManagerAreaActivity.this, BillingActivity.class);
                ManagerAreaActivity.this.startActivity(adminIntent);
            }
        });

        Button bReports = (Button) findViewById(R.id.bReports);
        bReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(ManagerAreaActivity.this, ReportsActivity.class);
                ManagerAreaActivity.this.startActivity(adminIntent);
            }
        });
        Button bMasters = (Button) findViewById(R.id.bMasters);
        bMasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(ManagerAreaActivity.this, MastersActivity.class);
                ManagerAreaActivity.this.startActivity(adminIntent);
            }
        });

        Button bChangeStock = (Button) findViewById(R.id.bSettings);
        bChangeStock.setVisibility(View.GONE);

    }
}