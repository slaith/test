package sourcefuse.com.croppersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
	}

	public void onClick ( View view ) {
		switch ( view.getId() ) {

			case R.id.EdmodoActivity:
				Intent intent = new Intent( this, EdmodoActivity.class );
				startActivity( intent );
				break;
		}
	}
}
