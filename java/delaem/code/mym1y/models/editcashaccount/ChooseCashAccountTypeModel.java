package delaem.code.mym1y.models.editcashaccount;

import delaem.code.mym1y.models.Model;

public class ChooseCashAccountTypeModel
        extends Model<int[]>
{
    int currentType;

    @Override
    public void readyItem(int i)
    {
        currentType = data[i];
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

    public int getType()
    {
        return currentType;
    }

    @Override
    public void clearData()
    {
        data = null;
    }
}