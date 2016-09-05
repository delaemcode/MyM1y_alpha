package delaem.code.mym1y;

import android.app.Application;

import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.helpers.CashAccountHelper;

public class App
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SQliteApi.getInstanse().createDB(getApplicationContext());
        CashAccountHelper.init(getApplicationContext());
    }
}