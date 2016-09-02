package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.view.ViewGroup;

import delaem.code.mym1y.listeners.ui.adapters.ITransactionsAdapterListener;
import delaem.code.mym1y.models.TransactionsModel;
import delaem.code.mym1y.ui.holders.adapters.TransactionsHolder;

public class TransactionsAdapter
        extends ModelAdapter<TransactionsHolder, TransactionsModel, ITransactionsAdapterListener>
{
    public TransactionsAdapter(Context c, ITransactionsAdapterListener l)
    {
        super(c, new TransactionsModel(), l);
    }

    @Override
    protected void setData(TransactionsHolder holder, TransactionsModel data)
    {
        holder.setCashAccountFrom(data.getCashAccountFrom());
        holder.setTime(data.getTime());
        holder.setComment(data.getComment());
        holder.setSumm(data.getSumm());
    }

    @Override
    public TransactionsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new TransactionsHolder(getContext(), parent);
    }
}