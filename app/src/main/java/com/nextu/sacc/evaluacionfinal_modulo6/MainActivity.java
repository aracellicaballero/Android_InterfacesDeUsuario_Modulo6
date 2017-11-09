package com.nextu.sacc.evaluacionfinal_modulo6;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import fragment.ConTabsFragment;
import fragment.SinTabsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    int idItem;
    DrawerLayout drawerLayout;

    public int getIdItem() {
        return idItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Busca el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Reemplaza el toolbar por el actionbar
        setSupportActionBar(toolbar);

        // Busca el drawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Listener para el drawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);

        // Asigna el listener al drawerLayout
        drawerLayout.addDrawerListener(toggle);

        // Sincroniza el estado
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }

        // Muestra el fragmento inicial
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SinTabsFragment())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Identificador del elemento seleccionado
        idItem = item.getItemId();
        View view = findViewById(R.id.nav_encabezado);

        // Color según la selección
        int color = 0;
        // Fragmento que debe mostrarse
        Fragment fragment = null;

        // Acción según el elemento seleccionado.
        switch (idItem){
            case R.id.nav_home:
                color = getResources().getColor(R.color.colorHome);
                fragment = new SinTabsFragment();
                break;

            case R.id.nav_facebook:
                color = getResources().getColor(R.color.colorFacebook);
                fragment = new ConTabsFragment();
                break;

            case R.id.nav_instagram:
                color = getResources().getColor(R.color.colorInstagram);
                fragment = new ConTabsFragment();
                break;

            case R.id.nav_googleplus:
                color = getResources().getColor(R.color.colorGooglePlus);
                fragment = new ConTabsFragment();
                break;

            case R.id.nav_twitter:
                color = getResources().getColor(R.color.colorTwitter);
                fragment = new ConTabsFragment();
                break;

        }

        // Asigna el color al cajón según la selección
        view.setBackgroundColor(color);

        // Muestra el fragmento según la selección
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        // Cierra el drawer cuando se selecciona una de las opciones
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void updateView(String titulo, String subtitulo, int color) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            toolbar.setTitle(titulo);
            toolbar.setSubtitle(subtitulo);
            toolbar.setBackgroundColor(getResources().getColor(color));
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
