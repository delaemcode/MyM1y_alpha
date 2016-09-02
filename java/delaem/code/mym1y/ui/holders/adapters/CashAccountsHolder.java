package delaem.code.mym1y.ui.holders.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public class CashAccountsHolder
    extends ModelHolder
{
    private TextView name;

    public CashAccountsHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.cash_account_list_item);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void setName(String n)
    {
        name.setText(n);
    }
}