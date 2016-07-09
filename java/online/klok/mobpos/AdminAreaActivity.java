package online.klok.mobpos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdminAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bBilling, bReports, bMasters, bSettings;
    private LinearLayout layoutBottom;
    private TextView movingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Admin Area");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        initialize();
        listener();


        Animation shake = AnimationUtils.loadAnimation(AdminAreaActivity.this, R.anim.shake);
        movingText.startAnimation(shake);
    }

    private void initialize() {
        movingText = (TextView) findViewById(R.id.txtMarquee);
        layoutBottom = (LinearLayout) findViewById(R.id.toolbar_bottom);
        bBilling = (Button) findViewById(R.id.bBilling);
        bReports = (Button) findViewById(R.id.bReports);
        bMasters = (Button) findViewById(R.id.bMasters);
        bSettings = (Button) findViewById(R.id.bSettings);
    }

    private void listener() {
        bBilling.setOnClickListener(this);
        bReports.setOnClickListener(this);
        bMasters.setOnClickListener(this);
        bSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bBilling) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, BillingActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bReports) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, ReportsActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bMasters) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, MastersActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }

        if (v.getId() == R.id.bSettings) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, SettingsActivity.class);
            startActivity(adminIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
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
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }
}