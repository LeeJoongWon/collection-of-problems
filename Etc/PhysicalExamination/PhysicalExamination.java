public class PhysicalExamination {
	
	static final int VMAX = 21;	//시력분포
	
	static class PhyscData{
		String 	name;
		int		height;
		double 	vision;
		
		public PhyscData(String name, int height, double vision) {
			this.name	= name;
			this.height	= height;	
			this.vision	= vision;
		}		
	}
	
	//키의 평균값
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i=0; i<dat.length; i++) {
			sum += dat[i].height;
		}
		
		return sum/dat.length;
	}
	
	static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		dist[i] = 0;
		
		for(i = 0; i<dat.length; i++) {
			
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int)(dat[i].vision * 10)]++;
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		PhyscData[] x = {
				new PhyscData("A", 162, 0.3),
				new PhyscData("B", 172, 0.5),
				new PhyscData("C", 153, 0.7),
				new PhyscData("D", 167, 0.8),
				new PhyscData("E", 182, 0.3),
				new PhyscData("F", 195, 0.9),
				new PhyscData("G", 156, 1.5),
		};
		
		int[] vdist = new int[VMAX];
		
		System.out.printf("평균 키:%5.1fcm",aveHeight(x));
		
		distVision(x, vdist);
		
		System.out.println("시력 분포");
		
		for(int i=0; i<VMAX; i++) {
			System.out.printf("%3.1f~:%2d명\n", i/10.0, vdist[i]);
		}
	}
	
}
