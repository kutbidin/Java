package test;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		List<Staff> list=new ArrayList<Staff>();
		Staff staff;
		for(int p=0;p<10;p++) {
			staff=new Staff("Aziz"+p,"Oguz"+p);
			list.add(staff);
			
		}
		
		for(Staff stf:list) {
			System.out.println("Name: ["+stf.getName()+"] ID:["+stf.getID()+"]");
		}
        System.out.println("Hello Java 9! ");
	}

}
