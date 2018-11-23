package location;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle rb;
    private final String RESOURCE_NAME = "location.data";

    ResourceManager() {
        rb = ResourceBundle.getBundle(RESOURCE_NAME, Locale.getDefault());
    }

    public ResourceManager changeResource(Locale locale){
        rb = ResourceBundle.getBundle(RESOURCE_NAME, locale);
        return this;
    }
    public String getString(String key){
        return rb.getString(key);
    }

    public Enumeration getSetKey(){
        return rb.getKeys();
    }
}
