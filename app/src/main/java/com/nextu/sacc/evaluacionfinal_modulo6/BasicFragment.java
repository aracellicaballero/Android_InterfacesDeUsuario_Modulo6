package com.nextu.sacc.evaluacionfinal_modulo6;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BasicFragment extends Fragment {

    ImageView imageView;
    TextView textTitulo;

    private String tituloActual;    // título
    private int imagenActual;       // id de la imagen

    private static final String ARG_TITLE = "titulo";
    private static final String ARG_DRAWABLE = "imagen";

    public static BasicFragment getInstance(String title, int imagen) {
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        bundle.putInt(ARG_DRAWABLE, imagen);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            this.tituloActual = savedInstanceState.getString(ARG_TITLE);
            this.imagenActual = savedInstanceState.getInt(ARG_DRAWABLE);
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
            updateView(arguments.getString(ARG_TITLE), arguments.getInt(ARG_DRAWABLE));
        else if (tituloActual != null)
            updateView(tituloActual, imagenActual);
    }

    private void updateView(String title, int idImagen) {
        //this.imageView.setImageDrawable(idImagen);
        this.textTitulo.setText(title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_TITLE, tituloActual);
        outState.putInt(ARG_DRAWABLE, imagenActual);
    }
}
