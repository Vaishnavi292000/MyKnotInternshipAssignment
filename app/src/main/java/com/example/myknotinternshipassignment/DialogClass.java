package com.example.myknotinternshipassignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import java.io.IOException;
import java.net.URL;

public class DialogClass{

    SwipeDismissDialog swipeDismissDialog;

    public void showDialog(String title, String img, String successurl,Context context) throws IOException {
        View dialog= LayoutInflater.from(context).inflate(R.layout.dialog_layout,null);
        swipeDismissDialog=new SwipeDismissDialog.Builder(context)
                .setView(dialog)
                .build()
                .show();

        Button success=dialog.findViewById(R.id.bt_success);
        TextView textView=dialog.findViewById(R.id.tv_title);
        ImageView imageView=dialog.findViewById(R.id.iv_image);

        textView.setText(title);

        Glide.with(context)
                .load(img)
                .into(imageView);

        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(successurl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
    }

}
