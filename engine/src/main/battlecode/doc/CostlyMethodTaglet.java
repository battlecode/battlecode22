package battlecode.doc;

import java.util.List;
import java.util.Set;

import com.sun.source.doctree.DocTree;
import javax.lang.model.element.Element;
import jdk.javadoc.doclet.Taglet;

import battlecode.instrumenter.bytecode.MethodCostUtil;

/**
 * A taglet for the "battlecode.doc.costlymethod" annotation.
 * Only works on methods of classes in the battlecode package.
 */
@SuppressWarnings("unused")
public class CostlyMethodTaglet implements Taglet {
    public static final String TAG_NAME = "battlecode.doc.costlymethod";

    @Override
    public Set<Taglet.Location> getAllowedLocations() {
        return Set.of(Taglet.Location.METHOD);
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
        Element parent = element.getEnclosingElement();
        return docFor(element.getSimpleName().toString(), parent.getSimpleName().toString());
    }

    public String docFor(String methodName, String className) {
        final MethodCostUtil.MethodData data =
                MethodCostUtil.getMethodData(className, methodName);

        final int cost;

        if (data == null) {
            System.err.println("Warning: no method cost for method: " +
                    className + "/" + methodName + "; assuming 0");
            cost = 0;
        } else {
            cost = data.cost;
        }

        return "<dt><strong>Bytecode cost:</strong></dt><dd><code>"
                + cost +
                "</code></dd>";
    }
}
