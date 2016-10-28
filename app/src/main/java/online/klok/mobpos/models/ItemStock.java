package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class ItemStock {
    public static final String TABLE_NAME = "ItemStock";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_CODE = 1;
    public static final String COLUMN_NAME_CODE = "Code";

    public static final int COLUMN_INDEX_STOCKQUANTITY = 2;
    public static final String COLUMN_NAME_STOCKQUANTITY = "StockQuantity";

    public static final int COLUMN_INDEX_STOCKUPDATEDON = 3;
    public static final String COLUMN_NAME_STOCKUPDATEDON = "StockUpdatedOn";

    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "Code",
            "StockQuantity",
            "StockUpdatedOn"
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "Code":
                return 1;


            case "StockQuantity":
                return 2;


            case "StockUpdatedOn":
                return 3;


        }
        throw new DatabaseQueryGeneratorException("Invalid column id specified");
    }

    public static String getColumnNameForIndex(final int columnIndex) throws DatabaseQueryGeneratorException {

        switch (columnIndex) {

            case 0:
                return "ID";


            case 1:
                return "Code";


            case 2:
                return "StockQuantity";


            case 3:
                return "StockUpdatedOn";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }
}
