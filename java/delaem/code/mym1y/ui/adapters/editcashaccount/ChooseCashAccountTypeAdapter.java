package delaem.code.mym1y.ui.adapters.editcashaccount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import delaem.code.mym1y.listeners.ui.adapters.editcashaccount.IChooseCashAccountTypeAdapterListener;
import delaem.code.mym1y.models.editcashaccount.ChooseCashAccountTypeModel;
import delaem.code.mym1y.ui.adapters.ModelAdapter;
import delaem.code.mym1y.ui.holders.adapters.editcashaccount.ChooseCashAccountTypeHolder;

public class ChooseCashAccountTypeAdapter
        extends ModelAdapter<ChooseCashAccountTypeHolder, ChooseCashAccountTypeModel, IChooseCashAccountTypeAdapterListener>
{
    public ChooseCashAccountTypeAdapter(Context c, IChooseCashAccountTypeAdapterListener l)
    {
        super(c, new ChooseCashAccountTypeModel(), l);
    }

    @Override
    protected void setData(ChooseCashAccountTypeHolder holder, ChooseCashAccountTypeModel data)
    {
        final int type = data.getType();
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getListener().getCashAccountType(type);
            }
        });
        holder.setNameFromType(type);
        holder.setIcoFromType(type);
    }

    @Override
    public ChooseCashAccountTypeHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ChooseCashAccountTypeHolder(getContext(), parent);
    }
}