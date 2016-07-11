package online.klok.mobpos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PayCollectActivity extends AppCompatActivity {

    private LinearLayout layoutBottom;
    private TextView movingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_collect);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("PayCollect");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        initialize();
        listener();

        Animation shake = AnimationUtils.loadAnimation(PayCollectActivity.this, R.anim.shake);
        movingText.startAnimation(shake);
    }

    private void initialize() {
        layoutBottom = (LinearLayout) findViewById(R.id.bottom_bar);
        movingText = (TextView) findViewById(R.id.txtMarquee);

    }

    private void listener() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
        return true;
    }
}
