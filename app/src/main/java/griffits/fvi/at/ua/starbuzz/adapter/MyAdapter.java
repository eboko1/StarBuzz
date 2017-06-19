package griffits.fvi.at.ua.starbuzz.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Vika on 19.06.2017.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    private ArrayList<Integer> listId;
    private ArrayList<String> nameList;

    public MyAdapter(Context context, ArrayList<Integer> listId, ArrayList<String> nameList) {
        this.context = context;
        this.listId = listId;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return nameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
