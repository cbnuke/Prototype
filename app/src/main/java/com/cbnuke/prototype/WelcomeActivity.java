package com.cbnuke.prototype;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cbnuke.prototype.databinding.ActivityWelcomeBinding;
import com.cbnuke.prototype.model.DataLogin;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnLogin.getId()) {
//            startActivity(new Intent(this, MainActivity.class));
            login();
        }
    }

    public boolean validate() {
        boolean valid = true;

        String hn = binding.edtHN.getText().toString();
        String pw = binding.edtPass.getText().toString();

        if (hn.isEmpty()) {
            binding.edtHN.setError("enter a valid HN");
            valid = false;
        } else {
            binding.edtHN.setError(null);
        }

        if (pw.isEmpty() || pw.length() == 13) {
            binding.edtPass.setError("length 13 characters");
            valid = false;
        } else {
            binding.edtPass.setError(null);
        }

        return valid;
    }

    public void login() {

        if (!validate()) {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
            binding.btnLogin.setEnabled(true);
            return;
        }

        binding.btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String hn = binding.edtHN.getText().toString();
        String pw = binding.edtPass.getText().toString();
        String token = "12354546";

        DataLogin dataLogin = new DataLogin(hn, pw, token);
        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    class CheckLogin extends AsyncTask<DataLogin, Void, Void> {

        @Override
        protected Void doInBackground(DataLogin... dataLogins) {
            return null;
        }
    }

}
