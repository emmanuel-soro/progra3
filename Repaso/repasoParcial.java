class Alpha {
String getType() { return "alpha"; }
}
class Beta extends Alpha {
String getType() { return "beta"; }
}
class Gamma extends Beta {
String getType() { return "gamma"; }

public static void main(String[] args) {
Gamma g1 = new Alpha();
Gamma g2 = new Beta();
System.out.println(g1.getType() + " "+ g2.getType());
}
}

alpha beta
beta beta
gamma gamma
alpha alpha
Compilation fails.
-------------------------------------------------------------
public class Feline {
	public String type = "f ";
	public Feline() {
		System.out.print("feline ");
	}
}
public class Cougar extends Feline {
	public Cougar() {
		System.out.print("cougar ");
	}
	public static void main(String[] args) {
		new Cougar().go();
	}
	void go() {
		type = "c ";
		System.out.print(this.type + super.type);
	}
}

-------------------------------------------------------------
public class Alpha { 		
	public void foo() { System.out.print("Afoo "); } 	
} 		
public class Beta extends Alpha { 		
	public void foo() { System.out.print("Bfoo "); } 	
	
	public static void main(String[] args) { 	
		Alpha a = new Beta(); 
		Beta b = (Beta)a; 
		a.foo(); 
		b.foo(); 
	} 	
}
-------------------------------------------------------------
%Teniendo en cuenta:

class ClassA {} 				
class ClassB extends ClassA {} 				
class ClassC extends ClassA {} 

ClassA p0 = new ClassA(); 				
ClassB p1 = new ClassB(); 				
ClassC p2 = new ClassC(); 				
ClassA p3 = new ClassB(); 				
ClassA p4 = new ClassC(); 				

Cuales son validas?
-------------------------------------------------------------
p0 = p1; 				
p1 = p2;				
p2 = p4; 			
p2 = (ClassC)p1;				
p1 = (ClassB)p3; 				
p2 = (ClassC)p4;.
		
2 *. Dado:
public class MyLoop {
public static void main(String[] args) {
String[] sa = {"tom ", "jerry "};
for(int x = 0; x < 3; x++) {
for(String s: sa) {
System.out.print(x + " " + s);
if( x == 1) break;
}
}
}
}
Devuelve:
A) 0 tom 0 jerry 1 tom
B) 0 tom 0 jerry 1 tom 1 jerry
C) 0 tom 0 jerry 2 tom 2 jerry
D) 0 tom 0 jerry 1 tom 2 tom 2 jerry
E) 0 tom 0 jerry 1 tom 1 jerry 2 tom 2 jerry
F) Compilation fails.
............................
public class Batman { 		
	int squares = 81; 	
	public static void main(String[] args) { 	
		new Batman().go(); 
	} 	
	void go() { 	
		incr(++squares); 
		System.out.println(squares); 
	} 	
	void incr(int squares) { squares += 10; } 	
} 		

 81
 82 		
 91 		
 92 		
 Compilation fails. 		
 An exception is thrown at runtime.	
------------------------------------------------------