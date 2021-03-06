package delaem.code.mym1y.ui.holders.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;

public class CashAccountsHolder
    extends ModelHolder
{
    private ImageView ico;
    private TextView name;
    private TextView balance;

    public CashAccountsHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.cash_account_list_item);
        ico = (ImageView) itemView.findViewById(R.id.ico);
        name = (TextView) itemView.findViewById(R.id.name);
        balance = (TextView) itemView.findViewById(R.id.balance);
    }

    public void setName(String n)
    {
        name.setText(n);
    }
    public void setBalance(String b)
    {
        balance.setText(b);
    }
    public void setBalanceTextColor(int c)
    {
        balance.setTextColor(c);
    }
    public void setIco(int i)
    {
        ico.setImageDrawable(CashAccountHelper.getCashAccountIco(i));
    }
}