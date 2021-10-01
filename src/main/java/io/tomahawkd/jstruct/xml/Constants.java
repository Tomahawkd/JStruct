package io.tomahawkd.jstruct.xml;

public class Constants {

    public static final String XSD_VALIDATION_FILE = "jstruct-definitions.xsd";

    // types
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_BYTE = "byte";
    public static final String TYPE_INT2 = "int2";
    public static final String TYPE_INT4 = "int4";
    public static final String TYPE_INT8 = "int8";
    public static final String TYPE_UINT2 = "uint2";
    public static final String TYPE_UINT4 = "uint4";
    public static final String TYPE_UINT8 = "uint8";
    public static final String TYPE_BIGINT = "biginteger";
    public static final String TYPE_BYTEARRAY = "bytearray";
    public static final String TYPE_LENGTH = "length";
    public static final String TYPE_STRING = "string";

    // orders
    public static final String BYTEORDER_BIG = "big";
    public static final String BYTEORDER_LITTLE = "little";
    public static final String BYTEORDER_DEFAULT = "default";

    // general
    private static final String GENERAL_NAME = "name";
    private static final String GENERAL_OFFSET = "offset";
    private static final String GENERAL_LENGTH = "length";
    private static final String GENERAL_MINLENGTH = "minLength";
    private static final String GENERAL_MAXLENGTH = "maxLength";
    private static final String GENERAL_LENGTHREF = "lengthRef";

    // elements
    public static final String ELEMENT = "element";
    public static final String ELEMENT_NAME = GENERAL_NAME;
    public static final String ELEMENT_OFFSET = GENERAL_OFFSET;
    public static final String ELEMENT_LENGTH = GENERAL_LENGTH;
    public static final String ELEMENT_MINLENGTH = GENERAL_MINLENGTH;
    public static final String ELEMENT_MAXLENGTH = GENERAL_MAXLENGTH;
    public static final String ELEMENT_LENGTHREF = GENERAL_LENGTHREF;
    public static final String ELEMENT_TYPE = "type";
    public static final String ELEMENT_CONDITION = "condition";
    public static final String ELEMENT_DYNAMIC = "dynamic";

    // padding
    public static final String PADDING = "padding";
    public static final String PADDING_OFFSET = GENERAL_OFFSET;
    public static final String PADDING_LENGTH = GENERAL_LENGTH;
    public static final String PADDING_MINLENGTH = GENERAL_MINLENGTH;
    public static final String PADDING_MAXLENGTH = GENERAL_MAXLENGTH;
    public static final String PADDING_ALIGN = "align";
    public static final String PADDING_DYNAMIC = "dynamic";

    // choices
    public static final String CHOICES = "choices";
    public static final String CHOICES_NAME = GENERAL_NAME;
    public static final String CHOICES_OFFSET = GENERAL_OFFSET;
    public static final String CHOICES_ID = "identifier";

    // block
    public static final String BLOCK = "block";
    public static final String BLOCK_NAME = GENERAL_NAME;
    public static final String BLOCK_REF = "ref";
    public static final String BLOCK_LENGTH = GENERAL_LENGTH;
    public static final String BLOCK_LENGTHREF = GENERAL_LENGTHREF;
    public static final String BLOCK_BYTEORDER = "byteOrder";

    // sequence
    public static final String SEQUENCE = "sequence";
    public static final String SEQUENCE_NAME = GENERAL_NAME;

    // definition
    public static final String DEFINITION = "definition";
}
