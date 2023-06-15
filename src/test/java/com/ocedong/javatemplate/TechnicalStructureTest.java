package com.ocedong.javatemplate;

import static com.tngtech.archunit.base.DescribedPredicate.alwaysTrue;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.belongToAnyOf;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packagesOf = JavatemplateApp.class, importOptions = DoNotIncludeTests.class)
class TechnicalStructureTest {

    // prettier-ignore
    @ArchTest
    static final ArchRule respectsTechnicalArchitectureLayers = layeredArchitecture()
        .layer("Config").definedBy("..config..")
        .layer("Client").definedBy("..client..")
        .layer("Web").definedBy("..web..")
        .optionalLayer("ServiceImpl").definedBy("..service..")
        .layer("Security").definedBy("..security..")
        .layer("Persistence").definedBy("..repository..")
        .layer("Domain").definedBy("..domain..")

        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
        .whereLayer("Client").mayNotBeAccessedByAnyLayer()
        .whereLayer("Web").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("ServiceImpl").mayOnlyBeAccessedByLayers("Web", "Config")
        .whereLayer("Security").mayOnlyBeAccessedByLayers("Config", "Client", "ServiceImpl", "Web")
        .whereLayer("Persistence").mayOnlyBeAccessedByLayers("ServiceImpl", "Security", "Web", "Config")
        .whereLayer("Domain").mayOnlyBeAccessedByLayers("Persistence", "ServiceImpl", "Security", "Web", "Config")

        .ignoreDependency(belongToAnyOf(JavatemplateApp.class), alwaysTrue())
        .ignoreDependency(alwaysTrue(), belongToAnyOf(
            com.ocedong.javatemplate.config.Constants.class,
            com.ocedong.javatemplate.config.ApplicationProperties.class
        ));
}
