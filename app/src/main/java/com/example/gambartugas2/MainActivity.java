package com.example.gambartugas2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint(); //digunakan untuk menggambar objek
    private Paint mPaintText = new Paint(); //digunakan untuk membuat tulisan atau label
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mRect = new Rect();
    private Rect mBounds = new Rect();

    private static final int OFFSET = 120; //untuk mengatur posisi dari objek
    private int mOffset = OFFSET;
    private static final int COUNT = 0;
    private int count = COUNT;

    private int mColorBackground;
    private int mColorRetangle;
    private int mColorAtap;
    private int mColorDoor;
    private int mColorSun;
    private int mColorPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.colorBackground, null);
        mColorRetangle = ResourcesCompat.getColor(getResources(), R.color.colorHome, null);
        mColorAtap = ResourcesCompat.getColor(getResources(), R.color.colorAtap, null);
        mColorDoor = ResourcesCompat.getColor(getResources(), R.color.colorDoor, null);
        mColorSun = ResourcesCompat.getColor(getResources(), R.color.colorSun, null);
        mColorPlant = ResourcesCompat.getColor(getResources(), R.color.colorPlant, null);

        mPaint.setColor(mColorBackground);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
        mPaintText.setTextSize(70);

        mImageView = findViewById(R.id.myimageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v);
            }
        });
    }

    public void drawSomething(View view){
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;

        if (mOffset == OFFSET){
            mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap); //baru draw text
            mCanvas.drawColor(mColorBackground); //untuk memberi warna pada background

            mPaintText.setTextSize(50);
            mCanvas.drawText(getString(R.string.keep_tapping), 100, 100, mPaintText);

            count += 1;
            mOffset += OFFSET;
        }
        else {
            if (count == 1){
                mPaint.setColor(mColorRetangle);
                mRect.set(mOffset-100, mOffset+700, vWidth - mOffset + 100, vHeight - mOffset);
                mCanvas.drawRect(mRect, mPaint);
                count += 1;
                mOffset += OFFSET;
            }
            else if (count == 2){

                mPaint.setColor(mColorRetangle);
                mRect.set(230, 400, vWidth-700, vHeight - 1100);
                mCanvas.drawRect(mRect, mPaint);

                count += 1;
                mOffset += OFFSET;
            }
            else if (count == 3){

                Path path = new Path();
                path.moveTo(550, 300); // Top
                path.lineTo(90, 940); // Bottom left
                path.lineTo(990, 940); // Bottom right
                path.lineTo(550, 300); // Back to Top
                path.close();
                mPaint.setColor(mColorAtap);
                mCanvas.drawPath(path, mPaint);

                count += 1;
                mOffset += OFFSET;
            }
            else if (count == 4){
                mPaint.setColor(mColorDoor);
                mRect.set(mOffset-400, mOffset + 750, vWidth-600, vHeight - 240);
                mCanvas.drawRect(mRect, mPaint);

                mPaint.setColor(mColorAtap);
                mCanvas.drawCircle(halfWidth-280, halfHeight+550, halfWidth /20, mPaint);

                count += 1;
                mOffset += OFFSET;
            }
            else if (count==5){
                mPaint.setColor(mColorDoor);
                mCanvas.drawCircle(halfWidth+160, halfHeight+140, halfWidth / 4, mPaint);

                mPaint.setColor(mColorBackground);
                mCanvas.drawCircle(halfWidth+160, halfHeight+140, halfWidth / 5, mPaint);

                mPaint.setColor(mColorDoor);
                mPaint.setAntiAlias(true);
                mPaint.setDither(true);
                mPaint.setStrokeJoin(Paint.Join.ROUND);
                mPaint.setStrokeCap(Paint.Cap.ROUND);
                mPaint.setStrokeWidth(30); //ukuran kuas

                mCanvas.drawLine(700, 1035, 700, 1270, mPaint);

                mCanvas.drawLine(600, 1155, 800, 1155, mPaint);

                count += 1;
                mOffset += OFFSET;
            }
            else if (count == 6){
                mPaint.setColor(mColorSun);
                mCanvas.drawCircle(800, 220, halfWidth / 6, mPaint);

                mPaint.setColor(mColorDoor);
                mPaint.setAntiAlias(true);
                mPaint.setDither(true);
                mPaint.setStrokeJoin(Paint.Join.ROUND);
                mPaint.setStrokeCap(Paint.Cap.ROUND);
                mPaint.setStrokeWidth(8); //ukuran kuas

                mCanvas.drawLine(680, 90, 720, 140, mPaint);
                mCanvas.drawLine(930, 90, 890, 140, mPaint);
                mCanvas.drawLine(975, 180, 915, 210, mPaint);
                mCanvas.drawLine(625, 180, 695, 210, mPaint);
                mCanvas.drawLine(800, 50, 800, 100, mPaint);
                mCanvas.drawLine(800, 330, 800, 400, mPaint);
                mCanvas.drawLine(700, 270, 620, 300, mPaint);
                mCanvas.drawLine(900, 270, 980, 290, mPaint);
                mCanvas.drawLine(910, 380, 860, 320, mPaint);
                mCanvas.drawLine(690, 380, 730, 320, mPaint);

                count += 1;
                mOffset += OFFSET;

            }
            else if (count == 7){
                mPaint.setColor(mColorPlant);

                //Tumbuhan
                mCanvas.drawCircle(700, 1690, halfWidth / 6, mPaint);
                mCanvas.drawCircle(720, 1600, halfWidth / 6, mPaint);
                mCanvas.drawCircle(800, 1650, halfWidth / 6, mPaint);
                mCanvas.drawCircle(800, 1690, halfWidth / 6, mPaint);
                mCanvas.drawCircle(850, 1600, halfWidth / 6, mPaint);
                mCanvas.drawCircle(900, 1550, halfWidth / 6, mPaint);
                mCanvas.drawCircle(980, 1580, halfWidth / 6, mPaint);
                mCanvas.drawCircle(1100, 1530, halfWidth / 6, mPaint);

                mRect.set(mOffset-270, mOffset+600, vWidth, 1780);
                mCanvas.drawRect(mRect, mPaint);

                //Buah
                mPaint.setColor(Color.RED);
                mCanvas.drawCircle(700, 1690, halfWidth / 20, mPaint);
                mCanvas.drawCircle(920, 1650, halfWidth / 20, mPaint);
                mCanvas.drawCircle(800, 1600, halfWidth / 20, mPaint);
                mCanvas.drawCircle(1000, 1570, halfWidth / 20, mPaint);

                count += 1;
                mOffset += OFFSET;
            }
            else{
                String text = getString(R.string.house);

                // Get bounding box for text to calculate where to draw it.
                mPaintText.getTextBounds(text, 0, text.length(), mBounds);

                // Calculate x and y for text so it's centered.
                int x = halfWidth - mBounds.centerX();
                int y = halfHeight + 900;
                mCanvas.drawText(text, x, y, mPaintText);

                mCanvas.drawText(getString(R.string.done), 100, 200, mPaintText);

            }
        }
        view.invalidate();
    }
}