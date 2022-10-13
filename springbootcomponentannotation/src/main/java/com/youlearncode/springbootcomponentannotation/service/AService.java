package com.youlearncode.springbootcomponentannotation.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

@Service("myService")
@ConditionalOnMissingBean
public class AService {}
