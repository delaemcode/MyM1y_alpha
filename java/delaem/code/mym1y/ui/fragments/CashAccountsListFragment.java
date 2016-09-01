package delaem.code.mym1y.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.R;
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.ui.activities.EditCashAccountActivity;
import delaem.code.mym1y.ui.adapters.CashAccountsAdapter;

public class CashAccountsListFragment
        extends Fragment
{
    //___________________VIEWS
    private RecyclerView list;

    //___________________FIELDS
    private CashAccountsAdapter adapter;
    private final View.OnClickListener clickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch(view.getId())
            {
                case R.id.add:
                    addCashAccount();
                    break;
            }
        }
    };

    @Override
    public void onResume()
    {
        super.onResume();
        loadCashAccounts();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.cash_accounts_list_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        list = (RecyclerView) v.findViewById(R.id.list);
        v.findViewById(R.id.add).setOnClickListener(clickListener);
    }
    private void init()
    {
        adapter = new CashAccountsAdapter(getActivity(), new CashAccountsAdapter.ICashAccountsAdapterListener()
        {
            @Override
            public void getCashAccount(int id)
            {

            }
        });
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);
    }

    private void addCashAccount()
    {
        getActivity().startActivity(new Intent(getActivity(), EditCashAccountActivity.class));
    }

    public void loadCashAccounts()
    {
        adapter.swapData(SQliteApi.getInstanse().getCashAccounts());
    }
}