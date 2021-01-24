package materialize.common;

import java.util.HashMap;

public class ScenarioContext extends HashMap<ContextKey, Object> {
    private static final long serialVersionUID = -3703830234259788761L;

    public <T> T get(Object key, Class<T> clazz) {
        return clazz.cast(super.get(key));
    }
}
