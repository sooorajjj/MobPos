package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class BillHeader {

    public static final String TABLE_NAME = "BillHeader";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_NAME = 1;
    public static final String COLUMN_NAME_NAME = "Name";

    public static final int COLUMN_INDEX_BILLINGUSER = 2;
    public static final String COLUMN_NAME_BILLINGUSER = "BillingUser";

    public static final int COLUMN_INDEX_BILLEDCUSTOMER = 3;
    public static final String COLUMN_NAME_BILLEDCUSTOMER = "BilledCustomer";

    public static final int COLUMN_INDEX_BILLINGTIME = 4;
    public static final String COLUMN_NAME_BILLINGTIME = "BillingTime";

    public static final int COLUMN_INDEX_BILLAMOUNT = 5;
    public static final String COLUMN_NAME_BILLAMOUNT = "BillAmount";

    public static final int COLUMN_INDEX_TOTALUNIQUEITEMS = 6;
    public static final String COLUMN_NAME_TOTALUNIQUEITEMS = "TotalUniqueItems";

    public static final int COLUMN_INDEX_TOTALITEMS = 7;
    public static final String COLUMN_NAME_TOTALITEMS = "TotalItems";

    public static final int COLUMN_INDEX_PAYMENTMODE = 8;
    public static final String COLUMN_NAME_PAYMENTMODE = "PaymentMode";

    public static final int COLUMN_INDEX_BILLNUMBER = 9;
    public static final String COLUMN_NAME_BILLNUMBER = "BillNumber";

    public static final int COLUMN_INDEX_DEVICEID = 10;
    public static final String COLUMN_NAME_DEVICEID = "DeviceID";

    public static final int COLUMN_INDEX_ISDELETED = 11;
    public static final String COLUMN_NAME_ISDELETED = "IsDeleted";

    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "Name",
            "BillingUser",
            "BilledCustomer",
            "BillingTime",
            "BillAmount",
            "TotalUniqueItems",
            "TotalItems",
            "PaymentMode",
            "BillNumber",
            "DeviceID",
            "IsDeleted"
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "Name":
                return 1;


            case "BillingUser":
                return 2;


            case "BilledCustomer":
                return 3;


            case "BillingTime":
                return 4;


            case "BillAmount":
                return 5;


            case "TotalUniqueItems":
                return 6;


            case "TotalItems":
                return 7;


            case "PaymentMode":
                return 8;


            case "BillNumber":
                return 9;


            case "DeviceID":
                return 10;


            case "IsDeleted":
                return 11;


        }
        throw new DatabaseQueryGeneratorException("Invalid column id specified");
    }

    public static String getColumnNameForIndex(final int columnIndex) throws DatabaseQueryGeneratorException {

        switch (columnIndex) {

            case 0:
                return "ID";


            case 1:
                return "Name";


            case 2:
                return "BillingUser";


            case 3:
                return "BilledCustomer";


            case 4:
                return "BillingTime";


            case 5:
                return "BillAmount";


            case 6:
                return "TotalUniqueItems";


            case 7:
                return "TotalItems";


            case 8:
                return "PaymentMode";


            case 9:
                return "BillNumber";


            case 10:
                return "DeviceID";


            case 11:
                return "IsDeleted";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }
}
