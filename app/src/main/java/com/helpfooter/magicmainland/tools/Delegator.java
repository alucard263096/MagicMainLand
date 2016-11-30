package com.helpfooter.magicmainland.tools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
   
public abstract class Delegator implements InvocationHandler {
    //--------------------------------------------

    protected Object obj_orgin = null; //ԭʼ����
    protected Object obj_proxy = null; //�������
    //--------------------------------------------

    public Delegator() {
    }

    public Delegator(Object orgin) {
        this.createProxy(orgin);
    }
   

    protected Object createProxy(Object orgin) {
        obj_orgin = orgin;
        //���������orgin.getClass().getClassLoader()Ϊ��������orgin.getClass().getInterfaces()Ϊ�ӿڼ�
        obj_proxy = Proxy.newProxyInstance(orgin.getClass().getClassLoader(), orgin.getClass().getInterfaces(), this); //ί��
        return obj_proxy;
    }
   

    protected Object invokeSuper(Method method, Object[] args) throws Throwable {
        return method.invoke(obj_orgin, args);
    }
    //--------------ʵ��InvocationHandler�ӿڣ�Ҫ�󸲸�------------
    //����ʵ�ֵķ����ǵ�ί�е������toString()����ʱ�������������������Ǹ���Ĭ�ϵ�toString()�����������������򲻻ᡣ

    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        // ȱʡʵ�֣�ί�и�obj_orgin��ɶ�Ӧ�Ĳ���
        if (method.getName().equals("toString")) { //���������⴦��
            return this.invokeSuper(method, args) + "$Proxy";
        } else { //ע�⣬����ԭʼ����ķ����������Ǵ���ģ�obj==obj_proxy��
            return this.invokeSuper(method, args);
        }
    }
}