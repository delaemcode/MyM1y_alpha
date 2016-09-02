package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.listeners.ui.adapters.ICashAccountsAdapterListener;
import delaem.code.mym1y.models.CashAccountsModel;
import delaem.code.mym1y.ui.holders.adapters.CashAccountsHolder;

public class CashAccountsAdapter
    extends ModelAdapter<CashAccountsHolder, CashAccountsModel, ICashAccountsAdapterListener>
{
    public CashAccountsAdapter(Context c, ICashAccountsAdapterListener l)
    {
        super(c, new CashAccountsModel(), l);
    }

    @Override
    protected void setData(CashAccountsHolder holder, CashAccountsModel data)
    {
        final int id = data.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getListener().getCashAccount(id);
            }
        });
        holder.setName(data.getName());
        holder.setBalance(data.getBalance());
    }

    @Override
    public CashAccountsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new CashAccountsHolder(getContext(), parent);
    }
}