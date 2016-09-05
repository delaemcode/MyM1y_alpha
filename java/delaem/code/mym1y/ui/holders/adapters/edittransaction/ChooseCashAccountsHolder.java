package delaem.code.mym1y.ui.holders.adapters.edittransaction;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public class ChooseCashAccountsHolder
        extends ModelHolder
{
    private ImageView ico;
    private TextView name;

    public ChooseCashAccountsHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.choose_cash_account_list_item);
        name = (TextView) itemView.findViewById(R.id.name);
        ico = (ImageView) itemView.findViewById(R.id.ico);
    }

    public void setName(String n)
    {
        name.setText(n);
    }
    public void setIco(int i)
    {
        ico.setImageDrawable(CashAccountHelper.getCashAccountIco(i));
    }
}