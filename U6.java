package qiaw99;
import java.util.Random;
import java.util.Scanner;

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
		Circle temp=circles[0];
		for(Circle c : circles){
			if(!temp.contains(c)){
				temp=c;
			}
		}
		return new Rectangle(temp.x-temp.radius,temp.y-temp.radius,2*temp.radius,2*temp.radius);
	}
}

class Rectangle{
	private double x;
	private double y;
	private double height;
	private double width;
	public Rectangle(double x,double y,double width,double height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public String getInfo(){
		return "("+this.x+","+this.y+") with width "+this.width+" and height "+this.height;
	}
}
//Aufgabe 6
class ZInteger<A,B>{
	public final int first;		// a)
	public final int second;	//unmutable
	public ZInteger(Integer a,Integer b){	//e)
		this.first=a;
		this.second=b;
	}
	public ZInteger add(ZInteger z){	//b)
		return new ZInteger <A,B> (z.first+this.first,z.second+this.second).simplify();
	}
	public ZInteger sub(ZInteger z){
		return new ZInteger <A,B> (this.first-z.first,this.second-z.second).simplify();
	}
	public ZInteger mul(ZInteger z){
		return new ZInteger <A,B> (this.second*z.first+this.first*z.second,this.second*z.second+this.first*z.first).simplify(); 
	}
	public ZInteger simplify(){			//c)
		int a=this.first;
		int b=this.second;
		if(a>=0){
			while(a>0){
				a-=1;
				b+=1;
			}
		}else{
			while(a<0){
				a+=1;
				b-=1;
			}
		}
		while(a>0){
			a-=1;
			b+=1;
		}
		return new ZInteger(a,b);
	}
	public boolean equal(ZInteger z){		//d)
		if(this.first+this.second==z.first+z.second){
			return true;
		}else{
			return false;
		}
	}
	public boolean smaller(ZInteger z){
		if(this.second-this.first<z.second-z.first){
			return true;
		}else{
			return false;
		}
	}
	public boolean smallerOrEqual(ZInteger z){
		if(this.smaller(z) || this.equal(z)){
			return true;
		}else{
			return false;
		}
	}
	public boolean bigger(ZInteger z){
		if(this.second-this.first>z.second-z.first){
			return true;
		}else{
			return false;
		}
	}
	public boolean biggerOrEqual(ZInteger z){
		if(this.equal(z) || this.bigger(z)){
			return true;
		}else{
			return false;
		}
	}
	public String toString(){	//f)
		return "("+this.first+","+this.second+")";
	}
}

class TestZInteger{		//g)
	public TestZInteger(){}
	public static void test(){
		System.out.println("Test von (1,2) und (2,3)");
		ZInteger z1=new ZInteger(1,2);
		ZInteger z2=new ZInteger(2,3);
		System.out.println("Addition:");
		System.out.println(z1.add(z2).toString());
		System.out.println("Substraktion:");
		System.out.println(z1.sub(z2).toString());
		System.out.println("Multiplikation:");
		System.out.println(z1.mul(z2).toString());
	}
}

public class test{
	public static void main(String args[]){
		int i=(int)(new Random().nextInt(3));
		Scanner scan=new Scanner(System.in);
		
		System.out.println("*********Aufgabe 1*********");		
		System.out.println("Wie ist der Multiplikator?");
		int n=scan.nextInt();
		System.out.println("Wie ist der Multiplikand?");
		int m=scan.nextInt();
		System.out.println("Das Ergebnis: "+mul(n,m));
		System.out.println("*********Aufgabe 6*********");
		TestZInteger.test();		
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
