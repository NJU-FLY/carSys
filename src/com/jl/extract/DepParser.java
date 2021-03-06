package com.jl.extract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.common.Term;

import edu.fudan.nlp.cn.tag.POSTagger;
import edu.fudan.nlp.parser.dep.DependencyTree;
import edu.fudan.nlp.parser.dep.JointParser;
import edu.fudan.util.exception.LoadModelException;

public class DepParser {

	private static JointParser parser;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		parser = new JointParser("models/dep.m");
		String word = "内饰做工差强人意，尤其是前排";
		DepParser de = new DepParser();
		System.out.println(de.deparser(word, "内饰"));
	}


	public String deparser(String sen, String keyword) throws Exception {
		System.out.println(sen + "*******" + keyword);
		parser = new JointParser("models/dep.m");
		String result = test(sen);
		String[] aa = result.split("\n");
		String str1 = aa[3];
		String str2 = aa[1];
		String str3 = aa[0];
		
		String[] bb = str1.split(" ");
        String[] cc = str2.split(" ");
		String[] dd = str3.split(" ");
        
		int length = bb.length;
		int flag1 = -1;

        ArrayList al=new ArrayList();  //存放候选词，词为动词、形容词。。。
		
		if (length > 1) {
			
			
			  //使用fudan Parser处理
			for (int i = 0; i < bb.length; i++) {
				if(bb[i].equals("核心词")){
					flag1=i;
					if(cc[i].equals("形容词")||cc[i].equals("形谓词")||cc[i].equals("副词")){
						return dd[i];
					}
				}
			}
			   //没有结果 ，选择离评价属性词最近的形容词等。。。
			   List  ll=HanLP.segment(sen);
			   for (int i = 0; i < ll.size(); i++) {
				 Term ss=(Term) ll.get(i);
				// System.out.println(ss+"");
				 String[] gg=(ss+"").split("\\/");
				if (gg[1].equals("a")||gg[1].equals("ad")||gg[1].equals("ag")||gg[1].equals("al")||gg[1].equals("z")||gg[1].equals("zg")||gg[1].equals("nz")||gg[1].equals("vl")){
					al.add(i);
					
				 }
			   }
			   if(al.size()!=0){
			   int key_wz=-1;
			   for (int i = 0; i < ll.size(); i++) {
				    Term ss=(Term) ll.get(i);
					if(ss.word.equals(keyword)){
						key_wz=i;
					}
				}
			   if(key_wz!=-1){
			      int min=1000;
			      int qg_wz=-1;
			      for(int t=0;t<al.size();t++){
			       if(key_wz!=(Integer)al.get(t)) { 
				   int vv=Math.abs((Integer)al.get(t)-key_wz);
				   if(vv<min){
					   min=vv;
					   qg_wz=(Integer)al.get(t);
				    }
			       }
			     }
			        if(qg_wz!=-1){
			        Term s=(Term) ll.get(qg_wz);
			        return s.word;}else{
			        	return "";
			        }
			    }
			   }else{
				    return "";
			   }
					
		}
		return "";
				

	}

	private static String test(String word) throws Exception {
		POSTagger tag = new POSTagger("models/seg.m", "models/pos.m");
		String[][] s = tag.tag2Array(word);
		String result = "";
		try {
			// DependencyTree tree = parser.parse2T(s[0],s[1]);
			// System.out.println(tree.toString());
			String stree = parser.parse2String(s[0], s[1], true);
			//System.out.println(stree);
			result = stree;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	

}