package delaem.code.mym1y.ui.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.listeners.ui.adapters.editcashaccount.IChooseCashAccountIcoAdapterListener;
import delaem.code.mym1y.ui.adapters.editcashaccount.ChooseCashAccountIcoAdapter;

public class ChooseCashAccountIco
        extends DialogFragment
{
    static public ChooseCashAccountIco newInstance(ChooseCashAccountIcoListener l)
    {
        ChooseCashAccountIco fragment = new ChooseCashAccountIco();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private RecyclerView list;

    //___________________FIELDS
    private ChooseCashAccountIcoAdapter adapter;
    private ChooseCashAccountIcoListener listener;

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
        View v = inflater.inflate(R.layout.choose_cash_account_ico_dialog, null);
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
        adapter = new ChooseCashAccountIcoAdapter(getActivity(), new IChooseCashAccountIcoAdapterListener()
        {
            @Override
            public void getCashAccountIco(int ico)
            {
                listener.getCashAccountIco(ico);
                dismiss();
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        list.setLayoutManager(gridLayoutManager);
        list.setAdapter(adapter);
    }

    private void loadCashAccountTypes()
    {
        adapter.getModel().swapData(CashAccountHelper.getCashAccountIcos());
        adapter.notifyDataSetChanged();
    }

    public interface ChooseCashAccountIcoListener
    {
        void getCashAccountIco(int ico);
    }
}