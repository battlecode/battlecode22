package battlecode.doc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import com.sun.source.doctree.DocTree;
import javax.lang.model.element.Element;
import jdk.javadoc.doclet.Taglet;

import battlecode.common.RobotType;

/**
 * Taglet for annotating the individual variants of RobotType.
 * Will only work on RobotType.
 */
public class RobotTypeTaglet implements Taglet {
    public static final String TAG_NAME = "battlecode.doc.robottype";

    @Override
    public Set<Taglet.Location> getAllowedLocations() {
        return Set.of(Taglet.Location.FIELD);
    }

    @Override
    public String getName() {
        return TAG_NAME;
    }

    @Override
    public boolean isInlineTag() {
        return false;
    }

    @Override
    public String toString(List<? extends DocTree> tags, Element element) {
        if (tags.size() != 1) {
            throw new IllegalArgumentException("Too many @"+TAG_NAME+" tags: "+tags.size());
        }
        return docFor(element.getSimpleName().toString());
    }

    static public void append(StringBuilder builder, String label, String value) {
        builder.append(String.format("<dt><strong>%s:</strong></dt>" +
                "<dd>%s</dd>", label, value));
    }

    /**
     * Return a link to the documentation for a field in a javadoc.
     * Relies on javadoc-internal details.
     *
     * @param fieldName the name of the field to link to
     * @return an inline link to the field
     */
    private static String getInlineFieldLink(String fieldName) {
        return String.format(
                "<code><span class=\"memberNameLink\"><a href=\"#%s\">%s</a></span></code>",
                fieldName, fieldName
        );
    }

    /**
     * Return a link to the documentation for a method in a javadoc.
     * Relies on javadoc-internal details.
     *
     * @param methodName the name of the method to link to
     * @return an inline link to the method
     */
    private static String getInlineMethodLink(String methodName) {
        return String.format(
                // for some reason methods are linked to as "#methodName--"
                "<code><span class=\"memberNameLink\"><a href=\"#%s--\">%s</a></span>()</code>",
                methodName, methodName
        );
    }

    /**
     * Return text surrounded by code tags.
     *
     * @param text the text to surround
     * @return text surrounded by code tags
     */
    private static String asCode(String text) {
        return "<code>" + text + "</code>";
    }

    /**
     * Appends a field annotation to the documentation for a variant.
     *
     * @param builder the builder to append to
     * @param variant the variant to document
     * @param fieldName the field to document
     */
    private static void appendField(StringBuilder builder,
                                          RobotType variant,
                                          String fieldName)
            throws NoSuchFieldException, IllegalAccessException {

        final Field field = RobotType.class.getField(fieldName);

        final String value;

        if (field.getType() == int.class) {
            value = asCode(Integer.toString(field.getInt(variant)));
        } else if (field.getType() == float.class) {
            value = asCode(String.format("%1.1f", field.getFloat(variant)));
        } else if (field.getType() == double.class) {
            value = asCode(String.format("%1.0f", field.getDouble(variant)));
        } else if (field.getType() == boolean.class) {
            value = asCode(Boolean.toString(field.getBoolean(variant)));
        } else if (field.getType() == RobotType.class) {
            final RobotType targetType = (RobotType) field.get(variant);
            value = getInlineFieldLink(targetType.name());
        } else {
            throw new IllegalArgumentException("Add documentation generation for fields" +
                    " of type " + field.getType().getSimpleName());
        }

        builder.append(getInlineFieldLink(fieldName));
        builder.append(": ");
        builder.append(value);
        builder.append("<br />");
    }

    /**
     * Appends a method annotation to the documentation for a variant.
     *
     * @param builder the builder to append to
     * @param variant the variant to document
     * @param methodName the method to document
     */
    private static void appendMethod(StringBuilder builder,
                                          RobotType variant,
                                          String methodName)
            throws NoSuchMethodException,IllegalAccessException,InvocationTargetException {

        final Method method = RobotType.class.getMethod(methodName);

        final String value;

        if (method.getReturnType() == boolean.class) {
            value = asCode(method.invoke(variant).toString());
        } else {
            throw new IllegalArgumentException("Add documentation generation for methods" +
                    " that return " + method.getReturnType().getSimpleName());
        }

        builder.append(getInlineMethodLink(methodName));
        builder.append(": ");
        builder.append(value);
        builder.append("<br />");
    }

    public String docFor(String variant) {
        RobotType rt;
        try {
            rt = RobotType.valueOf(variant);
        } catch (IllegalArgumentException e) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        try {
            appendField(builder, rt, "buildCostLead");
            builder.append("<br />");
            appendField(builder, rt, "buildCostGold");
            builder.append("<br />");
            appendField(builder, rt, "actionCooldown");
            builder.append("<br />");
            appendField(builder, rt, "movementCooldown");
            builder.append("<br />");
            appendField(builder, rt, "health");
            builder.append("<br />");
            appendField(builder, rt, "damage");
            builder.append("<br />");
            appendField(builder, rt, "actionRadiusSquared");
            builder.append("<br />");
            appendField(builder, rt, "visionRadiusSquared");

            if (rt.bytecodeLimit != 0) {
                builder.append("<br />");
                appendField(builder, rt, "bytecodeLimit");
            }

            // TODO: add docs for methods
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
