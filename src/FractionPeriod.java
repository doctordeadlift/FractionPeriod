import java.util.ArrayList;


class FractionPeriod {
	public FractionPeriod(int m, int n) {
		this.m = m;
		this.n = n;
	}
	
	private int n;
	private int m;
	private int r;
	private int d;
	private int step = 1;
	private int start = 0;
	
	private ArrayList<Integer> rem = new ArrayList<>();
	private ArrayList<Integer> part = new ArrayList<>();

	public String getPeriod() {
		r = m % n;
		d = r * 10 / n;
		rem.add(r);
		part.add(d);
		
		while(true) {
			boolean flag = true;
			r = r * 10 % n;
			d = r * 10 / n;
			for(int i = 0; i < rem.size(); i++) {
				if(rem.get(i) == r) {
					start = i;
					flag = false;
					break;
				}
			}
			if(flag == true) {
				rem.add(r);
				part.add(d);
				step++;
			} else {
				break;
			}
		}
	
		String period = "";
		for(int i = start; i < step; i++) {
			period+=part.get(i);
		}	
	
		return period;
	}
}