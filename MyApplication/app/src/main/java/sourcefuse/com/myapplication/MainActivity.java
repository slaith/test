package sourcefuse.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_main );


		findViewById ( R.id.gray ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				gray ( imageView, sourceBitmap );
			}
		} );
		findViewById ( R.id.bright ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				bright ( imageView, sourceBitmap );
			}
		} );
		findViewById ( R.id.dark ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				dark ( imageView, sourceBitmap );
			}
		} );
		findViewById ( R.id.gama ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				gama ( imageView, sourceBitmap );
			}
		} );
		findViewById ( R.id.green ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				green ( imageView, sourceBitmap );
			}
		} );
		findViewById ( R.id.blue ).setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				ImageView imageView = ( ImageView ) findViewById ( R.id.Image );
				Bitmap sourceBitmap = BitmapFactory.decodeResource ( getResources ( ), R.drawable.images );

				blue ( imageView, sourceBitmap );
			}
		} );
	}

	public void gray ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );
		double red = 0.33;
		double green = 0.59;
		double blue = 0.11;

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );

				r = ( int ) red * r;
				g = ( int ) green * g;
				b = ( int ) blue * b;
				operation.setPixel ( i, j, Color.argb ( Color.alpha ( p ), r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}

	public void bright ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );
				int alpha = Color.alpha ( p );

				r = 100 + r;
				g = 100 + g;
				b = 100 + b;
				alpha = 100 + alpha;
				operation.setPixel ( i, j, Color.argb ( alpha, r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}

	public void dark ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );
				int alpha = Color.alpha ( p );

				r = r - 50;
				g = g - 50;
				b = b - 50;
				alpha = alpha - 50;
				operation.setPixel ( i, j, Color.argb ( Color.alpha ( p ), r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}

	public void gama ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );
				int alpha = Color.alpha ( p );

				r = r + 150;
				g = 0;
				b = 0;
				alpha = 0;
				operation.setPixel ( i, j, Color.argb ( Color.alpha ( p ), r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}

	public void green ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );
				int alpha = Color.alpha ( p );

				r = 0;
				g = g + 150;
				b = 0;
				alpha = 0;
				operation.setPixel ( i, j, Color.argb ( Color.alpha ( p ), r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}

	public void blue ( ImageView view, Bitmap bitmap ) {
		Bitmap operation = Bitmap.createBitmap ( bitmap.getWidth ( ), bitmap.getHeight ( ), bitmap.getConfig ( ) );

		for ( int i = 0 ; i < bitmap.getWidth ( ) ; i++ ) {
			for ( int j = 0 ; j < bitmap.getHeight ( ) ; j++ ) {
				int p = bitmap.getPixel ( i, j );
				int r = Color.red ( p );
				int g = Color.green ( p );
				int b = Color.blue ( p );
				int alpha = Color.alpha ( p );

				r = 0;
				g = 0;
				b = b + 150;
				alpha = 0;
				operation.setPixel ( i, j, Color.argb ( Color.alpha ( p ), r, g, b ) );
			}
		}
		view.setImageBitmap ( operation );
	}
}
