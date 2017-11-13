package com.nextu.sacc.evaluacionfinal_modulo6;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Crea las opciones del submenú
        // Versión Web
        SubMenu subMenuVersionWeb = menu.addSubMenu(0, 1, 1, R.string.tab_versionweb);
        subMenuVersionWeb.add(0, 2, 1, R.string.facebook).setIcon(R.drawable.tab_facebook);
        subMenuVersionWeb.add(0, 3, 2, R.string.instagram).setIcon(R.drawable.tab_instagram);
        subMenuVersionWeb.add(0, 4, 3, R.string.google_plus).setIcon(R.drawable.tab_googleplus);
        subMenuVersionWeb.add(0, 5, 4, R.string.twitter).setIcon(R.drawable.tab_twitter);

        // Compartir
        SubMenu subMenuCompatir = menu.addSubMenu(1, 6, 1, R.string.compartir);

        // Configuración
        SubMenu subMenuConfiguracion = menu.addSubMenu(2, 7, 1, R.string.configuracion);

        // Infla
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Log.wtf("MENSAJE", "onOptionsItemSelected: " + id);

        switch (id){
            case 2: // Versión web - Facebook
                break;

            case 3: // Versión web - Instagram
                break;

            case 4: // Versión web - Google Plus
                break;

            case 5: // Versión web - Twitter
                break;

            case 6: // Compartir
                // Muestra dialogo
                Dialogo.CompartirPublicacion(this, null).show();
                break;

            case 7: // Configuración
                break;

        }

        return super.onOptionsItemSelected(item);
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
