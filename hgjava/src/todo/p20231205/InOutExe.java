package todo.p20231205;

import java.util.*;

public class InOutExe {
	static ArrayList<InOut> inOut;
	
	InOutExe() {
		inOut = new ArrayList<InOut>();
		inOut.add(new InOut("p001", 10, "구매"));
		inOut.add(new InOut("p001", 2, "판매"));
		inOut.add(new InOut("p001", 3, "판매"));
	}

	boolean prodSellAdd(InOut inouts) {
		return inOut.add(inouts);
	}
	
	
	ArrayList<InOut> prodSum() {
		ArrayList<InOut> rem = new ArrayList<InOut>();
		String[] a = new String[inOut.size()];
		int[] b = new int[inOut.size()];
		
		int count =0;
		
		for(int i=0;i<inOut.size();i++) {
			if(!inOut.get(i).getProdCode().equals(a[count])) {
				a[count] = inOut.get(i).getProdCode();
				count++;
			}
		}
		
		for(int i=0;i<inOut.size();i++) {
			for(int j=0;j<a.length;j++) {
				if(inOut.get(i).getProdCode().equals(a[j]) && inOut.get(i).getBuySell().equals("구매") && a[j] !=null) {
					b[j] += inOut.get(j).getProdNum();
				}else if(inOut.get(i).getProdCode().equals(a[j]) && inOut.get(i).getBuySell().equals("판매") && a[j] !=null) {
					b[j] -= inOut.get(j).getProdNum();
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			rem.add(new InOut(a[i], b[i], ""));
		}
		
		return rem;
	}

	
}
