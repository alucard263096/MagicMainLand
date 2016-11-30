package com.helpfooter.magicmainland.Classes;

import java.util.ArrayList;
import java.util.Random;

public class Ability {
	
	public int hp;
	//ħ����
	public int mp;
	//������
	public int act;
	//����
	public int def;
	//�ٶ�
	public int spd;
	//����
	public int tec;
	//ħ��
	public int mgact;
	//ħ��
	public int mgdef;
	//����
	public int lck;
	
	public Ability(int hp,int mp,int act,int def,int spd,int tec,int mgact,int mgdef,int lck){
		this.hp=hp;
		this.mp=mp;
		this.act=act;
		this.def=def;
		this.spd=spd;
		this.tec=tec;
		this.mgact=mgact;
		this.mgdef=mgdef;
		this.lck=lck;
	}
	
	public static Ability SumAblitity(ArrayList<Ability> alAbs){
		Ability abs=new Ability(0,0,0,0,0,0,0,0,0);
		
		for(Ability a:alAbs){
			abs.hp+=a.hp;
			abs.mp+=a.mp;
			abs.act+=a.act;
			abs.def+=a.def;
			abs.spd+=a.spd;
			abs.tec+=a.tec;
			abs.mgact+=a.mgact;
			abs.mgdef+=a.mgdef;
			abs.lck+=a.lck;
		}
		
		return abs;
	}
	
	public static Ability GetRandom(){
		Random r=new Random();
		Ability abs=new Ability(r.nextInt(1000),
				r.nextInt(1000),
				r.nextInt(100),
				r.nextInt(100),
				r.nextInt(100),
				r.nextInt(100),
				r.nextInt(100),
				r.nextInt(100),
				r.nextInt(100));
		
		return abs;
	}

	public String getDesciption() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		if(hp!=0){
			sb.append("����ֵ");
			if(hp>0){
				sb.append("+");
			}
			sb.append(hp);
			sb.append(" ");
		}
		if(mp!=0){
			sb.append("ħ��ֵ");
			if(mp>0){
				sb.append("+");
			}
			sb.append(mp);
			sb.append(" ");
		}
		if(act!=0){
			sb.append("����");
			if(act>0){
				sb.append("+");
			}
			sb.append(act);
			sb.append(" ");
		}
		if(def!=0){
			sb.append("����");
			if(def>0){
				sb.append("+");
			}
			sb.append(def);
			sb.append(" ");
		}
		if(spd!=0){
			sb.append("�ٶ�");
			if(spd>0){
				sb.append("+");
			}
			sb.append(spd);
			sb.append(" ");
		}
		if(tec!=0){
			sb.append("����");
			if(tec>0){
				sb.append("+");
			}
			sb.append(tec);
			sb.append(" ");
		}
		if(mgact!=0){
			sb.append("ħ��");
			if(mgact>0){
				sb.append("+");
			}
			sb.append(mgact);
			sb.append(" ");
		}
		if(mgdef!=0){
			sb.append("ħ��");
			if(mgdef>0){
				sb.append("+");
			}
			sb.append(mgdef);
			sb.append(" ");
		}
		if(lck!=0){
			sb.append("����");
			if(lck>0){
				sb.append("+");
			}
			sb.append(lck);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public String getItemStr(String name,int value){
		StringBuilder sb=new StringBuilder();
		sb.append(name);
		if(value>0){
			sb.append("+");
		}
		sb.append(value);
		
		return sb.toString();
	}

	public ArrayList<String> getListDesciption() {
		// TODO Auto-generated method stub
		ArrayList<String> alStr=new ArrayList<String>();
		
		alStr.add(getItemStr("����ֵ",hp));
		alStr.add(getItemStr("ħ��ֵ",mp));
		alStr.add(getItemStr("����",act));
		alStr.add(getItemStr("����",def));
		alStr.add(getItemStr("�ٶ�",spd));
		alStr.add(getItemStr("����",tec));
		alStr.add(getItemStr("ħ��",mgact));
		alStr.add(getItemStr("ħ��",mgdef));
		alStr.add(getItemStr("����",lck));
		
		return alStr;
	}
}
