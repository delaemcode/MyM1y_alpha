package delaem.code.mym1y.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.ui.fragments.CashAccountsListFragment;
import delaem.code.mym1y.ui.fragments.TransactionsFragment;
import delaem.code.mym1y.ui.views.TabSelector;

public class MainActivity
        extends AppCompatActivity
{
    //___________________FRAGMENTS
    private final CashAccountsListFragment cashAccountsListFragment = new CashAccountsListFragment();
    private final TransactionsFragment transactionsFragment = new TransactionsFragment();

    //___________________FIELDS
    private TabSelector tab_selector;

    @Override
    protected void onActivityResult(int request, int result, Intent intent)
    {
        if(request == EditCashAccountActivity.REQUEST_CODE)
        {
            if(result == EditCashAccountActivity.RESULT_OK)
            {
                cashAccountsListFragment.loadCashAccounts();
            }
        }
        super.onActivityResult(request, result, intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initViews();
        init();
    }
    private void initViews()
    {
        tab_selector = (TabSelector) findViewById(R.id.tab_selector);
    }
    private void init()
    {
        testData();
        tab_selector.setListener(new TabSelector.TabSelectorListener()
        {
            @Override
            public void setTab(boolean cashAccounts)
            {
                Fragment f = null;
                if(cashAccounts)
                {
                    f = cashAccountsListFragment;
                }
                else
                {
                    f = transactionsFragment;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_frame, f)
                        .commit();
            }
        });
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame, cashAccountsListFragment)
                .commit();
    }

    private void addCashAccount()
    {
        startActivity(new Intent(this, EditCashAccountActivity.class));
    }

    private void testData()
    {
//        insertCashAccounts();
//        insertTransactions();
    }
    private void insertCashAccounts()
    {
        CashAccount item = new CashAccount();
        item.name = "nalychko";
        SQliteApi.getInstanse().insertCashAccount(item);
        item.name = "sber";
        SQliteApi.getInstanse().insertCashAccount(item);
    }
    private void insertTransactions()
    {
        Transaction item = new Transaction();
        item.cash_account_from_id = 0;
        item.time = System.currentTimeMillis();
        SQliteApi.getInstanse().insertTransaction(item);
        item.cash_account_from_id = 0;
        item.time = System.currentTimeMillis();
        SQliteApi.getInstanse().insertTransaction(item);
        item.cash_account_from_id = 1;
        item.time = System.currentTimeMillis();
        SQliteApi.getInstanse().insertTransaction(item);
    }
}