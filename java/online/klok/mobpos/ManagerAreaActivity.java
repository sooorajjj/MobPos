package online.klok.mobpos;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Manager Area");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        bBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent managerIntent = new Intent(ManagerAreaActivity.this, BillingActivity.class);
                ManagerAreaActivity.this.startActivity(managerIntent);
                overridePendingTransition(R.anim.left_to_right,
                        R.anim.right_to_left);
            }
        });

        Button bReports = (Button) findViewById(R.id.bReports);
        bReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent managerIntent = new Intent(ManagerAreaActivity.this, ReportsActivity.class);
                ManagerAreaActivity.this.startActivity(managerIntent);
                overridePendingTransition(R.anim.left_to_right,
                        R.anim.right_to_left);
            }
        });
        Button bMasters = (Button) findViewById(R.id.bMasters);
        bMasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent managerIntent = new Intent(ManagerAreaActivity.this, MastersActivity.class);
                ManagerAreaActivity.this.startActivity(managerIntent);
                overridePendingTransition(R.anim.left_to_right,
                        R.anim.right_to_left);
            }
        });

        Button bChangeStock = (Button) findViewById(R.id.bSettings);
        bChangeStock.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                finish();
                                overridePendingTransition(R.anim.fade_in,
                                        R.anim.fade_out);
                            }
                        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create();
        builder.show();
    }
}