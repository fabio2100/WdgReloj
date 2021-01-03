package com.squizzato.wdgreloj;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class wdgrelojito extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.wdgrelojito);
        Date date = new Date();

        String dia = Integer.toString(date.getDate());
        String mes = Integer.toString(date.getMonth()+1);
        String anio = Integer.toString(date.getYear()-100);

        String hora = Integer.toString(date.getHours());
        String minuto = Integer.toString(date.getMinutes());
        String segundos = Integer.toString(date.getSeconds());

        views.setTextViewText(R.id.appwidget_text,dia);
        views.setTextViewText(R.id.segundo,mes);
        views.setTextViewText(R.id.tercero,anio);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

