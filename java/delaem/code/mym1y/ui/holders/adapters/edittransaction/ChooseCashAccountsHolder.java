package delaem.code.mym1y.ui.holders.adapters.edittransaction;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public class ChooseCashAccountsHolder
        extends ModelHolder
{
    private TextView name;

    public ChooseCashAccountsHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.choose_cash_account_list_item);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void setName(String n)
    {
        name.setText(n);
    }
}