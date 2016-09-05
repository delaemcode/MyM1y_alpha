package delaem.code.mym1y.ui.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.listeners.ui.adapters.editcashaccount.IChooseCashAccountTypeAdapterListener;
import delaem.code.mym1y.ui.adapters.editcashaccount.ChooseCashAccountTypeAdapter;

public class ChooseCashAccountType
        extends DialogFragment
{
    static public ChooseCashAccountType newInstance(ChooseCashAccountTypeListener l)
    {
        ChooseCashAccountType fragment = new ChooseCashAccountType();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private RecyclerView list;

    //___________________FIELDS
    private ChooseCashAccountTypeAdapter adapter;
    private ChooseCashAccountTypeListener listener;

    @Override
    public void onResume()
    {
        super.onResume();
        loadCashAccountTypes();
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new Dialog(getActivity(), R.style.Dialog);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.choose_cash_account_type_dialog, null);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        list = (RecyclerView) v.findViewById(R.id.list);
    }
    private void init()
    {
        adapter = new ChooseCashAccountTypeAdapter(getActivity(), new IChooseCashAccountTypeAdapterListener()
        {
            @Override
            public void getCashAccountType(int type)
            {
                listener.getCashAccountType(type);
                dismiss();
            }
        });
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);
    }

    private void loadCashAccountTypes()
    {
        adapter.getModel().swapData(CashAccountHelper.getCashAccountTypes());
        adapter.notifyDataSetChanged();
    }

    public interface ChooseCashAccountTypeListener
    {
        void getCashAccountType(int type);
    }
}