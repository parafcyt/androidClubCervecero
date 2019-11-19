package com.example.clubcerveceromona.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.view.fragments.BuscarFragment;
import com.example.clubcerveceromona.view.fragments.CasitaFragment;
import com.example.clubcerveceromona.view.fragments.PerfilFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        BottomBar bottomBar= findViewById(R.id.bottom_bar);



        //instancio casitafragment y lo agrego al frame x defecto
        CasitaFragment casitaFragment = new CasitaFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, casitaFragment).commit();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();


                switch (tabId){

                    case R.id.tab_casita:
                        CasitaFragment casitaFragment= new CasitaFragment();
                        transaction.replace(R.id.container, casitaFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_buscar:
                        BuscarFragment buscarFragment= new BuscarFragment();
                        transaction.replace(R.id.container, buscarFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_perfil:
                        PerfilFragment perfilFragment= new PerfilFragment();
                        transaction.replace(R.id.container, perfilFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                }
            }


        });


    }
}
