package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.db.Tables;

public class CashAccountsAdapter
        extends RecyclerView.Adapter<CashAccountsAdapter.CashAccountsHolder>
{
    private Context context;
    private Cursor data;
    private ICashAccountsAdapterListener listener;

    public CashAccountsAdapter(Context c, ICashAccountsAdapterListener l)
    {
        this.context = c;
        this.listener = l;
    }

    @Override
    public CashAccountsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.cash_account_list_item, parent, false);
        return new CashAccountsHolder(v);
    }

    @Override
    public void onBindViewHolder(CashAccountsHolder holder, int position)
    {
        data.moveToPosition(position);
        final int id = data.getInt(data.getColumnIndex(BaseColumns._ID));
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                listener.getCashAccount(id);
            }
        });
        holder.name.setText(data.getString(data.getColumnIndex(Tables.CashAccounts.Columns.name)));
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

    protected class CashAccountsHolder
            extends RecyclerView.ViewHolder
    {
        public TextView name;

        public CashAccountsHolder(View v)
        {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
        }
    }

    public interface ICashAccountsAdapterListener
    {
        void getCashAccount(int id);
    }
}