package delaem.code.mym1y.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import delaem.code.mym1y.R;

public class TabSelector
        extends LinearLayout
{
    private View cash_accounts;
    private View transactions;

    private final View.OnClickListener clickListener = new OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if(listener == null)
            {
                return;
            }
            boolean b = false;
            switch(view.getId())
            {
                case R.id.cash_accounts:
                    b = true;
                    if(b != tabCashAccounts)
                    {
                        listener.setTab(b);
                    }
                    break;
                case R.id.transactions:
                    b = false;
                    if(b != tabCashAccounts)
                    {
                        listener.setTab(b);
                    }
                    break;
            }
            setTab(view, b);
        }
    };
    private TabSelectorListener listener;
    private boolean tabCashAccounts;

    public TabSelector(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tab_selector, this);
        cash_accounts = findViewById(R.id.cash_accounts);
        transactions = findViewById(R.id.transactions);
        cash_accounts.setOnClickListener(clickListener);
        transactions.setOnClickListener(clickListener);
        setTab(cash_accounts, true);
    }

    private void clearAll()
    {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
        {
            cash_accounts.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_ripple_selector));
            transactions.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_ripple_selector));
        } else
        {
            cash_accounts.setBackground(getResources().getDrawable(R.drawable.white_ripple_selector));
            transactions.setBackground(getResources().getDrawable(R.drawable.white_ripple_selector));
        }
    }

    private void setTab(View v, boolean b)
    {
        tabCashAccounts = b;
        clearAll();
        v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    public void setTab(boolean cashAccounts)
    {
        if(cashAccounts)
        {
            setTab(cash_accounts, true);
        } else
        {
            setTab(transactions, false);
        }
    }

    public void setListener(TabSelectorListener l)
    {
        this.listener = l;
    }

    public interface TabSelectorListener
    {
        void setTab(boolean cashAccounts);
    }
}