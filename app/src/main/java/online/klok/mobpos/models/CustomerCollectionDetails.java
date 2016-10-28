package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class CustomerCollectionDetails {
    public static final String TABLE_NAME = "CustomerCollectionDetails";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_CODE = 1;
    public static final String COLUMN_NAME_CODE = "Code";

    public static final int COLUMN_INDEX_SHORTNAME = 2;
    public static final String COLUMN_NAME_SHORTNAME = "CreditLimit";

    public static final int COLUMN_INDEX_PASSWORD = 3;
    public static final String COLUMN_NAME_PASSWORD = "ContactNumber";

    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "Code",
            "CreditLimit",
            "ContactNumber"
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "Code":
                return 1;


            case "CreditLimit":
                return 2;


            case "ContactNumber":
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
                return "CreditLimit";


            case 3:
                return "ContactNumber";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }
}
