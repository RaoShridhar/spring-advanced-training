package com.github.aha.sat.core.testing.profile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("barbara")
public class BarbaraConfigTest extends AbstractConfigTest {

    @Test
    public void testUserOK() {
        assertThat(user.getName(), equalTo("Barbara"));
        // for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
        // System.out.println(entry.getKey() + "/" + entry.getValue());
        // }

    }

    @Test
    @IfProfileValue(name = "test-group", values = { "training" })
    public void testUserFailure() {
        assertThat(user.getName(), not(equalTo("Arny")));
    }
}
