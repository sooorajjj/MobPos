package online.klok.mobpos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class AdminAreaActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Button bBilling = (Button) findViewById(R.id.bBilling);
        bBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(AdminAreaActivity.this, BillingActivity.class);
                AdminAreaActivity.this.startActivity(adminIntent);
            }
        });

        Button bReports = (Button) findViewById(R.id.bReports);
        bReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(AdminAreaActivity.this, ReportsActivity.class);
                AdminAreaActivity.this.startActivity(adminIntent);
            }
        });
        Button bMasters = (Button) findViewById(R.id.bMasters);
        bMasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(AdminAreaActivity.this, MastersActivity.class);
                AdminAreaActivity.this.startActivity(adminIntent);
            }
        });
        Button bSettings = (Button) findViewById(R.id.bSettings);
        bSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(AdminAreaActivity.this, SettingsActivity.class);
                AdminAreaActivity.this.startActivity(adminIntent);
            }
        });


  }
}