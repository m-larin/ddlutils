package org.apache.commons.sql.type;

import org.apache.commons.sql.model.Column;


/**
 * This class describes a mapping between a standard JDBC type and the 
 * provider specific implementation of that type.
 * 
 * @version     1.1 2003/02/05 08:08:37
 * @author      <a href="mailto:tima@intalio.com">Tim Anderson</a>
 */
public class Mapping {

    /**
     * Format indicating to use the column type's size, if it is &gt; 1
     */
    public static final String SIZE_FORMAT = "size";

    /**
     * Format indicating to use the column type's size and scale
     * if they are non-zero
     */
    public static final String SIZE_SCALE_FORMAT = "size-scale";

    /**
     * The name of the type, corresponding to one declared in 
     * {@link java.sql.Types}
     */
    private String name;

    /**
     * The SQL name of the type. This may be provider specific.
     */
    private String sqlName;

    /**
     * The format of the size/scale
     */
    private String format;

    /**
     * Construct a new <code>Mapping</code>
     */
    public Mapping() {
    }

    public Mapping(String name, String sqlName, String format) {
        this.name = name;
        this.sqlName = sqlName;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSQLName() {
        return sqlName;
    }

    public void setSQLName(String name) {
        sqlName = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSQLType(Column column) {
        StringBuffer result = new StringBuffer(sqlName);
        int size = column.getSize();
        int scale = column.getScale();
        if (SIZE_FORMAT.equals(format)) {
            if (size > 1) {
                result.append("(");
                result.append(size);
                result.append(")");
            }
        } else if (SIZE_SCALE_FORMAT.equals(format)) {
            if (size > 0) {
                result.append("(");
                result.append(size);
                if (scale != 0) {
                    result.append(", ");
                    result.append(scale);
                }
                result.append(")");
            }
        } else if (format != null) {
            result.append(format);
        } 
        return result.toString();
    }

    public String toString() {
        return super.toString() + "[name=" + name + ";SQLName=" + sqlName + 
            ";format=" + format + "]";
    }
}

