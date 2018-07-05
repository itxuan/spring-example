package com.xuan.beanconfig;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 10:00  七月
 * @Description:
 * @ModifyBy:
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * Determine whether this filter matches for the class described by
     * the given metadata.
     * @param metadataReader the metadata reader for the target class
     * @param metadataReaderFactory a factory for obtaining metadata readers
     * for other classes (such as superclasses and interfaces)
     * @return whether this filter matches
     * @throws IOException in case of I/O failure when reading metadata
     */

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类资源（类路径）
        Resource resource = metadataReader.getResource();

        System.out.println("正在扫描的类: ---->"+classMetadata.getClassName());
        return false;
    }
}
