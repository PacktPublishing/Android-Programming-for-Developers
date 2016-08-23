package com.gamecodeschool.whereitssnap3;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class CaptureFragment extends Fragment{

    private static final int CAMERA_REQUEST = 123;
    private ImageView mImageView;

    // Where the captured image is stored
    private Uri mImageUri = Uri.EMPTY;

    // A reference to our database
    private DataManager mDataManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataManager = new DataManager(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout file then get all necessary references
        View view = inflater.inflate(R.layout.fragment_capture, container, false);

        mImageView = (ImageView)view.findViewById(R.id.imageView);
        Button btnCapture = (Button)view.findViewById(R.id.btnCapture);
        Button btnSave = (Button)view.findViewById(R.id.btnSave);

        final EditText mEditTextTitle = (EditText)view.findViewById(R.id.editTextTitle);
        final EditText mEditTextTag1 = (EditText)view.findViewById(R.id.editTextTag1);
        final EditText mEditTextTag2 = (EditText)view.findViewById(R.id.editTextTag2);
        final EditText mEditTextTag3 = (EditText)view.findViewById(R.id.editTextTag3);


        // Listen for clicks on the capture button
        btnCapture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // This code is the same as our Simple camera mini-app
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        // Listen for clicks on the save button
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!mImageUri.equals(Uri.EMPTY)) {
                    // We have a photo to save

                    Photo photo = new Photo();
                    photo.setTitle(mEditTextTitle.getText().toString());
                    photo.setStorageLocation(mImageUri);

                    // What is in the tags
                    String tag1 = mEditTextTag1.getText().toString();
                    String tag2 = mEditTextTag2.getText().toString();
                    String tag3 = mEditTextTag3.getText().toString();

                    // Assign the strings to the Photo object
                    photo.setTag1(tag1);
                    photo.setTag2(tag2);
                    photo.setTag3(tag3);

                    // Send the new object to our DataManager
                    mDataManager.addPhoto(photo);
                }else {
                    // No image
                    Toast.makeText(getActivity(), "No image to save", Toast.LENGTH_LONG);
                }

            }
        });

        return view;
    }

    /*
        The only difference here is that onActivityResult for fragments
        is public instead of protected and the static final int RESULT_OK
        is accessed via getActivity()
    */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {

            // Capture the image that was taken - if any
            Bitmap image = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(image);

            // Get the URI of the image and change it to a string
            mImageUri = data.getData();

        }
    }


}
