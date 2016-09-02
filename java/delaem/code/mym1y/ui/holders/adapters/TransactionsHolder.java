package delaem.code.mym1y.ui.holders.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import delaem.code.mym1y.R;

public class TransactionsHolder
        extends ModelHolder
{
    private TextView cash_account_from;
    private TextView time;
    private TextView summ;
    private TextView comment;

    public TransactionsHolder(Context context, ViewGroup parent)
    {
        super(context, parent, R.layout.transaction_list_item);
        cash_account_from = (TextView) itemView.findViewById(R.id.cash_account_from);
        time = (TextView) itemView.findViewById(R.id.time);
        summ = (TextView) itemView.findViewById(R.id.summ);
        comment = (TextView) itemView.findViewById(R.id.comment);
    }

    public void setCashAccountFrom(String text)
    {
        cash_account_from.setText(text);
    }
    public void setTime(String text)
    {
        time.setText(text);
    }
    public void setComment(String text)
    {
        comment.setText(text);
    }
    public void setSumm(String text)
    {
        summ.setText(text);
    }
}