package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;

public class MemberFileReader {
	Scanner sc = null;
	
	public MemberFileReader(File f) throws FileNotFoundException {
		sc = new Scanner(f);
	}
	public ArrayList<Member> readMember() {
		ArrayList<Member> retObj = new ArrayList<Member>();
		while(sc.hasNext()) {
			Member m = new Member();
			String strArr[] = sc.nextLine().split("\t");
			
			//filedCount : tab + 1갯수, member 객체의 필드수를 설정
			//filedCount : 입력받고자 했던 필드 수
			//strArr
			int fieldCount = 4;
			String newStrArr[] = new String[fieldCount];
			if(fieldCount != strArr.length) 
			{
				for(int i = 0; i < strArr.length; i++)
					newStrArr[i] = strArr[i];
				for(int i = strArr.length; i < fieldCount; i++)
					newStrArr[i] = "";
				}
				else
					newStrArr = strArr;
			
			
			m.setUid(newStrArr[0]);
			m.setUpw(newStrArr[1]);
			m.setUname(newStrArr[2]);
			m.setUbirthday(newStrArr[3]);

			retObj.add(m);			
		}
		return retObj;
	}
}