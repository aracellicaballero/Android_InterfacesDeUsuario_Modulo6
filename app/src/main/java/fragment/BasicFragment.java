package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nextu.sacc.evaluacionfinal_modulo6.R;

public class BasicFragment extends Fragment {

    ImageView imageView;
    TextView textTitulo;

    private String tituloActual;    // título
    private int imagenActual;       // id de la imagen

    private static final String ARG_TITLE = "titulo";
    private static final String ARG_DRAWABLE = "imagen";

    public static BasicFragment getInstance(String title){
        //Log.wtf("MENSAJE", "getInstance: " + title);
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            this.tituloActual = savedInstanceState.getString(ARG_TITLE);
            //this.imagenActual = savedInstanceState.getInt(ARG_DRAWABLE);
        }

        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.textTitulo = (TextView) view.findViewById(R.id.txt_principal);
        this.imageView = (ImageView) view.findViewById(R.id.img_principal);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null)
            updateView(arguments.getString(ARG_TITLE));
        else if (tituloActual != null)
            updateView(tituloActual);
    }

    private void updateView(String title) {
        this.imageView.setImageDrawable(getResources().getDrawable(imagenSegunTexto(title)));
        this.textTitulo.setText(title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_TITLE, tituloActual);
    }

    private int imagenSegunTexto(String titulo){
        int retorno = R.drawable.home;

        if (titulo.equals(getResources().getString(R.string.tab_noticias))){
            retorno = R.drawable.noticias;
        }else if (titulo.equals(getResources().getString(R.string.tab_solicitudes))){
            retorno = R.drawable.solicitudes;
        }else if (titulo.equals(getResources().getString(R.string.tab_versionweb))){
            retorno = R.drawable.versionweb;
        }else if (titulo.equals(getResources().getString(R.string.tab_buscar))){
            retorno = R.drawable.buscar;
        }else if (titulo.equals(getResources().getString(R.string.tab_publicar))){
            retorno = R.drawable.publicar;
        }else if (titulo.equals(getResources().getString(R.string.tab_actividad))){
            retorno = R.drawable.actividad;
        }else if (titulo.equals(getResources().getString(R.string.tab_aplicaciones))){
            retorno = R.drawable.aplicaciones;
        }else if (titulo.equals(getResources().getString(R.string.tab_circulos))){
            retorno = R.drawable.circulos;
        }else if (titulo.equals(getResources().getString(R.string.tab_notificaciones))){
            retorno = R.drawable.notificaciones;
        }else if (titulo.equals(getResources().getString(R.string.tab_mensajes))){
            retorno = R.drawable.mensajes;
        }

        // Retorna
        return retorno;
    }
}
