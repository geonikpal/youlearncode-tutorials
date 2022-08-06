package com.codelearnhub.springBootProfiles;

import org.springframework.test.context.ActiveProfilesResolver;

public class Resolver implements ActiveProfilesResolver {

    @Override
    public String[] resolve(Class<?> testClass) {
        return new String[]{"unit-tests", "integration-tests"};
    }
}
