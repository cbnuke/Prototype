package com.cbnuke.prototype;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cbnuke.prototype.databinding.ActivityWelcomeBinding;
import com.cbnuke.prototype.model.DataLogin;
import com.cbnuke.prototype.model.StatusLogin;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityWelcomeBinding binding;
    String firebaseToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        binding.btnLogin.setOnClickListener(this);

        //Get token
        firebaseToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("DevCBNUKE", "Token : " + firebaseToken);

        //Data from noti
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d("DevCBNUKE", "Key: " + key + " Value: " + value);
            }
        }
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

        if (pw.isEmpty()) {
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

        String hn = binding.edtHN.getText().toString();
        String pw = binding.edtPass.getText().toString();
        String token = "12354546";
        if (firebaseToken != null && !firebaseToken.isEmpty()) {
            token = firebaseToken;
        } else {
            token = "";
        }

        DataLogin dataLogin = new DataLogin(hn, pw, token);
        CheckLogin checkLogin = new CheckLogin(getApplicationContext());
        checkLogin.execute(dataLogin);
    }

    class CheckLogin extends AsyncTask<DataLogin, Void, StatusLogin> {
        private String defaultIP = "http://10.209.100.43/HostpitalSmartQ/api/login";
        private OkHttpClient okHttpClient = new OkHttpClient();
        private ProgressDialog dialog;
        private ListActivity activity;
        private Context context;

        public CheckLogin(Context activity) {
            context = activity;
            dialog = new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            dialog = new ProgressDialog(getApplicationContext(),
//                    R.style.AppTheme_Dialog);
//            dialog.setIndeterminate(true);
//            dialog.setMessage("Authenticating...");
//            dialog.show();
        }

        @Override
        protected StatusLogin doInBackground(DataLogin... dataLogins) {
            RequestBody formBody = new FormBody.Builder()
                    .add("HN", dataLogins[0].getHW())
                    .add("PW", dataLogins[0].getPW())
                    .add("Token", dataLogins[0].getToken())
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder
                    .url(defaultIP)
                    .post(formBody)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                StatusLogin statusLogin = new StatusLogin();
                if (response.isSuccessful()) {
                    Gson gson = new GsonBuilder().create();
                    try {
                        return gson.fromJson(response.body().string(), StatusLogin.class);
                    } catch (JsonSyntaxException e) {
                        statusLogin.setStatus("fail");
                    }
                } else {
                    statusLogin.setStatus("fail");
                }
                response.close();
                return statusLogin;
            } catch (IOException e) {
                StatusLogin apiLoginStatus = new StatusLogin();
                apiLoginStatus.setStatus("fail");
                return apiLoginStatus;
            }
        }

        @Override
        protected void onPostExecute(StatusLogin statusLogin) {
            super.onPostExecute(statusLogin);
            if (!statusLogin.getStatus().isEmpty() && statusLogin.getStatus().equalsIgnoreCase("success")) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(getApplication(), "Login failed", Toast.LENGTH_SHORT).show();
                binding.btnLogin.setEnabled(true);
            }
//            dialog.dismiss();
        }
    }

}
