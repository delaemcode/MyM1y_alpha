package delaem.code.mym1y;

import android.app.Application;

import delaem.code.mym1y.db.SQliteApi;

public class App
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SQliteApi.getInstanse().createDB(getApplicationContext());
    }
}