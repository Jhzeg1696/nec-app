package com.example.necapp.ui.registro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.necapp.R;
import com.example.necapp.databinding.FragmentRegistroBinding;
import com.example.necapp.ui.registro.RegistroViewModel;

public class RegistroFragment extends Fragment {

    private RegistroViewModel registroViewModel;
    private FragmentRegistroBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroViewModel =
                new ViewModelProvider(this).get(RegistroViewModel.class);

        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.titulo;
        registroViewModel.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}