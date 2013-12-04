package com.example.game.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class StoreDatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "store.db";
	private static final int DATABASE_VERSION = 1;
	
	public StoreDatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		//TODO 
	}
	
	//Table names
	private static final String TABLE_SHOP = "shops";
	private static final String TABLE_PRODUCT = "products";
	private static final String TABLE_CATEGORY = "categories";
	private static final String TABLE_SHOP_PRODUCT = "shop_products";
	
	// Common Column name
	private static final String KEY_ID = "id";
	
	// Table Shop - Column
	private static final String KEY_SHOP_NAME = "shop_name";
	
	// Table Product - Column
	private static final String KEY_PRODUCT_NAME = "product_name";
	
	// Table Category - Column
	private static final String KEY_CATEGORY_ID = "category_id";
	private static final String KEY_CATEGORY_NAME = "category_name";
	
	// Table Shop_Products - Column
	private static final String KEY_PRODUCT_ID = "product_id";
	private static final String KEY_PRODUCT_COUNT = "count";
	private static final String KEY_SHOP_ID = "shop_id";
	private static final String KEY_PRODUCT_PRICE = "price";

	// Create Table Shop
	private static final String CREATE_TABLE_SHOP = "CREATE TABLE "
		+ TABLE_SHOP + "(" + KEY_ID + " LONG PRIMARY KEY AUTOINCREMENT, "
		+ KEY_SHOP_NAME + " TEXT" + ")";
	
	
	// Create Table product
	private static final String CREATE_TABLE_PRODUCT = "CREATE TABLE "+ TABLE_PRODUCT 
		+ "(" + KEY_ID + " LONG PRIMARY KEY AUTOINCREMENT, "
		+ KEY_PRODUCT_NAME + "TEXT, " 
		+ KEY_CATEGORY_ID + "INTEGER" + ")";
	
	
	// Create Table category
	private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "+ TABLE_CATEGORY 
		+" (" + KEY_ID + " LONG PRIMARY KEY AUTOINCREMENT," 
		+ KEY_CATEGORY_NAME + " TEXT" + ")";
	
	
	//Create Table Shop Product
	private static final String CREATE_TABLE_SHOP_PRODUCT = "CREATE TABLE "+ TABLE_SHOP_PRODUCT 
			+" (" + KEY_ID + " LONG PRIMARY KEY AUTOINCREMENT," 
			+ KEY_SHOP_ID + " INTEGER," 
			+ KEY_PRODUCT_ID + " INTEGER,"
			+ KEY_PRODUCT_COUNT + " INTEGER," 
			+ KEY_PRODUCT_PRICE + " INTEGER" + ")";

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SHOP);
		db.execSQL(CREATE_TABLE_PRODUCT);
		db.execSQL(CREATE_TABLE_CATEGORY);
		db.execSQL(CREATE_TABLE_SHOP_PRODUCT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);
			db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_PRODUCT);
			db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CATEGORY);
			db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SHOP_PRODUCT);
			this.onCreate(db);
		}
		
	}
	
	
	//SHOP CRUD
	
	public long createStore(Store shop) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_SHOP_NAME, shop.getName());
		long shop_id = db.insert(TABLE_SHOP, null, values);
		return shop_id;
	}
	
	
	
	public Cursor selectALL(Uri uri) {
		SQLiteDatabase db = this.getReadableDatabase();
		String[] columns = { "name" };
		Cursor cursor = db.query("Store", columns, null, null, null, null, null);
		return cursor;
	}
	
}
