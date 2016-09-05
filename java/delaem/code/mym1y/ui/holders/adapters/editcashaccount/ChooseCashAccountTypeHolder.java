package delaem.code.mym1y.ui.holders.adapters.editcashaccount;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public class ChooseCashAccountTypeHolder
        extends ModelHolder
{
    private TextView name;
    private ImageView ico;

    public ChooseCashAccountTypeHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.choose_cash_account_type_list_item);
        name = (TextView) itemView.findViewById(R.id.name);
        ico = (ImageView) itemView.findViewById(R.id.ico);
    }

    public void setNameFromType(int type)
    {
        name.setText(CashAccountHelper.getCashAccountTypeName(type));
    }
    public void setIcoFromType(int type)
    {
        ico.setImageDrawable(CashAccountHelper.getCashAccountTypeIco(type));
    }
}