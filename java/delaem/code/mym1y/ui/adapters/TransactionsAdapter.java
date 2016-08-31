package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.db.Tables;

public class TransactionsAdapter
        extends RecyclerView.Adapter<TransactionsAdapter.TransactionsHolder>
{
    private Context context;
    private Cursor data;
    private ITransactionsAdapterListener listener;

    public TransactionsAdapter(Context c, ITransactionsAdapterListener l)
    {
        this.context = c;
        this.listener = l;
    }

    @Override
    public TransactionsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.transaction_list_item, parent, false);
        return new TransactionsHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionsHolder holder, int position)
    {
        data.moveToPosition(position);
        holder.cash_account_from.setText(data.getString(data.getColumnIndex(Tables.Transactions.Columns.cash_account_from_id)));
        holder.time.setText(data.getString(data.getColumnIndex(Tables.Transactions.Columns.time)));
    }

    @Override
    public int getItemCount()
    {
        if (data == null)
        {
            return 0;
        }
        return data.getCount();
    }

    public void swapData(Cursor d)
    {
        if(this.data != null)
        {
            this.data.close();
        }
        this.data = d;
        notifyDataSetChanged();
    }

    protected class TransactionsHolder
            extends RecyclerView.ViewHolder
    {
        public TextView cash_account_from;
        public TextView time;

        public TransactionsHolder(View v)
        {
            super(v);
            cash_account_from = (TextView) v.findViewById(R.id.cash_account_from);
            time = (TextView) v.findViewById(R.id.time);
        }
    }

    public interface ITransactionsAdapterListener
    {

    }
}