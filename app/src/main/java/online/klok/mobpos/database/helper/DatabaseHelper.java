package online.klok.mobpos.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import online.klok.mobpos.models.BillHeader;
import online.klok.mobpos.models.BillItems;
import online.klok.mobpos.models.CustomerCollectionDetails;
import online.klok.mobpos.models.CustomerHeader;
import online.klok.mobpos.models.DatabaseColumn;
import online.klok.mobpos.models.ItemStock;
import online.klok.mobpos.models.Items;
import online.klok.mobpos.models.PaymentMode;
import online.klok.mobpos.models.UserPermissions;
import online.klok.mobpos.models.Users;

/**
 * Created by klok on 28/10/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    Context parentContext;

    public DatabaseHelper(Context context) {
        super(context, CommonDatabaseParameters.DATABASE_FILE_NAME, null, CommonDatabaseParameters.DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CustomerHeader.TABLE_NAME+ ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CustomerCollectionDetails.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Items.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ItemStock.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Users.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ UserPermissions.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ PaymentMode.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ BillHeader.TABLE_NAME + ";");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ BillItems.TABLE_NAME + ";");


        try {
            createCustomerHeaderTable(sqLiteDatabase);
            createCustomerCollectionDetails(sqLiteDatabase);
            createItems(sqLiteDatabase);
            createItemStock(sqLiteDatabase);
            createUsers(sqLiteDatabase);
            createUserPermissions(sqLiteDatabase);
            createPaymentMode(sqLiteDatabase);
            createBillHeader(sqLiteDatabase);
            createBillItems(sqLiteDatabase);
        } catch (DatabaseQueryGeneratorException e) {
            e.printStackTrace();
        }

    }

    private void createCustomerHeaderTable(SQLiteDatabase sqLiteDatabase) throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(CustomerHeader.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Name", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("ShortName", " VARCHAR(20) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Password", " VARCHAR(20) NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery();
        sqLiteDatabase.execSQL(generatedQuery);

    }


    private void createCustomerCollectionDetails(SQLiteDatabase sqLiteDatabase)throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(CustomerCollectionDetails.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("CreditLimit", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("ContactNumber", " VARCHAR(20) NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery()+"FOREIGN KEY(`Code`) REFERENCES CustomerHeader (`Code`) ON UPDATE CASCADE";
        sqLiteDatabase.execSQL(generatedQuery);
    }


    private void createItems(SQLiteDatabase sqLiteDatabase)throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(Items.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("SalesRates", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Name", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("ShortName", " VARCHAR(20) NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery();
        sqLiteDatabase.execSQL(generatedQuery);
    }


    private void createItemStock(SQLiteDatabase sqLiteDatabase)throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(ItemStock.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("CreditLimit", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("StockUpdatedOn", " DATETIME NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery()+
                "FOREIGN KEY(`Code`) REFERENCES ItemStock (`Code`) ON UPDATE CASCADE";
        sqLiteDatabase.execSQL(generatedQuery);
    }


    private void createUsers(SQLiteDatabase sqLiteDatabase) throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(Users.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Name", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("ShortName", " VARCHAR(20) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Password", " VARCHAR(20) NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery();
        sqLiteDatabase.execSQL(generatedQuery);

    }

    private void createUserPermissions(SQLiteDatabase sqLiteDatabase)throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(UserPermissions.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("IsAdmin", " INTEGER NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("IsDisabled", " INTEGER NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery()+"FOREIGN KEY(`Code`) REFERENCES Users (`Code`) ON UPDATE CASCADE";
        sqLiteDatabase.execSQL(generatedQuery);
    }


    private void createPaymentMode(SQLiteDatabase sqLiteDatabase) throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(PaymentMode.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Name", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("Code", " VARCHAR(20) UNIQUE"));

        final String generatedQuery = generator.getGenerateTableQuery();
        sqLiteDatabase.execSQL(generatedQuery);

    }

    private void createBillHeader(SQLiteDatabase sqLiteDatabase) throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(BillHeader.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("Name", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("BillingUser", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("BilledCustomer", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("BillingTime", " DATETIME NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("BillAmount", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("TotalUniqueItems", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("TotalItems", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("PaymentMode", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("BillNumber", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("DeviceID", " VARCHAR(30) NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("IsDeleted", " INTEGER NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery()
                + "FOREIGN KEY(`BillingUser`) REFERENCES Users (`Code`) ON UPDATE CASCADE;"
                +"FOREIGN KEY(`BilledCustomer`) REFERENCES CustomerHeader (`Code`) ON UPDATE CASCADE;"
                +"FOREIGN KEY(`PaymentMode`) REFERENCES PaymentMode (`Code`) ON UPDATE CASCADE;";
        sqLiteDatabase.execSQL(generatedQuery);

    }

    private void createBillItems(SQLiteDatabase sqLiteDatabase) throws DatabaseQueryGeneratorException{
        final DatabaseQueryGenerator generator =
                new DatabaseQueryGenerator(BillItems.TABLE_NAME);
        generator.putNewColumn(new DatabaseColumn("ID", " INTEGER PRIMARY KEY AUTOINCREMENT"));
        generator.putNewColumn(new DatabaseColumn("BillNumber", " VARCHAR(30) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("ItemCode", " VARCHAR(20) UNIQUE"));
        generator.putNewColumn(new DatabaseColumn("Quantity", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("SalesRate", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("TotalItems", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("ItemDiscount", " NUMERIC NOT NULL"));
        generator.putNewColumn(new DatabaseColumn("ItemTotal", " NUMERIC NOT NULL"));

        final String generatedQuery = generator.getGenerateTableQuery()
                +"FOREIGN KEY(`BillNumber`) REFERENCES BillHeader (`BillNumber`) ON UPDATE CASCADE;"
                +"FOREIGN KEY(`ItemCode`) REFERENCES Items (`Code`) ON UPDATE CASCADE;";
        sqLiteDatabase.execSQL(generatedQuery);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}
