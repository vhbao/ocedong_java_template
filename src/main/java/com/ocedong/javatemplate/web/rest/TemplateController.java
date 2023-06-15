package com.ocedong.javatemplate.web.rest;


import com.ocedong.common.generics.AbstractBaseController;
import com.ocedong.javatemplate.domain.Template;
import com.ocedong.javatemplate.service.template.TemplateService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/templates")
public class TemplateController extends AbstractBaseController<Template, UUID> {
    private  TemplateService templateService;
    public TemplateController(TemplateService templateService) {
        super(templateService);
    }
    @Override
    public ResponseEntity<Object> GetListItems(@RequestParam(defaultValue="0") Integer page, @RequestParam(defaultValue = "20") Integer size,
                                               @RequestParam(defaultValue="createdDate-asc", required = false) List<String> sorts, @QuerydslPredicate(root = Template.class) Predicate predicates) {
        return super.GetListItems(page, size, sorts, predicates);
    }
}
