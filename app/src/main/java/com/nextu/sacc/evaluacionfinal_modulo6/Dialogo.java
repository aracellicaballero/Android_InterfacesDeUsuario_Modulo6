package com.nextu.sacc.evaluacionfinal_modulo6;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Sara Caballero C on 2017/11/13.
 */

public class Dialogo {

    public static AlertDialog CompartirPublicacion(final Activity activity, final View view){
        // Arreglo con los String de cada opción
        final String[] items = activity.getResources().getStringArray(R.array.opciones_compartir);
        // Arreglo con las selecciones de los elementos del arreglo. Ninguno está seleccionado.
        final boolean[] checkedItems = {false, false, false, false, false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogo);

        builder.setTitle(R.string.titulo_dialogo_compartir);
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        builder.setPositiveButton(R.string.compartir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "";
                for (int i = 0; i < checkedItems.length; i++){
                    if (checkedItems[i]) seleccion += "\n" + items[i];
                }
                dialog.cancel();
                Dialogo.Confirmacion(activity, view, seleccion).show();
            }
        });

        builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

    public static Dialog Confirmacion(final Activity activity, final View view, final String texto){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogo);

        builder.setTitle(R.string.confirmacion);
        builder.setMessage(R.string.confirma_conpartir);
        builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();    // Cierra
                Toast.makeText(activity, activity.getString(R.string.mensaje_compartir) + texto, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();    // Cierra
            }
        });

        return builder.create();
    }

}
