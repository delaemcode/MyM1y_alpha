package delaem.code.mym1y.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import delaem.code.mym1y.R;
import delaem.code.mym1y.ui.fragments.EditCashAccountFragment;

public class EditCashAccountActivity
        extends AppCompatActivity
{
    static public final int REQUEST_CODE = 1906;
    static public final int RESULT_OK = 0;
    static public final int RESULT_CANCEL = 1;

    static public void startForNewPlace(AppCompatActivity activity)
    {
        Intent i = new Intent(activity, EditCashAccountActivity.class);
        activity.startActivityForResult(i, REQUEST_CODE);
    }

    private final EditCashAccountFragment editCashAccountFragment = EditCashAccountFragment.newInstance(new EditCashAccountFragment.IEditCashAccountFragmentListener()
    {
        @Override
        public void saveCashAccount()
        {
            setResult(RESULT_OK);
            finish();
        }
        @Override
        public void cancel()
        {
            setResult(RESULT_CANCEL);
            finish();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cash_account_activity);
        initViews();
        init();
    }
    private void initViews()
    {

    }
    private void init()
    {
        setResult(RESULT_CANCEL);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame, editCashAccountFragment)
                .commit();
    }
}