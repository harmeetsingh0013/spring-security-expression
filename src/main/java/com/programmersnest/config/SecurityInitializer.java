package com.programmersnest.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{
}
