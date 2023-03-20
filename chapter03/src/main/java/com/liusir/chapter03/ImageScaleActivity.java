package com.liusir.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageScaleActivity extends AppCompatActivity {

    private static ImageView ivPicture;
    private Button btnChangePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
        ivPicture = (ImageView) findViewById(R.id.iv_picture);
        btnChangePicture = (Button) findViewById(R.id.btn_change_picture);
        btnChangePicture.setOnClickListener(new PictureChangeListener());

        ivPicture.setImageResource(R.drawable.picture1);

    }


    static class PictureChangeListener implements View.OnClickListener {
        int[] pictures = new int[]{R.drawable.picture1, R.drawable.picture2};
        boolean pictureJudge=true ;
        @Override
        public void onClick(View v) {
            pictureJudge = !pictureJudge;
            if (pictureJudge) {
                ivPicture.setImageResource(R.drawable.picture1);
            }else {
                ivPicture.setImageResource(R.drawable.picture2);
            }
            ivPicture.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }
}