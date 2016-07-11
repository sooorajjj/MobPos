package online.klok.mobpos;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ManagerAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bBilling, bReports, bMasters, bChangeStock;
    private LinearLayout layoutBottom;
    private TextView movingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Manager Area");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        initialize();
        listener();

        bChangeStock.setVisibility(View.GONE);

        Animation shake = AnimationUtils.loadAnimation(ManagerAreaActivity.this, R.anim.shake);
        movingText.startAnimation(shake);

    }

    private void initialize() {
        movingText = (TextView) findViewById(R.id.txtMarquee);
        layoutBottom = (LinearLayout) findViewById(R.id.bottom_bar);
        bBilling = (Button) findViewById(R.id.bBilling);
        bReports = (Button) findViewById(R.id.bReports);
        bMasters = (Button) findViewById(R.id.bMasters);
        bChangeStock = (Button) findViewById(R.id.bSettings);
    }

    private void listener() {
        bBilling.setOnClickListener(this);
        bReports.setOnClickListener(this);
        bMasters.setOnClickListener(this);
        bChangeStock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bBilling) {
            Intent adminIntent = new Intent(ManagerAreaActivity.this, BillingActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bReports) {
            Intent adminIntent = new Intent(ManagerAreaActivity.this, ReportsActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bMasters) {
            Intent adminIntent = new Intent(ManagerAreaActivity.this, MastersActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bSettings) {

        }
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