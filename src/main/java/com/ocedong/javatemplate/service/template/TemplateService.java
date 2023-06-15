package com.ocedong.javatemplate.service.template;


import com.ocedong.common.generics.AbstractBaseServiceImpl;
import com.ocedong.javatemplate.domain.Template;
import com.ocedong.javatemplate.repository.template.TemplateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class TemplateService extends AbstractBaseServiceImpl<Template, UUID> implements IService {
    private TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        super(templateRepository);
    }

}
