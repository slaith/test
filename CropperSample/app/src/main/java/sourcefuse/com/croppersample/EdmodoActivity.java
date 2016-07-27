package sourcefuse.com.croppersample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;


/**
 * Created by prafull on 12/7/16.
 */
public class EdmodoActivity extends Activity {

	ImageView imageView;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.edmodo_activity );
		imageView = (ImageView) findViewById( R.id.imageView );
		Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.ic_menu_3d_globe );


		File croppedImageFile = new File(getFilesDir(), "test.jpg");
		Uri croppedImage = Uri.fromFile(croppedImageFile);
		CropImageIntentBuilder cropImage = new CropImageIntentBuilder( 200, 200, croppedImage );
		cropImage.setOutlineColor( 0xFF03A9F4 );
		cropImage.setBitmap( bitmap );

	}

	public void onClick ( View view ) {
		switch ( view.getId() ) {

			case R.id.crop_image_menu_crop:
				imageView.setVisibility( View.VISIBLE );
				break;
		}
	}
}
