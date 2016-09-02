package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.R;
import delaem.code.mym1y.listeners.ui.adapters.ICashAccountsAdapterListener;
import delaem.code.mym1y.models.CashAccountsModel;
import delaem.code.mym1y.ui.holders.adapters.CashAccountsHolder;

public class CashAccountsAdapter
    extends ModelAdapter<CashAccountsHolder, CashAccountsModel, ICashAccountsAdapterListener>
{
    private final int balancePositiveColor;
    private final int balanceNeutralColor;
    private final int balanceNegativeColor;

    public CashAccountsAdapter(Context c, ICashAccountsAdapterListener l)
    {
        super(c, new CashAccountsModel(), l);
        balancePositiveColor = getContext().getResources().getColor(R.color.green);
        balanceNeutralColor = getContext().getResources().getColor(R.color.colorPrimary);
        balanceNegativeColor = getContext().getResources().getColor(R.color.red);
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
        int balance = data.getBalance();
        if(balance > 0)
        {
            holder.setBalance("+" + balance);
            holder.setBalanceTextColor(balancePositiveColor);
        }
        else if(balance < 0)
        {
            holder.setBalance("" + balance);
            holder.setBalanceTextColor(balanceNegativeColor);
        }
        else
        {
            holder.setBalance("" + 0);
            holder.setBalanceTextColor(balanceNeutralColor);
        }
    }

    @Override
    public CashAccountsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new CashAccountsHolder(getContext(), parent);
    }
}