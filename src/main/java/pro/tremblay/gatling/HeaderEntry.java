package pro.tremblay.gatling;

import java.util.AbstractMap;

/**
 * @author Henri Tremblay
 */
public class HeaderEntry extends AbstractMap.SimpleImmutableEntry<String, String> {

    public HeaderEntry(String key, String value) {
        super(key, value);
    }

}
