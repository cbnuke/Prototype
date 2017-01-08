package com.cbnuke.prototype;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbnuke.prototype.databinding.FragmentAboutBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    FragmentAboutBinding binding;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false);

        MainActivity.binding.appBaryLayout.setExpanded(true);
        MainActivity.binding.imageParallax.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.kku33));
        MainActivity.binding.imageParallax.setVisibility(View.VISIBLE);
        MainActivity.binding.fab.setVisibility(View.GONE);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity.binding.fab.setVisibility(View.VISIBLE);
    }
}
