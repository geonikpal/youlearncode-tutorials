package com.codelearnhub.springBootProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev"})
public class SimpleComponent {

}
