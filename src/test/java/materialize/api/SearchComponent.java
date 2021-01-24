package materialize.api;

import io.restassured.RestAssured;
import materialize.api.model.User;

public class SearchComponent {

    private static final String HOST = "https://api.github.com/";
    private static final String USERS_ENDPOINT = "users/";

    protected String buildEndpoint(String host, String... endpoints) {
        StringBuilder url = new StringBuilder(host);
        for (String endpoint : endpoints) {
            url.append(endpoint);
        }
        return url.toString();
    }

    public User findUserByNickname(String nickname) {
        String url = buildEndpoint(HOST, USERS_ENDPOINT, nickname);
        return RestAssured.given().baseUri(url).get().as(User.class);
    }
}
