package com.example.ocr;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageScreen;
    private TextView TextDisplay;
    //private Button CaptureBtn;
    //private Button DetectBtn;

    private Button ConfirmBtn;

    private Bitmap bitmap;
    //private static final int REQUEST_CAMERA_CODE = 100;

    ActivityResultLauncher launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaration
        ImageScreen = findViewById(R.id.image_screen);
        TextDisplay = findViewById(R.id.text_display);
        //CaptureBtn = findViewById(R.id.CaptureBtn);
        //DetectBtn = findViewById(R.id.DetectBtn);

        ConfirmBtn = findViewById(R.id.ConfirmBtn);

        //Alternative for startActivityForResult()
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    //read image from ActivityResult object
                    Intent intent = result.getData();
                    bitmap = (Bitmap) intent.getExtras().get("data");
                    //set bitmap in ImageView
                    ImageScreen.setImageBitmap(bitmap);

                    //process the image
                    //Create a FirebaseVisionImage object from a Bitmap object
                    FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(bitmap);
                    //Get an instance of FirebaseVision
                    FirebaseVision firebaseVision = FirebaseVision.getInstance();
                    //Create an instance of FirebaseVisionTextRecognizer
                    FirebaseVisionTextRecognizer firebaseVisionTextRecognizer = firebaseVision.getOnDeviceTextRecognizer();
                    //Create a task to process the image
                    Task<FirebaseVisionText> task = firebaseVisionTextRecognizer.processImage(firebaseVisionImage);

                    //If task is successful, display the text on-screen
                    task.addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                        @Override
                        public void onSuccess(FirebaseVisionText firebaseVisionText) {

                            TextDisplay.setVisibility(View.VISIBLE);

                            String s = firebaseVisionText.getText();
                            TextDisplay.setText(s);
                        }
                    });

                    //If task fail
                    task.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                });
    }

    //Process after CaptureBtn is clicked
    public void doProcess(View view) {
        //check application level permission is granted for camera
        if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            //Open the camera
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            launcher.launch(intent);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ConfirmBtn.setVisibility(View.VISIBLE);
                }
            }, 3000);

        }
        else{
            //prompt the user to grant permission for camera
            requestPermissions(
                    new String[]{Manifest.permission.CAMERA},
                    101
            );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Confirm(View view) {
       Intent intent = new Intent(getApplicationContext(), InventoryOption.class);
        startActivity(intent);
    }
}