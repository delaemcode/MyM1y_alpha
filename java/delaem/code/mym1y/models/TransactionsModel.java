package delaem.code.mym1y.models;

import delaem.code.mym1y.db.Tables;

public class TransactionsModel
        extends CursorModel
{
    public String getCashAccountFrom()
    {
        return data.getString(data.getColumnIndex(Tables.Transactions.Columns.cash_account_from_id));
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