package online.klok.mobpos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BillingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bPayCollect;
    private LinearLayout layoutBottom;
    private TextView movingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Billing");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        initialize();
        listener();

        Animation shake = AnimationUtils.loadAnimation(BillingActivity.this, R.anim.shake);
        movingText.startAnimation(shake);
    }


    private void initialize() {
        bPayCollect = (Button) findViewById(R.id.bPayCollect);
        movingText = (TextView) findViewById(R.id.txtMarquee);
        layoutBottom = (LinearLayout) findViewById(R.id.bottom_bar);
    }

    private void listener() {
        bPayCollect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bPayCollect) {
            Intent billingIntent = new Intent(BillingActivity.this, PayCollectActivity.class);
            startActivity(billingIntent);
            overridePendingTransition(R.anim.left_to_right,
                    R.anim.right_to_left);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
        return true;
    }

}
