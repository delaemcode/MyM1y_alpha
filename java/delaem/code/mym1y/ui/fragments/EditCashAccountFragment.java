package delaem.code.mym1y.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;
import delaem.code.mym1y.db.SQliteApi;

public class EditCashAccountFragment
        extends Fragment
{
    static public EditCashAccountFragment newInstance(IEditCashAccountFragmentListener l)
    {
        EditCashAccountFragment fragment = new EditCashAccountFragment();
        Bundle bundle = fragment.getArguments();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private EditText name;
    private EditText begin_summ;
    private EditText description;

    //___________________FIELDS
    private IEditCashAccountFragmentListener listener;
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
                    saveCashAccount();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.edit_cash_account_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        name = (EditText) v.findViewById(R.id.name);
        begin_summ = (EditText) v.findViewById(R.id.begin_summ);
        description = (EditText) v.findViewById(R.id.description);
        v.findViewById(R.id.cancel).setOnClickListener(clickListener);
        v.findViewById(R.id.ok).setOnClickListener(clickListener);
    }
    private void init()
    {

    }

    private void saveCashAccount()
    {
        CashAccount item = new CashAccount();
        double did = System.currentTimeMillis();
        did /= 10_000_000;
        item.id = (int)((did - (int)did) * 10_000_000);
        item.name = name.getText().toString();
        item.description = description.getText().toString();
        SQliteApi.getInstanse().getCashAccounts().insertOne(item);
        Transaction transaction = new Transaction();
        transaction.cash_account_from_id = item.id;
        transaction.summ = Integer.parseInt(begin_summ.getText().toString());
        transaction.time = System.currentTimeMillis();
        transaction.comment = "Start balance";
        SQliteApi.getInstanse().getTransactions().insertNew(transaction);
        listener.saveCashAccount();
    }

    public interface IEditCashAccountFragmentListener
    {
        void saveCashAccount();
        void cancel();
    }
}