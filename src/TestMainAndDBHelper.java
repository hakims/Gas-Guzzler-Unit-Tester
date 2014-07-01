import junit.framework.TestCase;


import java.io.File;

import android.database.sqlite.SQLiteDatabase;
import android.test.ActivityInstrumentationTestCase2;

import com.app.gasguzzler.DatabaseHelper;
import com.app.gasguzzler.MainActivity;
import com.robotium.solo.Solo;

public class TestMainAndDBHelper extends ActivityInstrumentationTestCase2<MainActivity> {

	private
		
		Solo solo;
		DatabaseHelper dbHelper;
		
		double price;
		double volume;
		double odometer;
		String date;
	
		double ppg;
		double mpg;
		double avgVol;
		
		//blalba
		
	
	public TestMainAndDBHelper() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
		dbHelper = new DatabaseHelper(getActivity().getApplicationContext());
		dbHelper.eraseDBContents();
	}

	public void testDB()
	{
		price = 31;
		volume = 7;
		odometer = 1000;
		date = "12-07-1941 03:06:02";
		
		dbHelper.insertData(price, volume, odometer, date);
		
        assertTrue(dbHelper.getNumRows() == 1);
        assertTrue(dbHelper.getLastMileage() == 1000);
        assertTrue(dbHelper.getAveragePricePerGallon() == 4.43);
        
		dbHelper.insertData( 56, 12, 1600, "05-23-1221 31:23:02");
        
		assertTrue(dbHelper.getNumRows() == 2);
		assertTrue(dbHelper.getLastMileage() == 1600);
		assertTrue(dbHelper.getAverageMPGS() == 50);
		
		
		//assertTrue(dbHelper.getAveragePricePerGallon() == 4.45);
		
		dbHelper.close();
	}
	
	protected void tearDown() throws Exception {
		
		solo.finishOpenedActivities();
	}

}

