package org.zhangam.example.transaction.imports;

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
public class TestImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{TestBeanFactoryPostProcessor.class.getName(), TestBeanDefinitionRegistryPostProcessor.class.getName(), Configuration2.class.getName()};
	}
}