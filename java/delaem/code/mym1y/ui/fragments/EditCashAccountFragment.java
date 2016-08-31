package delaem.code.mym1y.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.CashAccount;
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

    private IEditCashAccountFragmentListener listener;

    //___________________FIELDS
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
        item.name = name.getText().toString();
        item.description = description.getText().toString();
        SQliteApi.getInstanse().insertCashAccount(item);
        listener.saveCashAccount();
    }

    public interface IEditCashAccountFragmentListener
    {
        void saveCashAccount();
        void cancel();
    }
}