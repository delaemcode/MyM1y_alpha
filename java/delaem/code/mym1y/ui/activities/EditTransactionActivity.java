package delaem.code.mym1y.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import delaem.code.mym1y.R;
import delaem.code.mym1y.ui.fragments.EditTransactionFragment;

public class EditTransactionActivity
        extends AppCompatActivity
{
    static public final int REQUEST_CODE = 1552;
    static public final int RESULT_OK = 0;
    static public final int RESULT_CANCEL = 1;

    static public void startForNewTransaction(Activity activity)
    {
        Intent i = new Intent(activity, EditTransactionActivity.class);
        activity.startActivityForResult(i, REQUEST_CODE);
    }

    private final EditTransactionFragment editTransactionFragment = EditTransactionFragment.newInstance(new EditTransactionFragment.IEditTransactionFragmentListener()
    {
        @Override
        public void saveTransaction()
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
        setContentView(R.layout.edit_transaction_activity);
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
                .add(R.id.main_frame, editTransactionFragment)
                .commit();
    }
}