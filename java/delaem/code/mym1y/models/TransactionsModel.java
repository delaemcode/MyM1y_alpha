package delaem.code.mym1y.models;

import android.database.Cursor;

import delaem.code.mym1y.db.SQliteApi;
import delaem.code.mym1y.db.Tables;

public class TransactionsModel
        extends CursorModel
{
    public String getNameCashAccountFrom()
    {
        String name = null;
        Cursor cursor = SQliteApi.getInstanse().getCashAccounts().getOneFromId(data.getInt(data.getColumnIndex(Tables.Transactions.Columns.cash_account_from_id)));
        if(cursor.moveToFirst())
        {
            name = cursor.getString(cursor.getColumnIndex(Tables.CashAccounts.Columns.name));
        }
        cursor.close();
        return name;
    }
    public String getTime()
    {
        return data.getString(data.getColumnIndex(Tables.Transactions.Columns.time));
    }
    public String getComment()
    {
        return data.getString(data.getColumnIndex(Tables.Transactions.Columns.comment));
    }
    public String getSumm()
    {
        return data.getString(data.getColumnIndex(Tables.Transactions.Columns.summ));
    }
}