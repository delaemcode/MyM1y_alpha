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
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.listeners.ui.adapters.edittransaction.IChooseCashAccountsAdapterListener;
import delaem.code.mym1y.ui.adapters.edittransaction.ChooseCashAccountsAdapter;

public class ChooseCashAccount
        extends DialogFragment
{
    static public ChooseCashAccount newInstance(ChooseCashAccountListener l)
    {
        ChooseCashAccount fragment = new ChooseCashAccount();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private RecyclerView list;

    //___________________FIELDS
    private ChooseCashAccountsAdapter adapter;
    private ChooseCashAccountListener listener;

    @Override
    public void onResume()
    {
        super.onResume();
        loadCashAccounts();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new Dialog(getActivity(), R.style.Dialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.choose_cash_account_dialog, null);
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
        adapter = new ChooseCashAccountsAdapter(getActivity(), new IChooseCashAccountsAdapterListener()
        {
            @Override
            public void getCashAccount(int id)
            {
                listener.getCashAccount(id);
                dismiss();
            }
        });
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);
    }

    private void loadCashAccounts()
    {
        adapter.getModel().swapData(SQliteApi.getInstanse().getCashAccounts().getAll());
        adapter.notifyDataSetChanged();
    }

    public interface ChooseCashAccountListener
    {
        void getCashAccount(int id);
    }
}