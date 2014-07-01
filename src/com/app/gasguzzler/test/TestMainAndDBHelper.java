package com.app.gasguzzler.test;
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
		dbHelper.eraseDBContents();
		
		/*
		price = 30;
		volume = 7.915;
		odometer = 20000;
		date = "12-07-1941 03:06:02";
		
		*/
		
		dbHelper.insertData(30, 7.915, 20000, "12-07-1941 03:06:02");
		
        assertTrue(dbHelper.getNumRows() == 1);
        assertTrue(dbHelper.getLastMileage() == 20000);
        assertTrue(dbHelper.getAveragePricePerGallon() == 3.79);
        assertTrue(dbHelper.getAverageVolume() == 7.92);
        
		
        
        dbHelper.insertData( 4, 1, 20020, "05-23-1221 31:23:02");
        
		assertTrue(dbHelper.getNumRows() == 2);
		assertTrue(dbHelper.getLastMileage() == 20020);
		assertTrue(dbHelper.getAveragePricePerGallon() == 3.90);
		assertTrue(dbHelper.getAverageVolume() == 4.46);
		assertTrue(dbHelper.getAverageMPGS() == 20);
		
		
		dbHelper.insertData( 24, 6.486, 20117.29, "07-05-1981 21:33:22");
        
		assertTrue(dbHelper.getNumRows() == 3);
		assertTrue(dbHelper.getLastMileage() == 20117.29);
		assertTrue(dbHelper.getAveragePricePerGallon() == 3.83);
		assertTrue(dbHelper.getAverageVolume() == 5.13);
		assertTrue(dbHelper.getAverageMPGS() == 17.5);
		
		dbHelper.insertData( 37.59, 10, 20417.29, "02-03-2001 31:23:02");
        
		assertTrue(dbHelper.getNumRows() == 4);
		assertTrue(dbHelper.getLastMileage() == 20417.29);
		assertTrue(dbHelper.getAveragePricePerGallon() == 3.82);
		assertTrue(dbHelper.getAverageVolume() == 6.35);
		assertTrue(dbHelper.getAverageMPGS() == 21.67);
		
		
		
		
		dbHelper.close();
	}
	
	protected void tearDown() throws Exception {
		
		solo.finishOpenedActivities();
	}

}

