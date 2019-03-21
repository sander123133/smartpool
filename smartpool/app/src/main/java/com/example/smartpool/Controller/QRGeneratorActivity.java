package com.example.smartpool.Controller;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.smartpool.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * Created by Gebruiker on 8-12-2017.
 */

public class QRGeneratorActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean doneLoading;
    private ProgressBar progressBar;


    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_qr_generator);

        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.activity_qrgenerator_progressbar);
            new Thread(() -> {
                try {
                    bitmap = TextToImageEncode("gas the jews 2: a new hope");

                    runOnUiThread(() -> {
                        imageView.setImageBitmap(bitmap);
                    });
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.colorPrimaryDark):getResources().getColor(R.color.common_google_signin_btn_text_dark_pressed);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);

        runOnUiThread(() -> progressBar.setVisibility(View.INVISIBLE));
        return bitmap;
    }
}