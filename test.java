public static class Mickey{
    	public static void printMickey(){
    		StdDraw.setXscale(-512,512);
    		StdDraw.setYscale(-512,512);
    		StdDraw.circle(0,0,256);
    		StdDraw.filledCircle(0,0,256);
    		double sum=256;
    		double len=256;
    		int i=2;
    		while(len<512*Math.sqrt(2)){
    			i++;
    			sum+=256/i;
    			StdDraw.circle(sum/Math.sqrt(2),sum/Math.sqrt(2),256/i);
    			StdDraw.filledCircle(sum/Math.sqrt(2),sum/Math.sqrt(2),256/i);
    			StdDraw.circle(-sum/Math.sqrt(2),sum/Math.sqrt(2),256/i);
    			StdDraw.filledCircle(-sum/Math.sqrt(2),sum/Math.sqrt(2),256/i);
    			StdDraw.circle(sum/Math.sqrt(2),-sum/Math.sqrt(2),256/i);
    			StdDraw.filledCircle(sum/Math.sqrt(2),-sum/Math.sqrt(2),256/i);
    			StdDraw.circle(-sum/Math.sqrt(2),-sum/Math.sqrt(2),256/i);
    			StdDraw.filledCircle(-sum/Math.sqrt(2),-sum/Math.sqrt(2),256/i);
    			len+=256/i*2;
    			sum+=256/i;
    		}
}
