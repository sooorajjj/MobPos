package online.klok.mobpos.database.helper;

import java.util.ArrayList;
import java.util.HashMap;

import online.klok.mobpos.models.DatabaseColumn;


public class DatabaseQueryGenerator {
    private ArrayList<DatabaseColumn> columns = new ArrayList<>();
    private HashMap<String, Integer> columnToIndexMap = new HashMap<>();
    private String tableName;

    public DatabaseQueryGenerator(String tableName)
            throws DatabaseQueryGeneratorException {
        this.tableName = tableName;
        if (tableName.length() == 0)
            throw new DatabaseQueryGeneratorException("Invalid Table Name");

    }

    public DatabaseQueryGenerator(String tableName, final ArrayList<DatabaseColumn> columns)
            throws DatabaseQueryGeneratorException {

        this.columns = columns;
        this.tableName = tableName;

        if (tableName.length() == 0)
            throw new DatabaseQueryGeneratorException("Invalid Table Name");
    }

    public void reset() {
        columnToIndexMap.clear();
        columns.clear();
    }

    private void mapColumnsToIndex() {

        columnToIndexMap.clear();
        for (int i = 0; i < columns.size(); i++) {
            columnToIndexMap.put(columns.get(i).getName(), i);
        }

    }

    public final DatabaseQueryGenerator putNewColumn(final DatabaseColumn column) {
        columns.add(column);
        return this;
    }

    public boolean removeColumn(String columnName) {

        DatabaseColumn foundColumn = null;

        for (final DatabaseColumn currentCol :
                columns) {
            if (currentCol.getName().equalsIgnoreCase(columnName)) {
                foundColumn = currentCol;
                break;
            }
        }

        if (foundColumn != null) {
            if (columnToIndexMap.containsKey(foundColumn.getName()))
                columnToIndexMap.remove(foundColumn.getName());
            columns.remove(foundColumn);
        }
        return foundColumn != null;

    }

    public int getColumnIndex(final DatabaseColumn column) throws DatabaseQueryGeneratorException {
        if (columnToIndexMap.size() == 0 || columnToIndexMap.size() != columns.size()) {
            throw new DatabaseQueryGeneratorException("Database columns added/removed, but indexes not mapped");
        }
        return columnToIndexMap.get(column.getName());
    }

    public String getGenerateTableQuery() throws DatabaseQueryGeneratorException {
        StringBuilder builder = new StringBuilder();

        if (columns.size() == 0) {
            throw new DatabaseQueryGeneratorException("Invalid column count");
        }
        mapColumnsToIndex();

        builder.append("CREATE TABLE ").append(tableName).append(" (");

        for (int i = 0; i < columns.size(); i++) {
            builder.append(columns.get(i).getName())
                    .append(" ")
                    .append(columns.get(i).getTypeSpecification())
                    .append(" ");
            if (i != columns.size() - 1)
                builder.append(',');
        }
        builder.append(");");

        return builder.toString();
    }
}