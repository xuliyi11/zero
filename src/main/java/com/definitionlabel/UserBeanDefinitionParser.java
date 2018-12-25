package com.definitionlabel;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

/*implements BeanDefinitionParser*/

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    //element 对应的类
    protected Class getBeanClass(Element element) {
        return User.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {



        String userName = element.getAttribute("userName");

        String email = element.getAttribute("email");

        bean.addPropertyValue("userName",userName);

        bean.addPropertyValue("email",email);






    }

    /*public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        String id = element.getAttribute("id");

        String userName = element.getAttribute("userName");

        String email = element.getAttribute("email");

        Object source = parserContext.getReaderContext().extractSource(element);
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "user");
        CompositeComponentDefinition compositeDef = new CompositeComponentDefinition(element.getTagName(), source);
        compositeDef.addNestedComponent(new BeanComponentDefinition(definitionHolder));
        parserContext.registerComponent(compositeDef);

        return null;
    }*/
}
