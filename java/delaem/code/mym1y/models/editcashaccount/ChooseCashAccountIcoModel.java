package delaem.code.mym1y.models.editcashaccount;

import delaem.code.mym1y.models.Model;

public class ChooseCashAccountIcoModel
        extends Model<int[]>
{
    int currentIco;

    @Override
    public void readyItem(int i)
    {
        currentIco = data[i];
    }

    @Override
    public int getItemCount()
    {
        if(data == null)
        {
            return 0;
        }
        return data.length;
    }

    public int getIco()
    {
        return currentIco;
    }

    @Override
    public void clearData()
    {
        data = null;
    }
}