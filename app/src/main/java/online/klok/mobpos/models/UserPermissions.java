package online.klok.mobpos.models;

import online.klok.mobpos.database.helper.DatabaseQueryGeneratorException;

public class UserPermissions {
    public static final String TABLE_NAME = "UserPermissions";

    public static final int COLUMN_INDEX_CODE = 0;
    public static final String COLUMN_NAME_CODE = "ID";

    public static final int COLUMN_INDEX_ISADMIN = 1;
    public static final String COLUMN_NAME_ISADMIN = "IsAdmin";

    public static final int COLUMN_INDEX_ISDISABLED = 2;
    public static final String COLUMN_NAME_ISDISABLED = "IsDisabled";

    public static final String[] ALL_COLUMN_NAMES = {
            "Code",
            "IsAdmin",
            "IsDisabled"
    };

    public static int getIndexForColumnName(final String column) throws DatabaseQueryGeneratorException {

        switch (column) {

            case "Code":
                return 0;


            case "IsAdmin":
                return 1;


            case "IsDisabled":
                return 2;


        }
        throw new DatabaseQueryGeneratorException("Invalid column id specified");
    }

    public static String getColumnNameForIndex(final int columnIndex) throws DatabaseQueryGeneratorException {

        switch (columnIndex) {

            case 0:
                return "Code";


            case 1:
                return "IsAdmin";


            case 2:
                return "IsDisabled";


        }
        throw new DatabaseQueryGeneratorException("Invalid column index specified");
    }

}
