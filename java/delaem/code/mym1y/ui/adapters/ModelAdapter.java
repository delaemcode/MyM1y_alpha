package delaem.code.mym1y.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import delaem.code.mym1y.listeners.ui.adapters.IModelAdapter;
import delaem.code.mym1y.models.Model;
import delaem.code.mym1y.ui.holders.adapters.ModelHolder;

public abstract class ModelAdapter<MODELHOLDER extends ModelHolder, MODEL extends Model, LISTENER extends IModelAdapter>
        extends RecyclerView.Adapter<MODELHOLDER>
{
    private Context context;
    private MODEL model;
    private LISTENER listener;

    public ModelAdapter(Context c, MODEL m, LISTENER l)
    {
        this.context = c;
        this.model = m;
        this.listener = l;
    }

    @Override
    public void onBindViewHolder(MODELHOLDER holder, int position)
    {
        model.readyItem(position);
        setData(holder, model);
    }

    @Override
    public int getItemCount()
    {
        return model.getItemCount();
    }

    protected abstract void setData(MODELHOLDER holder, MODEL data);

    public MODEL getModel()
    {
        return model;
    }

    public Context getContext()
    {
        return context;
    }

    public LISTENER getListener()
    {
        return listener;
    }
}