import java.util.Collections;
import java.util.List;

public final class ImmutableClass {

    private final int aNumber;
    private final String aString;
    private final List<String> list;

    public int getaNumber() {
        return aNumber;
    }

    public String getaString() {
        return aString;
    }

    public List<String> getList() {
        return list;
    }

    public ImmutableClass(int aNumber, String aString, List<String> list) {
        this.aNumber = aNumber;
        this.aString = aString;
        this.list = Collections.unmodifiableList(list);
    }

}
