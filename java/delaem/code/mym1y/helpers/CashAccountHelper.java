package delaem.code.mym1y.helpers;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import delaem.code.mym1y.R;
import delaem.code.mym1y.core.CashAccountIcos;
import delaem.code.mym1y.core.CashAccountTypes;

public class CashAccountHelper
{
    static private int accentColor;
    static private int primaryColor;
    static private int redColor;
    static private int greenColor;
    static private int blueColor;

    static private Drawable cashIco;
    static private Drawable debitIco;
    static private Drawable creditIco;
    static private Drawable phoneIco;
    static private Drawable cardIco;
    static private Drawable accountIco;

    static private Drawable masterCardIco;
    static private Drawable maestroIco;
    static private Drawable visaIco;
    static private Drawable cardRedIco;
    static private Drawable cardGreenIco;
    static private Drawable cardBlueIco;
    static private Drawable phoneRedIco;
    static private Drawable phoneGreenIco;
    static private Drawable phoneBlueIco;
    static private Drawable accountRedIco;
    static private Drawable accountGreenIco;
    static private Drawable accountBlueIco;
    static private Drawable cashRedIco;
    static private Drawable cashGreenIco;
    static private Drawable cashBlueIco;

    static public void init(Context c)
    {
        accentColor = c.getResources().getColor(R.color.colorAccent);
        primaryColor = c.getResources().getColor(R.color.colorPrimary);
        redColor = c.getResources().getColor(R.color.red);
        greenColor = c.getResources().getColor(R.color.green);
        blueColor = c.getResources().getColor(R.color.blue);
        //
        cashIco = c.getResources().getDrawable(R.drawable.ic_account_balance_wallet_white_24dp);
        cashIco.mutate();
        cashIco.setColorFilter(accentColor, PorterDuff.Mode.SRC_ATOP);
        debitIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        debitIco.mutate();
        debitIco.setColorFilter(blueColor, PorterDuff.Mode.SRC_ATOP);
        creditIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        creditIco.mutate();
        creditIco.setColorFilter(redColor, PorterDuff.Mode.SRC_ATOP);
        phoneIco = c.getResources().getDrawable(R.drawable.ic_phone_white_24dp);
        phoneIco.mutate();
        phoneIco.setColorFilter(accentColor, PorterDuff.Mode.SRC_ATOP);
        cardIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        cardIco.mutate();
        cardIco.setColorFilter(primaryColor, PorterDuff.Mode.SRC_ATOP);
        accountIco = c.getResources().getDrawable(R.drawable.ic_piggy_bank);
        accountIco.mutate();
        accountIco.setColorFilter(accentColor, PorterDuff.Mode.SRC_ATOP);
        //
        cardRedIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        cardRedIco.mutate();
        cardRedIco.setColorFilter(redColor, PorterDuff.Mode.SRC_ATOP);
        cardGreenIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        cardGreenIco.mutate();
        cardGreenIco.setColorFilter(greenColor, PorterDuff.Mode.SRC_ATOP);
        cardBlueIco = c.getResources().getDrawable(R.drawable.ic_credit_card_white_24dp);
        cardBlueIco.mutate();
        cardBlueIco.setColorFilter(blueColor, PorterDuff.Mode.SRC_ATOP);
        phoneRedIco = c.getResources().getDrawable(R.drawable.ic_phone_white_24dp);
        phoneRedIco.mutate();
        phoneRedIco.setColorFilter(redColor, PorterDuff.Mode.SRC_ATOP);
        phoneGreenIco = c.getResources().getDrawable(R.drawable.ic_phone_white_24dp);
        phoneGreenIco.mutate();
        phoneGreenIco.setColorFilter(greenColor, PorterDuff.Mode.SRC_ATOP);
        phoneBlueIco = c.getResources().getDrawable(R.drawable.ic_phone_white_24dp);
        phoneBlueIco.mutate();
        phoneBlueIco.setColorFilter(blueColor, PorterDuff.Mode.SRC_ATOP);
        accountRedIco = c.getResources().getDrawable(R.drawable.ic_piggy_bank);
        accountRedIco.mutate();
        accountRedIco.setColorFilter(redColor, PorterDuff.Mode.SRC_ATOP);
        accountGreenIco = c.getResources().getDrawable(R.drawable.ic_piggy_bank);
        accountGreenIco.mutate();
        accountGreenIco.setColorFilter(greenColor, PorterDuff.Mode.SRC_ATOP);
        accountBlueIco = c.getResources().getDrawable(R.drawable.ic_piggy_bank);
        accountBlueIco.mutate();
        accountBlueIco.setColorFilter(blueColor, PorterDuff.Mode.SRC_ATOP);
        cashRedIco = c.getResources().getDrawable(R.drawable.ic_account_balance_wallet_white_24dp);
        cashRedIco.mutate();
        cashRedIco.setColorFilter(redColor, PorterDuff.Mode.SRC_ATOP);
        cashGreenIco = c.getResources().getDrawable(R.drawable.ic_account_balance_wallet_white_24dp);
        cashGreenIco.mutate();
        cashGreenIco.setColorFilter(greenColor, PorterDuff.Mode.SRC_ATOP);
        cashBlueIco = c.getResources().getDrawable(R.drawable.ic_account_balance_wallet_white_24dp);
        cashBlueIco.mutate();
        cashBlueIco.setColorFilter(blueColor, PorterDuff.Mode.SRC_ATOP);
    }

    static public int getCashAccountTypeName(int type)
    {
        switch(type)
        {
            case CashAccountTypes.CASH:
                return R.string.cash_account_type_cash;
            case CashAccountTypes.DEBIT:
                return R.string.cash_account_type_debit;
            case CashAccountTypes.CREDIT:
                return R.string.cash_account_type_credit;
            case CashAccountTypes.PHONE:
                return R.string.cash_account_type_phone;
            case CashAccountTypes.CARD:
                return R.string.cash_account_type_card;
            case CashAccountTypes.ACCOUNT:
                return R.string.cash_account_type_account;
        }
        return -1;
    }
    static public Drawable getCashAccountTypeIco(int type)
    {
        switch(type)
        {
            case CashAccountTypes.CASH:
                return cashIco;
            case CashAccountTypes.DEBIT:
                return debitIco;
            case CashAccountTypes.CREDIT:
                return creditIco;
            case CashAccountTypes.PHONE:
                return phoneIco;
            case CashAccountTypes.CARD:
                return cardIco;
            case CashAccountTypes.ACCOUNT:
                return accountIco;
        }
        return null;
    }
    static public int[] getCashAccountTypes()
    {
        int[] types = new int[6];
        int i = 0;
        types[i++] = CashAccountTypes.CASH;
        types[i++] = CashAccountTypes.DEBIT;
        types[i++] = CashAccountTypes.CREDIT;
        types[i++] = CashAccountTypes.PHONE;
        types[i++] = CashAccountTypes.CARD;
        types[i++] = CashAccountTypes.ACCOUNT;
        return types;
    }

    static public Drawable getCashAccountIco(int ico)
    {
        switch(ico)
        {
            case CashAccountIcos.CARD_RED:
                return cardRedIco;
            case CashAccountIcos.CARD_GREEN:
                return cardGreenIco;
            case CashAccountIcos.CARD_BLUE:
                return cardBlueIco;
            case CashAccountIcos.PHONE_RED:
                return phoneRedIco;
            case CashAccountIcos.PHONE_GREEN:
                return phoneGreenIco;
            case CashAccountIcos.PHONE_BLUE:
                return phoneBlueIco;
            case CashAccountIcos.CASH_RED:
                return cashRedIco;
            case CashAccountIcos.CASH_GREEN:
                return cashGreenIco;
            case CashAccountIcos.CASH_BLUE:
                return cashBlueIco;
            case CashAccountIcos.ACCOUNT_RED:
                return accountRedIco;
            case CashAccountIcos.ACCOUNT_GREEN:
                return accountGreenIco;
            case CashAccountIcos.ACCOUNT_BLUE:
                return accountBlueIco;
        }
        return null;
    }
    static public int[] getCashAccountIcos()
    {
        int[] types = new int[12];
        int i = 0;
        types[i++] = CashAccountIcos.CARD_RED;
        types[i++] = CashAccountIcos.CARD_GREEN;
        types[i++] = CashAccountIcos.CARD_BLUE;
        types[i++] = CashAccountIcos.PHONE_RED;
        types[i++] = CashAccountIcos.PHONE_GREEN;
        types[i++] = CashAccountIcos.PHONE_BLUE;
        types[i++] = CashAccountIcos.CASH_RED;
        types[i++] = CashAccountIcos.CASH_GREEN;
        types[i++] = CashAccountIcos.CASH_BLUE;
        types[i++] = CashAccountIcos.ACCOUNT_RED;
        types[i++] = CashAccountIcos.ACCOUNT_GREEN;
        types[i++] = CashAccountIcos.ACCOUNT_BLUE;
        return types;
    }
}