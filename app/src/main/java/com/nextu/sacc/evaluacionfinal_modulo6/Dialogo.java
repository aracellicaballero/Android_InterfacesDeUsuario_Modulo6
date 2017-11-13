package com.nextu.sacc.evaluacionfinal_modulo6;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import static java.security.AccessController.getContext;

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
                //if (isChecked) Toast.makeText(activity, items[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Compartir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "";
                for (int i = 0; i < checkedItems.length; i++){
                    if (checkedItems[i]) seleccion += "\n" + items[i];
                }
                dialog.cancel();
                //Toast.makeText(activity, "Elementos seleccionados: " + seleccion, Toast.LENGTH_SHORT).show();
                Dialogo.Confirmacion(activity, view, seleccion).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

    public static Dialog Confirmacion(final Activity activity, final View view, final String texto){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogo);

        builder.setTitle("Confirmación");
        builder.setMessage("¿Compartir esta aplicación a través de los medios seleccionados?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();    // Cierra
                Toast.makeText(activity, "Compartiste esta aplicación a través de:\n" + texto, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();    // Cierra
            }
        });

        /*builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();    // Cierra
                Toast.makeText(activity, "Acción cancelada", Toast.LENGTH_SHORT).show();
                // El parámetro view se usa si se usa un Snackbar
            }
        });*/

        return builder.create();
    }

}
