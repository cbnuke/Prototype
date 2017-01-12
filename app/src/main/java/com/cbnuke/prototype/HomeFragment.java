package com.cbnuke.prototype;


import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cbnuke.prototype.databinding.FragmentHomeBinding;
import com.cbnuke.prototype.model.DataLogin;
import com.cbnuke.prototype.model.StatusLogin;
import com.cbnuke.prototype.model.StatusPatient;
import com.cbnuke.prototype.model.StatusQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    FragmentHomeBinding binding;
    DataLogin dataLogin;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        binding.tbQueue.setOnClickListener(this);
        binding.tbApp.setOnClickListener(this);

        //Control nav and app
        MainActivity.binding.appBaryLayout.setExpanded(false);
        MainActivity.binding.imageParallax.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.kku));
        MainActivity.binding.imageParallax.setVisibility(View.GONE);
        MainActivity.binding.fab.setVisibility(View.GONE);

        String HN = MainActivity.sp.getString("HN", null);
        String PW = MainActivity.sp.getString("PW", null);
        String Token = MainActivity.sp.getString("Token", null);

        dataLogin = new DataLogin(HN, PW, Token);
        CheckPatient checkPatient = new CheckPatient();
        checkPatient.execute(dataLogin);

        //Config RecyclerView
        mRecyclerView = binding.rv;
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.tbApp.getId()) {
            binding.tbApp.setChecked(true);
            binding.tbQueue.setChecked(false);

        } else if (view.getId() == binding.tbQueue.getId()) {
            binding.tbApp.setChecked(false);
            binding.tbQueue.setChecked(true);
            loadQueue();
        }
    }

    public void loadQueue() {
        CheckQueue checkQueue = new CheckQueue();
        checkQueue.execute(dataLogin);
    }

    class CheckQueue extends AsyncTask<DataLogin, Void, StatusQueue> {
        private String defaultIP = "http://10.209.100.43/HostpitalSmartQ/api/queue";
        private OkHttpClient okHttpClient = new OkHttpClient();

        @Override
        protected StatusQueue doInBackground(DataLogin... dataLogins) {
            RequestBody formBody = new FormBody.Builder()
                    .add("HN", dataLogins[0].getHW())
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder
                    .url(defaultIP)
                    .post(formBody)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                StatusQueue statusQueue = new StatusQueue();
                if (response.isSuccessful()) {
                    Gson gson = new GsonBuilder().create();
                    try {
                        return gson.fromJson(response.body().string(), StatusQueue.class);
                    } catch (JsonSyntaxException e) {
                        statusQueue.setStatus("fail");
                    }
                } else {
                    statusQueue.setStatus("fail");
                }
                response.close();
                return statusQueue;
            } catch (IOException e) {
                StatusQueue statusQueue = new StatusQueue();
                statusQueue.setStatus("fail");
                return statusQueue;
            }
        }

        @Override
        protected void onPostExecute(StatusQueue statusQueue) {
            super.onPostExecute(statusQueue);
            if (!statusQueue.getStatus().isEmpty() && statusQueue.getStatus().equalsIgnoreCase("success")) {
                mAdapter = new QueueAdapter(getContext(), statusQueue.getData());
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }

    class CheckPatient extends AsyncTask<DataLogin, Void, StatusPatient> {
        private String defaultIP = "http://10.209.100.43/HostpitalSmartQ/api/patient";
        private OkHttpClient okHttpClient = new OkHttpClient();

        @Override
        protected StatusPatient doInBackground(DataLogin... dataLogins) {
            RequestBody formBody = new FormBody.Builder()
                    .add("HN", dataLogins[0].getHW())
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder
                    .url(defaultIP)
                    .post(formBody)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                StatusPatient statusPatient = new StatusPatient();
                if (response.isSuccessful()) {
                    Gson gson = new GsonBuilder().create();
                    try {
                        return gson.fromJson(response.body().string(), StatusPatient.class);
                    } catch (JsonSyntaxException e) {
                        statusPatient.setStatus("fail");
                    }
                } else {
                    statusPatient.setStatus("fail");
                }
                response.close();
                return statusPatient;
            } catch (IOException e) {
                StatusPatient statusPatient = new StatusPatient();
                statusPatient.setStatus("fail");
                return statusPatient;
            }
        }

        @Override
        protected void onPostExecute(StatusPatient statusPatient) {
            super.onPostExecute(statusPatient);
            if (!statusPatient.getStatus().isEmpty() && statusPatient.getStatus().equalsIgnoreCase("success")) {
                binding.txtHN.setText("HN : " + statusPatient.getData().getPat_hn());
                binding.txtName.setText(statusPatient.getData().getPat_firstname() + " " + statusPatient.getData().getPat_lastname());
                binding.txtAge.setText("Age " + statusPatient.getData().getPat_age());
                binding.txtTel.setText("Tel " + statusPatient.getData().getPat_tel());
            }
        }
    }

}
