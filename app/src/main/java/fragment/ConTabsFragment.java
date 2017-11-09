package fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nextu.sacc.evaluacionfinal_modulo6.MainActivity;
import com.nextu.sacc.evaluacionfinal_modulo6.R;

import adaptador.BaseViewPagerAdapter;

public class ConTabsFragment extends Fragment {

    int idItem;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_con_tabs, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();

        // Item seleccionado.
        idItem = activity.getIdItem();

        // ImageView de fondo de cada pantalla
        ImageView imageView = (ImageView) activity.findViewById(R.id.img_principal);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        if(viewPager != null) {
            viewPager.setAdapter(new BaseViewPagerAdapter(getActivity().getSupportFragmentManager(), getContext(), idItem));
        }

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            tabLayout.setBackgroundColor(getResources().getColor(colorSegunSeleccion(idItem)));
            // Imagen del tab
            TabLayout.Tab tab = null;
            Drawable icono = null;

            switch (idItem){
                case R.id.nav_facebook:
                    for (int i = 0; i < tabLayout.getTabCount(); i++){
                        tab = tabLayout.getTabAt(i);
                        switch (i){
                            case 0:
                                icono = ContextCompat.getDrawable(activity, R.drawable.fb_noticias);
                                break;
                            case 1:
                                icono = ContextCompat.getDrawable(activity, R.drawable.fb_solicitudes);
                                break;
                            case 2:
                                icono = ContextCompat.getDrawable(activity, R.drawable.fb_web);
                                break;
                        }
                        if (tab != null) {
                            tab.setIcon(icono); // Se le asigna el ícono.
                            tab.setText(null);  // Para que no muestre texto, solamente la imagen.
                        }
                    }
                    break;

                case R.id.nav_instagram:
                    for (int i = 0; i < tabLayout.getTabCount(); i++){
                        tab = tabLayout.getTabAt(i);
                        switch (i){
                            case 0:
                                icono = ContextCompat.getDrawable(activity, R.drawable.ig_magnify);
                                break;
                            case 1:
                                icono = ContextCompat.getDrawable(activity, R.drawable.ig_camera);
                                break;
                            case 2:
                                icono = ContextCompat.getDrawable(activity, R.drawable.ig_heart);
                                break;
                        }
                        if (tab != null) {
                            tab.setIcon(icono); // Se le asigna el ícono.
                            tab.setText(null);  // Para que no muestre texto, solamente la imagen.
                        }
                    }
                    break;

                case R.id.nav_googleplus:
                    for (int i = 0; i < tabLayout.getTabCount(); i++){
                        tab = tabLayout.getTabAt(i);
                        switch (i){
                            case 0:
                                icono = ContextCompat.getDrawable(activity, R.drawable.gp_apps);
                                break;
                            case 1:
                                icono = ContextCompat.getDrawable(activity, R.drawable.gp_circles);
                                break;
                            case 2:
                                icono = ContextCompat.getDrawable(activity, R.drawable.gp_bell);
                                break;
                        }
                        if (tab != null) {
                            tab.setIcon(icono); // Se le asigna el ícono.
                            tab.setText(null);  // Para que no muestre texto, solamente la imagen.
                        }
                    }
                    break;

                case R.id.nav_twitter:
                    for (int i = 0; i < tabLayout.getTabCount(); i++){
                        tab = tabLayout.getTabAt(i);
                        switch (i){
                            case 0:
                                icono = ContextCompat.getDrawable(activity, R.drawable.gp_bell);
                                break;
                            case 1:
                                icono = ContextCompat.getDrawable(activity, R.drawable.tw_message);
                                break;
                            case 2:
                                icono = ContextCompat.getDrawable(activity, R.drawable.ig_magnify);
                                break;
                        }
                        if (tab != null) {
                            tab.setIcon(icono); // Se le asigna el ícono.
                            tab.setText(null);  // Para que no muestre texto, solamente la imagen.
                        }
                    }
                    break;
            }
        }

        /*tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.wtf("MENSAJE", "onTabSelected - idItem: " + idItem);
                Log.wtf("MENSAJE", "onTabSelected - position: " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.updateView(getString(R.string.app_name), subtituloSegunSeleccion(idItem), colorSegunSeleccion(idItem));
    }

    private int colorSegunSeleccion(int id){
        switch (id){
            case R.id.nav_facebook:
                return R.color.colorFacebook;
            case R.id.nav_instagram:
                return R.color.colorInstagram;
            case R.id.nav_googleplus:
                return R.color.colorGooglePlus;
            case R.id.nav_twitter:
                return R.color.colorTwitter;
            default:
                return 0;
        }
    }

    private String subtituloSegunSeleccion(int id){
        switch (id){
            case R.id.nav_facebook:
                return getString(R.string.facebook);
            case R.id.nav_instagram:
                return getString(R.string.instagram);
            case R.id.nav_googleplus:
                return getString(R.string.google_plus);
            case R.id.nav_twitter:
                return getString(R.string.twitter);
            default:
                return "";
        }
    }

}
