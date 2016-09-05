package delaem.code.mym1y.ui.fragments;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.CashAccountIcos;
import delaem.code.mym1y.core.CashAccountTypes;
import delaem.code.mym1y.core.Transaction;
import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.helpers.CashAccountHelper;
import delaem.code.mym1y.ui.fragments.dialogs.ChooseCashAccountIco;
import delaem.code.mym1y.ui.fragments.dialogs.ChooseCashAccountType;

public class EditCashAccountFragment
        extends Fragment
{
    static public EditCashAccountFragment newInstance(IEditCashAccountFragmentListener l)
    {
        EditCashAccountFragment fragment = new EditCashAccountFragment();
        Bundle bundle = fragment.getArguments();
        fragment.setArguments(bundle);
        fragment.listener = l;
        return fragment;
    }

    //___________________VIEWS
    private ImageView ico;
    private TextView cash_account_type;
    private ImageButton side;
    private EditText name;
    private EditText begin_summ;
    private EditText description;

    //___________________FIELDS
    private IEditCashAccountFragmentListener listener;
    private final View.OnClickListener clickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch(view.getId())
            {
                case R.id.cancel:
                    listener.cancel();
                    break;
                case R.id.ok:
                    saveCashAccount();
                    break;
                case R.id.side:
                    cangeSide();
                    break;
                case R.id.cash_account_type:
                    chooseCashAccountType();
                    break;
                case R.id.ico:
                    chooseCashAccountIco();
                    break;
            }
        }
    };
    private boolean sidePositive;
    private Drawable positive;
    private Drawable negative;
    private String startBalanceComment;
    private int cashAccountType;
    private int cashAccountIco;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.edit_cash_account_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        ico = (ImageView) v.findViewById(R.id.ico);
        cash_account_type = (TextView) v.findViewById(R.id.cash_account_type);
        side = (ImageButton) v.findViewById(R.id.side);
        name = (EditText) v.findViewById(R.id.name);
        begin_summ = (EditText) v.findViewById(R.id.begin_summ);
        description = (EditText) v.findViewById(R.id.description);
        v.findViewById(R.id.cancel).setOnClickListener(clickListener);
        v.findViewById(R.id.ok).setOnClickListener(clickListener);
    }
    private void init()
    {
        sidePositive = true;
        side.setOnClickListener(clickListener);
        ico.setOnClickListener(clickListener);
        cash_account_type.setOnClickListener(clickListener);
        positive = getActivity().getResources().getDrawable(R.drawable.ic_add_white_24dp);
        positive.mutate();
        positive.setColorFilter(getActivity().getResources().getColor(R.color.green), PorterDuff.Mode.SRC_ATOP);
        negative = getActivity().getResources().getDrawable(R.drawable.ic_remove_white_24dp);
        negative.mutate();
        negative.setColorFilter(getActivity().getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
        updateSide();
        startBalanceComment = getActivity().getResources().getString(R.string.start_balance);
        updateCashAccountType(CashAccountTypes.CASH);
        updateCashAccountIco(CashAccountIcos.CASH_BLUE);
    }

    private void cangeSide()
    {
        sidePositive = !sidePositive;
        updateSide();
    }
    private void updateSide()
    {
        if(sidePositive)
        {
            side.setImageDrawable(positive);
        }
        else
        {
            side.setImageDrawable(negative);
        }
    }

    private void chooseCashAccountType()
    {
        ChooseCashAccountType.newInstance(new ChooseCashAccountType.ChooseCashAccountTypeListener()
        {
            @Override
            public void getCashAccountType(int type)
            {
                updateCashAccountType(type);
            }
        }).show(getActivity().getSupportFragmentManager(), ChooseCashAccountType.class.getCanonicalName());
    }
    private void updateCashAccountType(int type)
    {
        cashAccountType = type;
        cash_account_type.setText(CashAccountHelper.getCashAccountTypeName(cashAccountType));
    }

    private void chooseCashAccountIco()
    {
        ChooseCashAccountIco.newInstance(new ChooseCashAccountIco.ChooseCashAccountIcoListener()
        {
            @Override
            public void getCashAccountIco(int ico)
            {
                updateCashAccountIco(ico);
            }
        }).show(getActivity().getSupportFragmentManager(), ChooseCashAccountIco.class.getCanonicalName());
    }
    private void updateCashAccountIco(int i)
    {
        cashAccountIco = i;
        ico.setImageDrawable(CashAccountHelper.getCashAccountIco(cashAccountIco));
    }

    private void saveCashAccount()
    {
        CashAccount item = new CashAccount();
        double did = System.currentTimeMillis();
        did /= 10_000_000;
        item.id = (int)((did - (int)did) * 10_000_000);
        item.name = name.getText().toString();
        item.description = description.getText().toString();
        item.type = cashAccountType;
        item.ico = cashAccountIco;
        SQliteApi.getInstanse().getCashAccounts().insertOne(item);
        Transaction transaction = new Transaction();
        transaction.cash_account_from_id = item.id;
        if(begin_summ.getText().toString().length() == 0)
        {
            listener.saveCashAccount();
            return;
        }
        transaction.summ = Integer.parseInt(begin_summ.getText().toString());
        if(transaction.summ == 0)
        {
            listener.saveCashAccount();
            return;
        }
        if(!sidePositive)
        {
            transaction.summ *= -1;
        }
        transaction.time = System.currentTimeMillis();
        transaction.comment = startBalanceComment;
        SQliteApi.getInstanse().getTransactions().insertNew(transaction);
        listener.saveCashAccount();
    }

    public interface IEditCashAccountFragmentListener
    {
        void saveCashAccount();
        void cancel();
    }
}