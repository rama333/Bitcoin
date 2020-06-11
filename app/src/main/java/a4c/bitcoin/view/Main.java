package a4c.bitcoin.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import a4c.bitcoin.R;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Ramil on 25.08.2017.
 */

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.main);

        Handler handler = new Handler();

        handler.postDelayed((Runnable) () -> {
            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
