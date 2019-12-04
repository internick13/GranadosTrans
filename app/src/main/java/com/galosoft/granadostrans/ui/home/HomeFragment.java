package com.galosoft.granadostrans.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.galosoft.granadostrans.Home;
import com.galosoft.granadostrans.R;
import com.galosoft.granadostrans.WelcomeChat;
import com.galosoft.granadostrans.WelcomeContacto;
import com.galosoft.granadostrans.WelcomeNosotros;
import com.galosoft.granadostrans.WelcomeUnidades;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView chat, nosotros, unidades, contacto;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        chat = root.findViewById(R.id.chat);
        nosotros = root.findViewById(R.id.us);
        unidades = root.findViewById(R.id.unidades);
        contacto = root.findViewById(R.id.contact);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeChat.class));
            }
        });

        nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeNosotros.class));
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeContacto.class));
            }
        });

        unidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeUnidades.class));
            }
        });

        return root;
    }
}











