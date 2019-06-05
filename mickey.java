    public static class Mickey{
    	public static void printMickey(){
    		StdDraw.setXscale(-512,512);
    		StdDraw.setYscale(-512,512);
    		StdDraw.circle(0,0,256);
    		StdDraw.filledCircle(0,0,256);
    		double helperX=256;
    		double helperY=256;
    		double r=256;
    		for(int i=0;i<5;i++){
    			r*=(Math.sqrt(2)-1);
    		    StdDraw.circle(helperX,helperY,r);
        		StdDraw.filledCircle(helperX,helperY,r);	
        		helperX+=r;
        		helperY+=r;
    		}	
    	}
    }
