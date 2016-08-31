package delaem.code.mym1y.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.R;
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.ui.adapters.TransactionsAdapter;

public class TransactionsFragment
        extends Fragment
{
    //___________________VIEWS
    private RecyclerView list;

    //___________________FIELDS
    private TransactionsAdapter adapter;

    @Override
    public void onResume()
    {
        super.onResume();
        loadTransactions();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.transactions_list_fragment, container, false);
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
        adapter = new TransactionsAdapter(getActivity(), new TransactionsAdapter.ITransactionsAdapterListener()
        {
        });
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);
    }

    public void loadTransactions()
    {
        adapter.swapData(SQliteApi.getInstanse().getTransactions());
    }
}