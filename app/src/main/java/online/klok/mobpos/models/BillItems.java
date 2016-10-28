package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class BillItems {
    public static final String TABLE_NAME = "BillItems";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_BILLNAME = 1;
    public static final String COLUMN_NAME_BILLNAME = "BillNumber";

    public static final int COLUMN_INDEX_ITEMCODE = 2;
    public static final String COLUMN_NAME_ITEMCODE = "ItemCode";

    public static final int COLUMN_INDEX_QUANTITY = 3;
    public static final String COLUMN_NAME_QUANTITY = "Quantity";

    public static final int COLUMN_INDEX_TOTALITEMS = 4;
    public static final String COLUMN_NAME_TOTALITEMS = "TotalItems";

    public static final int COLUMN_INDEX_ITEMDISCOUNT = 5;
    public static final String COLUMN_NAME_ITEMDISCOUNT = "ItemDiscount";

    public static final int COLUMN_INDEX_ITEMTOTAL = 6;
    public static final String COLUMN_NAME_ITEMTOTAL = "ItemTotal";


    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "BillNumber",
            "ItemCode",
            "Quantity",
            "SalesRate",
            "TotalItems",
            "ItemDiscount",
            "ItemTotal"
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "BillNumber":
                return 1;


            case "ItemCode":
                return 2;


            case "Quantity":
                return 3;


            case "SalesRate":
                return 4;


            case "TotalItems":
                return 5;


            case "ItemDiscount":
                return 6;


            case "ItemTotal":
                return 7;


        }
        throw new DatabaseQueryGeneratorException("Invalid column id specified");
    }

    public static String getColumnNameForIndex(final int columnIndex) throws DatabaseQueryGeneratorException {

        switch (columnIndex) {

            case 0:
                return "ID";


            case 1:
                return "BillNumber";


            case 2:
                return "ItemCode";


            case 3:
                return "Quantity";


            case 4:
                return "SalesRate";


            case 5:
                return "TotalItems";


            case 6:
                return "ItemDiscount";


            case 7:
                return "ItemTotal";

        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }

}
