package com.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.util.*;

public class JacksonTest {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        User user=new User();
        user.setId("01");
        user.setName("张三");
        user.setAge(33);
        user.setPay(6666.88);
        user.setValid(true);
        user.setOne('E');
        user.setBirthday(new Date(20l*366*24*3600*1000)); //1990年

        Link link = new Link();
        link.setAddress("河南省济源市");
        link.setPhone("13899995555");
        link.setQq("123456");
        user.setLink(link);

        Map map=new HashMap();
        map.put("aa", "this is aa");
        map.put("bb", "this is bb");
        map.put("cc", "this is cc");
        user.setMap(map);

        List list=new ArrayList(){};
        list.add("普洱");
        list.add("大红袍");
        user.setList(list);

        Set set=new HashSet();
        set.add("篮球");
        set.add("足球");
        set.add("乒乓球");
        user.setSet(set);

        ObjectMapper mapper = new ObjectMapper(); //转换器

        //测试01：对象--json
        String json=mapper.writeValueAsString(user); //将对象转换成json
        System.out.println(json);
        /* 结果如下：
        {"id":"01","name":"张三","age":33,"pay":6666.88,"valid":true,"one":"E","birthday":1465185448998,
        "link":{"phone":"13899995555","address":"河南省济源市","qq":"123456"},
        "map":{"aa":"this is aa","bb":"this is bb","cc":"this is cc"},
        "list":["普洱","大红袍"],
        "set":["乒乓球","足球","篮球"]}

        注意点：（1） 日期--长整型 （2）List、Set均转成数组
         */

        //测试02：json--map
        Map m = mapper.readValue(json, Map.class); //json转换成map

        System.out.println("pay："+m.get("pay").getClass().getName()); //java.lang.Double
        System.out.println("valid："+m.get("valid").getClass().getName()); //java.lang.Boolean
        System.out.println("birthday："+m.get("birthday").getClass().getName()); //java.lang.Long
        System.out.println("link："+m.get("link").getClass().getName()); //java.util.LinkedHashMap
        System.out.println("map："+m.get("map").getClass().getName()); //java.util.LinkedHashMap
        System.out.println("list："+m.get("list").getClass().getName()); //java.util.ArrayList
        System.out.println("set："+m.get("set").getClass().getName()); //java.util.ArrayList
        /*  结果如下：
            pay：java.lang.Double
            valid：java.lang.Boolean
            birthday：java.lang.Long
            link：java.util.LinkedHashMap
            map：java.util.LinkedHashMap
            list：java.util.ArrayList
            set：java.util.ArrayList

            注意点：（1） 日期--长整型  （2）map、子对象均转换成了LinkedHashMap （3）List、Set均转成ArrayList
         */

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //测试03：map--json
        json=mapper.writeValueAsString(m); //map转json
        System.out.println(json); //与之前格式完全相同，说明经过map转换后，信息没有丢失

        //测试04：json--对象
        User u=mapper.readValue(json, User.class); //json转java对象。经测，转成对象后，一切恢复正常
        System.out.println("pay："+u.getPay());
        System.out.println("valid："+u.isValid());
        System.out.println("birthday："+u.getBirthday());
        System.out.println("link："+u.getLink().getAddress());
        System.out.println("map："+u.getMap());
        System.out.println("list："+u.getList());
        System.out.println("set："+u.getSet());

        //测试05：其他转换
        byte[] data=mapper.writeValueAsBytes(u); //对象转成二进制数组
    }
}

class Link
{
    private String phone; //移动电话
    private String address; //地址
    private String qq; //QQ


    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getQq()
    {
        return qq;
    }
    public void setQq(String qq)
    {
        this.qq = qq;
    }
}

class User
{
   private String id; //标识
   private String name;	//姓名
   private int age;	//年龄
   private double pay;	//工资
   private boolean valid;	//是否有效
   private char one; //一个字符
   @JsonFormat(pattern = "yyyy-mm-dd")
   private Date birthday;	//生日

   private Link link; //联系方式，自定义

   private Map map; //测试用
   private List list; //测试用
   private Set set; //测试用

   public String getId()
   {
       return id;
   }
   public void setId(String id)
   {
       this.id = id;
   }
   public String getName()
   {
       return name;
   }
   public void setName(String name)
   {
       this.name = name;
   }
   public int getAge()
   {
       return age;
   }
   public void setAge(int age)
   {
       this.age = age;
   }
   public double getPay()
   {
       return pay;
   }
   public void setPay(double pay)
   {
       this.pay = pay;
   }
   public boolean isValid()
   {
       return valid;
   }
   public void setValid(boolean valid)
   {
       this.valid = valid;
   }
   public char getOne()
   {
       return one;
   }
   public void setOne(char one)
   {
       this.one = one;
   }
   public Date getBirthday()
   {
       return birthday;
   }
   public void setBirthday(Date birthday)
   {
       this.birthday = birthday;
   }
   public Link getLink()
   {
       return link;
   }
   public void setLink(Link link)
   {
       this.link = link;
   }
   public Map getMap()
   {
       return map;
   }
   public void setMap(Map map)
   {
       this.map = map;
   }
   public List getList()
   {
       return list;
   }
   public void setList(List list)
   {
       this.list = list;
   }
   public Set getSet()
   {
       return set;
   }
   public void setSet(Set set)
   {
       this.set = set;
   }
}

