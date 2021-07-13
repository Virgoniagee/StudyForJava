package com.virgonia.spring5.bean;
/*
* set方法中不能有有参构造器 必须全部加上set() .xml中用property标签填入属性和值
* constructor方法必须有构造器 .xml中的配置既可以是用index 也可以是name
* p名称空间注入不能有参数构造器
* 带特殊符号的转义符必须放在value标签中 只能用在property标签中用value包起来<![CDATA[<<……>>]]>
* */
public class Book {
    private String bName;
    private int bId;
    private double bPrice;

/*    public Book(String bName, int bId, double bPrice) {
        this.bName = bName;
        this.bId = bId;
        this.bPrice = bPrice;
    }*/

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public void setbPrice(double bPrice) {
        this.bPrice = bPrice;
    }

    public String getbName() {
        return bName;
    }

    public int getbId() {
        return bId;
    }

    public double getbPrice() {
        return bPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bName='" + bName + '\'' +
                ", bId=" + bId +
                ", bPrice=" + bPrice +
                '}';
    }
}
