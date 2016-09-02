package delaem.code.mym1y.ui.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.Transaction;
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.db.Tables;
import delaem.code.mym1y.ui.fragments.dialogs.ChooseCashAccount;

public class EditTransactionFragment
        extends Fragment
{
    static public EditTransactionFragment newInstance(IEditTransactionFragmentListener l)
    {
        EditTransactionFragment fragment = new EditTransactionFragment();
        Bundle bundle = fragment.getArguments();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private TextView cash_account;
    private EditText summ;
    private EditText comment;

    //___________________FIELDS
    private Transaction transaction;
    private IEditTransactionFragmentListener listener;
    private final View.OnClickListener clickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch(view.getId())
            {
                case R.id.cancel:
                    listener.cancel();
                    break;
                case R.id.ok:
                    saveTransaction();
                    break;
                case R.id.cash_account:
                    chooseCashAccount();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.edit_transaction_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        summ = (EditText) v.findViewById(R.id.summ);
        comment = (EditText) v.findViewById(R.id.comment);
        cash_account = (TextView) v.findViewById(R.id.cash_account);
        v.findViewById(R.id.cancel).setOnClickListener(clickListener);
        v.findViewById(R.id.ok).setOnClickListener(clickListener);
        cash_account.setOnClickListener(clickListener);
    }
    private void init()
    {
        transaction = new Transaction();
        Cursor cursor = SQliteApi.getInstanse().getCashAccounts().getAll();
        if(cursor.moveToFirst())
        {
            transaction.cash_account_from_id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
            cash_account.setText(cursor.getString(cursor.getColumnIndex(Tables.CashAccounts.Columns.name)));
        }
        cursor.close();
    }

    private void saveTransaction()
    {
        transaction.time = System.currentTimeMillis();
        transaction.summ = Integer.parseInt(summ.getText().toString());
        transaction.comment = comment.getText().toString();
        SQliteApi.getInstanse().getTransactions().insertNew(transaction);
        listener.saveTransaction();
    }

    private void chooseCashAccount()
    {
        ChooseCashAccount.newInstance(new ChooseCashAccount.ChooseCashAccountListener()
        {
            @Override
            public void getCashAccount(int id)
            {
                updateCashAccount(id);
            }
        }).show(getActivity().getSupportFragmentManager(), ChooseCashAccount.class.getCanonicalName());
    }

    private void updateCashAccount(int id)
    {
        Cursor cursor = SQliteApi.getInstanse().getCashAccounts().getOneFromId(id);
        if(cursor.moveToFirst())
        {
            transaction.cash_account_from_id = id;
            cash_account.setText(cursor.getString(cursor.getColumnIndex(Tables.CashAccounts.Columns.name)));
        }
        cursor.close();
    }

    public interface IEditTransactionFragmentListener
    {
        void saveTransaction();
        void cancel();
    }
}