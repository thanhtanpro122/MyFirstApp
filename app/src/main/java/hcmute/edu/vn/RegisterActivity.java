package hcmute.edu.vn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity nay dung de xu ly dang ky nguoi dung
 */
public class RegisterActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPass;
    EditText edtConfirm;
    EditText edtEmail;
    EditText edtPhone;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        onInit();
    }

    /**
     * Ham nay khoi tao control
     */
    private void onInit() {
        edtUsername = findViewById(R.id.plUsername);
        edtPass = findViewById(R.id.plPassWord);
        edtConfirm= findViewById(R.id.plConfirmPass);
        edtEmail= findViewById(R.id.plEmail);
        edtPhone= findViewById(R.id.plPhone);
        btnSignUp= findViewById(R.id.btnSignUp);

        // Regular expression kiem tra so dien thoai hop le
        final String regexStr = "^[0-9]{10}$";

        // Xu ly su kien click cho button btnSignUp
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Tên đăng nhập là bắt buộc!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtPass.getText().toString().trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu là bắt buộc!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!edtPass.getText().toString().trim().equals(edtConfirm.getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Nhập lại mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = edtEmail.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Email không hợp lệ!",Toast.LENGTH_SHORT).show();
                    return;
                }

                String number = edtPhone.getText().toString().trim();
                if(!number.matches(regexStr)){
                    Toast.makeText(getApplicationContext(),"Số điện thoại không hợp lệ!",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("USRENAME", edtUsername.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}
