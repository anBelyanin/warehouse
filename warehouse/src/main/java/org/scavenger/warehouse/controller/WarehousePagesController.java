package org.scavenger.warehouse.controller;

import com.fasterxml.jackson.databind.introspect.Annotated;
import org.aspectj.weaver.AnnotationValue;
import org.scavenger.warehouse.common.annotation.Authenticate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warehouse")
public class WarehousePagesController {

    @Authenticate
    @GetMapping("/main")
    public String getMainPage() {
        return "homepage";
    }
}
