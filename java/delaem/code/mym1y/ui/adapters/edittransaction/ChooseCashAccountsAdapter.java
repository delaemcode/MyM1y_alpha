package delaem.code.mym1y.ui.adapters.edittransaction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.listeners.ui.adapters.edittransaction.IChooseCashAccountsAdapterListener;
import delaem.code.mym1y.models.edittransaction.ChooseCashAccountsModel;
import delaem.code.mym1y.ui.adapters.ModelAdapter;
import delaem.code.mym1y.ui.holders.adapters.edittransaction.ChooseCashAccountsHolder;

public class ChooseCashAccountsAdapter
        extends ModelAdapter<ChooseCashAccountsHolder, ChooseCashAccountsModel, IChooseCashAccountsAdapterListener>
{
    public ChooseCashAccountsAdapter(Context c, IChooseCashAccountsAdapterListener l)
    {
        super(c, new ChooseCashAccountsModel(), l);
    }

    @Override
    protected void setData(ChooseCashAccountsHolder holder, ChooseCashAccountsModel data)
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
        holder.setIco(data.getIco());
    }

    @Override
    public ChooseCashAccountsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ChooseCashAccountsHolder(getContext(), parent);
    }
}
