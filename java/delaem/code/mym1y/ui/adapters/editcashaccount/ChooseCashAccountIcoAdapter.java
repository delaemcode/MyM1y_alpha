package delaem.code.mym1y.ui.adapters.editcashaccount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.listeners.ui.adapters.editcashaccount.IChooseCashAccountIcoAdapterListener;
import delaem.code.mym1y.models.editcashaccount.ChooseCashAccountIcoModel;
import delaem.code.mym1y.ui.adapters.ModelAdapter;
import delaem.code.mym1y.ui.holders.adapters.editcashaccount.ChooseCashAccountIcoHolder;

public class ChooseCashAccountIcoAdapter
        extends ModelAdapter<ChooseCashAccountIcoHolder, ChooseCashAccountIcoModel, IChooseCashAccountIcoAdapterListener>
{
    public ChooseCashAccountIcoAdapter(Context c, IChooseCashAccountIcoAdapterListener l)
    {
        super(c, new ChooseCashAccountIcoModel(), l);
    }

    @Override
    protected void setData(ChooseCashAccountIcoHolder holder, ChooseCashAccountIcoModel data)
    {
        final int ico = data.getIco();
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getListener().getCashAccountIco(ico);
            }
        });
        holder.setIco(ico);
    }

    @Override
    public ChooseCashAccountIcoHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ChooseCashAccountIcoHolder(getContext(), parent);
    }
}