package online.klok.mobpos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bBilling;
    private Button bReports;
    private Button bMasters;
    private Button bSettings;
    private Toolbar toolbarBottom;

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

        initilize();
        listener();

        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.phone:
                        Toast.makeText(getBaseContext(), "You selected Phone", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.computer:
                        Toast.makeText(getBaseContext(), "You selected Computer", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gamepad:
                        Toast.makeText(getBaseContext(), "You selected Gamepad", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.camera:
                        Toast.makeText(getBaseContext(), "You selected camera", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.video:
                        Toast.makeText(getBaseContext(), "You selected video", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.email:
                        Toast.makeText(getBaseContext(), "You selected email", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    private void initilize() {
        toolbarBottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        assert toolbarBottom != null;
        toolbarBottom.inflateMenu(R.menu.main);
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
        }

        if (v.getId() == R.id.bReports) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, ReportsActivity.class);
            startActivity(adminIntent);
        }

        if (v.getId() == R.id.bMasters) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, MastersActivity.class);
            startActivity(adminIntent);
        }

        if (v.getId() == R.id.bSettings) {
            Intent adminIntent = new Intent(AdminAreaActivity.this, SettingsActivity.class);
            startActivity(adminIntent);
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