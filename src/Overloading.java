
public class Overloading {
	public static void main(String[] args){
		C c = new C();
		c.m1();
		System.out.println(((B)c).x);
	}
}

class Test{
	public void m1(String s){System.out.println("string...");}
	public void m1(Object o){System.out.println("Obj...");}
	public void m1(int i){System.out.println("int");}
	public void m1(int...i){System.out.println("var-args");}
	public void m1(Animal a){System.out.println("animal");}
	public void m1(Monkey m){System.out.println("Monkey");}
}

class Animal{}
class Monkey extends Animal{}

class A { int x = 777; public void m1(){ System.out.println("A");}}
class B extends A { int x = 888;  public void m1(){ System.out.println("B");}}
class C extends B { int x = 999;  public void m1(){ System.out.println("c");}}




