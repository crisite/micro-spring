package com.crisite.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.crisite.springframework.beans.factory.BeanDefinitionStoreException;
import com.crisite.springframework.beans.factory.config.BeanDefinition;
import com.crisite.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.crisite.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.crisite.springframework.core.io.Resource;
import com.crisite.springframework.core.io.ResourceLoader;
import com.sun.xml.internal.ws.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 14:39
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        try(InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource, e);
        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if(!((childNodes.item(i)) instanceof Element)) continue;
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取 Class, 方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先根据 id 查找 id name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(id)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义 Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            // 读取属性并填充



        }
    }
}
