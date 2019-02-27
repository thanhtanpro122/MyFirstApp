package hcmute.edu.vn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *Dùng để hiển thị username người dùng
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtHello = findViewById(R.id.txtHello);
        String username = getIntent().getStringExtra("USRENAME");
        txtHello.setText(String.format("Xin chào %s", username));
    }
}
