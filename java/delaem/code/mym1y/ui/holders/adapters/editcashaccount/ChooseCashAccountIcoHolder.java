package delaem.code.mym1y.ui.holders.adapters.editcashaccount;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public class ChooseCashAccountIcoHolder
        extends ModelHolder
{
    private ImageView ico;

    public ChooseCashAccountIcoHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.choose_cash_account_ico_list_item);
        ico = (ImageView) itemView.findViewById(R.id.ico);
    }

    public void setIco(int i)
    {
        ico.setImageDrawable(CashAccountHelper.getCashAccountIco(i));
    }
}