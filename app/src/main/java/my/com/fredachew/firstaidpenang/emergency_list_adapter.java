package my.com.fredachew.firstaidpenang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class emergency_list_adapter extends ArrayAdapter<String> {

    String[] nameE ;
    int[] imagesE;
    Context mContextE;

    public emergency_list_adapter(Context context, int[] images, String[] title) {
        super(context, R.layout.activity_emergency_list);
        this.imagesE = images;
        this.nameE =title;
        this.mContextE = context;
    }

    @Override
    public int getCount() {
        return nameE.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContextE.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.activity_emergency_list, parent, false);
            mViewHolder.ivImageE = (ImageView) convertView.findViewById(R.id.emegency_imagView);
            mViewHolder.tvNameE = (TextView) convertView.findViewById(R.id.emegency_textView);

            mViewHolder.ivImageE.setImageResource(imagesE[position]);
            mViewHolder.tvNameE.setText(nameE[position]);


            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView ivImageE;
        TextView tvNameE;
    }
}
