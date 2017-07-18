package my.com.fredachew.firstaidpenang;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;

public class MyAdapter extends ArrayAdapter<String> {

    String[] title;
    int[] images;

    Context mContext;

    public MyAdapter(Context context, String[] titleNames, int[] image) {
        super(context, R.layout.list_view_item);
        this.title = titleNames;
        this.images = image;

        this.mContext = context;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_view_item, parent, false);
            mViewHolder.ivImage = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.tvName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.ivImage.setImageResource(images[position]);
        mViewHolder.tvName.setText(title[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView ivImage;
        TextView tvName;
    }


}