package online.klok.mobpos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class ManagerAreaActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        Button bBilling = (Button) findViewById(R.id.bBilling);
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

        Button bChangeStock = (Button) findViewById(R.id.bSettings);
        bChangeStock.setVisibility(View.GONE);

    }
}