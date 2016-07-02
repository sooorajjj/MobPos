package online.klok.mobpos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class BillingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);


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
