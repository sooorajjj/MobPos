package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

/**
 * Created by klok on 28/10/16.
 */
public class Items {

    public static final String TABLE_NAME = "Items";

    public static final int COLUMN_INDEX_ID = 0;
    public static final String COLUMN_NAME_PRIMARY_KEY = "ID";

    public static final int COLUMN_INDEX_CODE = 1;
    public static final String COLUMN_NAME_CODE = "Code";

    public static final int COLUMN_INDEX_NAME = 2;
    public static final String COLUMN_NAME_NAME = "Name";

    public static final int COLUMN_INDEX_SHORTNAME = 3;
    public static final String COLUMN_NAME_SHORTNAME = "ShortName";


    public static final String[] ALL_COLUMN_NAMES = {
            "ID",
            "Code",
            "Name",
            "ShortName",
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "ID":
                return 0;


            case "Code":
                return 1;


            case "Name":
                return 2;


            case "ShortName":
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
                return "Name";


            case 3:
                return "ShortName";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }
}
