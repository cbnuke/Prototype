package com.cbnuke.prototype;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbnuke.prototype.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        //Control nav and app
        MainActivity.binding.appBaryLayout.setExpanded(false);
        MainActivity.binding.imageParallax.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.kku));
        MainActivity.binding.imageParallax.setVisibility(View.GONE);
        MainActivity.binding.fab.setVisibility(View.GONE);
        return binding.getRoot();
    }

}
