package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class PaymentMode {
    public static final String TABLE_NAME = "PaymentMode";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_NAME = 1;
    public static final String COLUMN_NAME_NAME = "Name";

    public static final int COLUMN_INDEX_CODE = 2;
    public static final String COLUMN_NAME_CODE = "Code";
    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "Name",
            "Code",
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "Name":
                return 1;


            case "Code":
                return 2;


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
                return "Code";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }
}
