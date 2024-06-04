package com.crisite.springframework.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.crisite.springframework.beans.factory.config.BeanDefinition;
import com.crisite.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.crisite.springframework.test.bean.UserService;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Rao Sheng
 * @Date: 2024/3/30 18:23
 */
public class ApiTest {
    @Test
    public void createBeantest() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, null);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUser();
    }

    @Test
    public void sorttest() {
        String delOrder = "D6->D5->D4->D2->D1->D8->D7->D3->3D-D6->3D-D5->3D-D4->3D-D2->3D-D1->3D-D8->3D-D7->3D-D3->E3->E2->E1->F2->A->F1->FDD-900->FDD-1800";

        ArrayList<CommunityInfoDTO> communityInfoList = new ArrayList<>();

        communityInfoList.add(new CommunityInfoDTO("D5"));
        communityInfoList.add(new CommunityInfoDTO("3D-D5"));
        communityInfoList.add(new CommunityInfoDTO("3D-D6"));
        communityInfoList.add(new CommunityInfoDTO("D1"));
        communityInfoList.add(new CommunityInfoDTO("E1"));
        communityInfoList.add(new CommunityInfoDTO("D7"));

        List<CommunityInfoDTO> srotedList = communityInfoList.stream()
                .sorted(Comparator.comparing(communityInfoDTO -> delOrder.indexOf(communityInfoDTO.getFrequencyOffset())))
                .collect(Collectors.toList());

        System.out.println(srotedList.toString());
    }

    @Test
    public void containsTest() {
        String test1 = "D7";
    }

    @Test
    public void referenceTest() {
        CommunityInfoDTO communityInfoDTO = new CommunityInfoDTO("3D-D5");

        ArrayList<CommunityInfoDTO> communityInfoDTOS = new ArrayList<>();

        communityInfoDTOS.add(communityInfoDTO);

        changeCommunityInfoDTO(communityInfoDTOS.get(0));

        System.out.println(communityInfoDTO.frequencyOffset);

    }

    public void changeCommunityInfoDTO(CommunityInfoDTO communityInfoDTO) {
        communityInfoDTO.setFrequencyOffset("test");
    }

    @Test
    public void OptionalTest() {
        ArrayList<OptionalDTO> optionalDTOS = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            OptionalDTO optionalDTO = new OptionalDTO();
            optionalDTO.setName("ss");
            optionalDTO.setCommunityInfoDTO(new CommunityInfoDTO("3D-D5"));
            Optional.of(optionalDTO)
                    .map(OptionalDTO::getCommunityInfoDTO)
                    .ifPresent(System.out::println);
            optionalDTOS.add(optionalDTO);
        }
        System.out.println(optionalDTOS);

    }

    @Test
    public void setTest(){
        HashSet<String> strings = new HashSet<>();
        strings.add("");
        System.out.println(strings);
        strings.add(null);
        System.out.println(strings);
        strings.remove("");
        strings.remove(null);

        ArrayList<String> list = new ArrayList<>();
        list.add("");
        System.out.println(list);
        list.add(null);
        System.out.println(list);
        list.remove("");
        list.remove(null);
    }

    @Test
    public void jsonTest() {

    }

    @Test
    public void timeTest() {
        System.out.println(LocalDateTime.now());
        System.out.println(System.currentTimeMillis());
    }

    public void exceptionTest() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            System.out.println("test catch exception");
            e.printStackTrace();
        }
    }

    @Test
    public void exceptionTest2() {
        try {
            exceptionTest();
        } catch (Exception e) {
            System.out.println("test2 catch exception");
            e.printStackTrace();
        }
    }

    class CommunityInfoDTO {
        private String frequencyOffset;

        public String getFrequencyOffset() {
            return frequencyOffset;
        }

        public void setFrequencyOffset(String frequencyOffset) {
            this.frequencyOffset = frequencyOffset;
        }

        public CommunityInfoDTO(String frequencyOffset) {
            this.frequencyOffset = frequencyOffset;
        }
        @Override
        public String toString() {
            return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                    SerializerFeature.WriteNullBooleanAsFalse,
                    SerializerFeature.UseISO8601DateFormat);
        }
    }


    class OptionalDTO {
        private String name;

        private CommunityInfoDTO CommunityInfoDTO;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CommunityInfoDTO getCommunityInfoDTO() {
            return CommunityInfoDTO;
        }

        public void setCommunityInfoDTO(CommunityInfoDTO communityInfoDTO) {
            CommunityInfoDTO = communityInfoDTO;
        }

        @Override
        public String toString() {
            return "OptionalDTO{" +
                    "name='" + name + '\'' +
                    ", CommunityInfoDTO=" + CommunityInfoDTO +
                    '}';
        }
    }
}
