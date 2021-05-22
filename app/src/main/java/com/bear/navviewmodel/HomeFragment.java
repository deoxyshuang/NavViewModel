package com.bear.navviewmodel;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.bear.navviewmodel.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.button.setOnClickListener(view -> {
            NavController controller = Navigation.findNavController(view);
            controller.navigate(R.id.action_homeFragment_to_detailFragment);
        });
        binding.seekBar.setProgress(myViewModel.getNumber().getValue());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myViewModel.getNumber().setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return binding.getRoot();

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}