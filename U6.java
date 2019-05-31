package qiaw99;
import java.util.Random;

class Circle{
	private double x;
	private double y;
	private double radius;
	public Circle(double x,double y,double radius){
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public double getArea(){
		return Math.PI * Math.pow(radius,2);
	}
	public Circle(){
		this(0,0,10);
	}
	public Circle clone(){
		return new Circle(this.x,this.y,this.radius);
	}
	public int compareTo(Circle c){
		if(this.getArea()<c.getArea()){
			return -1;
		}else if(this.getArea()==c.getArea()){
			return 0;
		}else{
			return 1;
		}
	}
	public boolean contains(Circle c){
		if(Math.sqrt(Math.pow(this.x-c.x,2)+Math.pow(this.y-c.y,2))+c.radius<=this.radius){
			return true;
		}else{
			return false;
		}
	}
	public boolean overlaps(Circle c){
		if(Math.sqrt(Math.pow(this.x-c.x,2)+Math.pow(this.y-c.y,2))>c.radius+this.radius){
			return false;
		}else{
			return true;
		}
	}
	public static Rectangle smallestBoundingRechtangle(Circle [] circles){
		return new Rectangle(0,0,1,1);
	}
}

class Rectangle{
	private int x;
	private int y;
	private int height;
	private int width;
	public Rectangle(int x,int y,int width,int height){
		
	}
}

public class U6{
	public static void main(String args[]){
		int i=(int)(new Random().nextInt(3));
		System.out.println(mul(45,33));
	}
	public static int mul(int a, int b){	//Aufgabe 1
		//Die Komplexitaet ist: log2(n)
		int res=b;		//c1
		if(a==1){
			res+=b;
			return res;
		}else{
			while(a>1){		//log(n)
				a=a>>1;		//c2
				b=b<<1;
				if(a % 2==0){
					res+=0;
				}else{
					res+=b;
				}
			}
			return res;
		}
	}
}
