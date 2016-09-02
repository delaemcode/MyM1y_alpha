package delaem.code.mym1y.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.Transaction;
import delaem.code.mym1y.db.SQliteApi;

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
    private EditText summ;
    private EditText comment;

    //___________________FIELDS
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
        v.findViewById(R.id.cancel).setOnClickListener(clickListener);
        v.findViewById(R.id.ok).setOnClickListener(clickListener);
    }
    private void init()
    {

    }

    private void saveTransaction()
    {
        Transaction item = new Transaction();
        item.cash_account_from_id = 1;
        item.time = System.currentTimeMillis();
        item.summ = Integer.parseInt(summ.getText().toString());
        item.comment = comment.getText().toString();
        SQliteApi.getInstanse().getTransactions().insertOne(item);
        listener.saveTransaction();
    }

    public interface IEditTransactionFragmentListener
    {
        void saveTransaction();
        void cancel();
    }
}