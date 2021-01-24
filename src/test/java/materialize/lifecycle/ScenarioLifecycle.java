package materialize.lifecycle;

import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import materialize.common.ScenarioContext;

@RequiredArgsConstructor
public class ScenarioLifecycle {
    
    private final ScenarioContext scenarioContext;

    @Before
    public void clearContext() {
        scenarioContext.clear();
    }
}
