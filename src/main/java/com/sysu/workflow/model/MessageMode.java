package com.sysu.workflow.model;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/5
 * Time: 19:31
 * User: zhengshouzi
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: a601097836@gmail.com
 */
public enum MessageMode{

    BROADCAST("ȫ�ֹ㲥",1), TO_OFFSPRING("����㲥",2),TO_CHILD("���ӹ㲥",3),TO_SIBLING("�ֵܹ㲥",4),TO_ANCESTOR("���ȹ㲥",5),MULTICAST("һ��ಥ",6),TO_PARENT("���׵���",7),UNICAST("���ⵥ��",8);

    private String name;
    private int index;


    MessageMode(String name,int index){
        this.name=name;
        this.index=index;
    }

}

