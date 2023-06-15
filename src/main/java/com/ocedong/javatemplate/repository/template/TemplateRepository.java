package com.ocedong.javatemplate.repository.template;


import com.ocedong.common.generics.AbstractBaseRepository;
import com.ocedong.javatemplate.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TemplateRepository extends JpaRepository<Template, UUID>, IRepository,
    AbstractBaseRepository<Template, UUID>,QuerydslPredicateExecutor<Template> {

}

