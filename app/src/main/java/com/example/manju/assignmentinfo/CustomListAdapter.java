package com.example.manju.assignmentinfo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Assesment> {
    ArrayList<Assesment> asesment;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Assesment> asesment) {
        super(context, resource, asesment);
        this.asesment = asesment;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_new, null, true);

        }
        Assesment assesment = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(context).load(assesment.getImageHref()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.title);
        txtName.setText(assesment.getTitle());

        TextView txtPrice = (TextView) convertView.findViewById(R.id.category);
        txtPrice.setText(assesment.getDescription());

        return convertView;

    }
}
