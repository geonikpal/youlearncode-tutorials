import java.util.Collections;
import java.util.List;

public record ImmutableRecord(int aNumber, String aString, List<String> list) {

    public ImmutableRecord(int aNumber, String aString, List<String> list) {
        this.aNumber = aNumber;
        this.aString = aString;
        this.list = Collections.unmodifiableList(list);
    }

}
