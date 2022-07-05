package org.zhangam.example.transaction.imports;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.zhangam.example.transaction.processor.TestBeanDefinitionRegistryPostProcessor;
import org.zhangam.example.transaction.processor.TestBeanFactoryPostProcessor;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/6/27
 */
public class TestDeferredImportSelector implements DeferredImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{Configuration1.class.getName()};
	}
}